package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.ForkNode;
import activitydiagram.ForkedToken;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class ForkNodeActivityNodeOperationImpl implements ActivityNodeOperation {
	private final ForkNode forkNode;
	private final ExecutableADAlgebra alg;

	public ForkNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final ForkNode forkNode) {
		this.forkNode = forkNode;
		this.alg = alg;
	}

	@Override
	public List<Token> takeOfferdTokens() {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : this.forkNode.getIncoming()) {
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
		this.forkNode.setRunning(true);

	}

	@Override
	public void fire(final List<Token> tokens) {
		// TODO
		final List<Token> forkedTokens = new ArrayList<Token>();
		for (final Token token : tokens) {
			final ForkedToken forkedToken = ActivitydiagramFactory.eINSTANCE.createForkedToken();
			forkedToken.setBaseToken(token);
			forkedToken.setRemainingOffersCount(this.forkNode.getOutgoing().size());
			forkedTokens.add(forkedToken);
		}
		this.addTokens(forkedTokens);
		this.sendOffers(forkedTokens);

	}

	@Override
	public void sendOffers(final List<Token> tokens) {
		for (final ActivityEdge edge : this.forkNode.getOutgoing()) {
			edge.sendOffer(tokens);
		}

	}

	@Override
	public void addTokens(final List<Token> tokens) {
		for (final Token token : tokens) {
			final Token transferredToken = this.alg.$(token).transfer(this.forkNode);
			this.forkNode.getHeldTokens().add(transferredToken);
		}

	}

	@Override
	public void terminate() {
		this.forkNode.setRunning(false);

	}

	@Override
	public void removeToken(final Token token) {
		this.forkNode.getHeldTokens().remove(token);

	}
}