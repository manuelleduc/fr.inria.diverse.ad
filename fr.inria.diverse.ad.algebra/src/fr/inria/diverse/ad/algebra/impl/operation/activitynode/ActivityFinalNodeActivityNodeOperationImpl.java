package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivityFinalNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class ActivityFinalNodeActivityNodeOperationImpl implements ActivityNodeOperation {
	private final ActivityFinalNode activityFinalNode;
	private final ExecutableADAlgebra alg;

	public ActivityFinalNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final ActivityFinalNode activityFinalNode) {
		this.activityFinalNode = activityFinalNode;
		this.alg = alg;
	}

	@Override
	public List<Token> takeOfferdTokens() {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : this.activityFinalNode.getIncoming()) {
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
		this.activityFinalNode.setRunning(true);

	}

	@Override
	public void fire(final List<Token> tokens) {
		this.alg.$(this.activityFinalNode.getActivity()).terminate();

	}

	@Override
	public void terminate() {
		this.activityFinalNode.setRunning(false);

	}

	@Override
	public void addTokens(final List<Token> tokens) {
		for (final Token token : tokens) {
			final Token transferredToken = this.alg.$(token).transfer(this.activityFinalNode);
			this.activityFinalNode.getHeldTokens().add(transferredToken);
		}
	}

	@Override
	public void removeToken(final Token token) {
		this.activityFinalNode.getHeldTokens().remove(token);

	}

	@Override
	public void sendOffers(final List<Token> tokens) {
		for (final ActivityEdge edge : this.activityFinalNode.getOutgoing()) {
			edge.sendOffer(tokens);
		}
	}
}