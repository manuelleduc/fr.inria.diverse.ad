package fr.inria.diverse.ad.algebra.impl.operation.activityedge;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ControlFlow;
import activitydiagram.Offer;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.operation.ActivityEdgeOperation;

public class ControlFlowActivityEdgeOperationImpl implements ActivityEdgeOperation {
	private final ControlFlow controlFlow;

	public ControlFlowActivityEdgeOperationImpl(ControlFlow controlFlow) {
		this.controlFlow = controlFlow;
	}

	@Override
	public List<Token> takeOfferedTokens() {
		final List<Token> tokens = new ArrayList<Token>();

		for (final Offer o : controlFlow.getOffers()) {
			tokens.addAll(o.getOfferedTokens());
		}
		controlFlow.getOffers().clear();

		return tokens;
	}
}