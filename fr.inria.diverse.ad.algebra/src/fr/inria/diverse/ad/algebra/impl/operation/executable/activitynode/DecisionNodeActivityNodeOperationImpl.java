package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.BooleanValue;
import activitydiagram.ControlFlow;
import activitydiagram.DecisionNode;
import activitydiagram.Token;
import activitydiagram.Value;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class DecisionNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {
	private final DecisionNode decisionNode;

	public DecisionNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final DecisionNode decisionNode) {
		super(alg, decisionNode);
		this.decisionNode = decisionNode;
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
			alg.$(selectedEdge).sendOffer(tokens);
		}

	}

	@Override
	public boolean isReady() {
		boolean ready = true;
		for (ActivityEdge edge : this.decisionNode.getIncoming()) {
			if (!this.alg.$(edge).hasOffer())
				ready = false;
		}
		return ready;
	}

}