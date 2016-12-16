package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.InitialNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class InitialNodeActivityNodeOperationImpl implements ActivityNodeOperation {
	private final InitialNode initialNode;
	private final ExecutableADAlgebra alg;

	public InitialNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg , final InitialNode initialNode) {
		this.initialNode = initialNode;
		this.alg = alg;
	}

	@Override
	public List<Token> takeOfferdTokens() {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : this.initialNode.getIncoming()) {
			final List<Token> tokens = this.alg.$(edge).takeOfferedTokens();
			for (final Token token : tokens) {
				this.alg.$(token).withdraw();
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public void run() {
		this.initialNode.setRunning(true);

	}

	@Override
	public void fire(final List<Token> tokens) {
		final List<Token> producedTokens = new ArrayList<Token>();
		producedTokens.add(ActivitydiagramFactory.eINSTANCE.createControlToken());
		this.addTokens(producedTokens);
		this.sendOffers(producedTokens);

	}

	@Override
	public void sendOffers(final List<Token> tokens) {
		for (final ActivityEdge edge : this.initialNode.getOutgoing()) {
			edge.sendOffer(tokens);
		}

	}

	@Override
	public void addTokens(final List<Token> tokens) {
		for (final Token token : tokens) {
			final Token transferredToken = this.alg.$(token).transfer(this.initialNode);
			this.initialNode.getHeldTokens().add(transferredToken);
		}

	}

	@Override
	public void terminate() {
		this.initialNode.setRunning(false);

	}

	@Override
	public void removeToken(final Token token) {
		this.initialNode.getHeldTokens().remove(token);

	}
}