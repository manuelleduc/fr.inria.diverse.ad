package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.BooleanValue;
import activitydiagram.ControlFlow;
import activitydiagram.DecisionNode;
import activitydiagram.Token;
import activitydiagram.Value;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class DecisionNodeActivityNodeOperationImpl implements ActivityNodeOperation {
	private final DecisionNode decisionNode;
	private final ExecutableADAlgebra alg;

	public DecisionNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final DecisionNode decisionNode) {
		this.decisionNode = decisionNode;
		this.alg = alg;
	}

	@Override
	public List<Token> takeOfferdTokens() {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : this.decisionNode.getIncoming()) {
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
		this.decisionNode.setRunning(true);

	}

	@Override
	public void fire(final List<Token> tokens) {
		ActivityEdge selectedEdge = null;
		for (final ActivityEdge edge : this.decisionNode.getOutgoing()) {
			if (edge instanceof ControlFlow) {
				final ControlFlow controlFlow = (ControlFlow) edge;
				final Value guardValue = controlFlow.getGuard().getCurrentValue();
				if (guardValue instanceof BooleanValue) {
					final BooleanValue booleanValue = (BooleanValue) guardValue;
					if (booleanValue.isValue()) {
						selectedEdge = edge;
						break;
					}
				}
			}
		}

		if (selectedEdge != null) {
			this.addTokens(tokens);
			selectedEdge.sendOffer(tokens);
		}

	}

	@Override
	public void addTokens(final List<Token> tokens) {
		for (final Token token : tokens) {
			final Token transferredToken = this.alg.$(token).transfer(this.decisionNode);
			this.decisionNode.getHeldTokens().add(transferredToken);
		}

	}

	@Override
	public void terminate() {
		this.decisionNode.setRunning(false);

	}

	@Override
	public void removeToken(final Token token) {
		this.decisionNode.getHeldTokens().remove(token);

	}

	@Override
	public void sendOffers(final List<Token> tokens) {
		for (final ActivityEdge edge : this.decisionNode.getOutgoing()) {
			edge.sendOffer(tokens);
		}
	}
}