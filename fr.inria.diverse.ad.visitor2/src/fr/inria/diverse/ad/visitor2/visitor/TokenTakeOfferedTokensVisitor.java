package fr.inria.diverse.ad.visitor2.visitor;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ControlFlow;
import activitydiagram.Offer;
import activitydiagram.Token;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class TokenTakeOfferedTokensVisitor extends ActivityDiagramVisitorDefault<List<Token>> {

	@Override
	public List<Token> visitControlFlow(ControlFlow controlFlow) {
		final List<Token> tokens = new ArrayList<Token>();

		for (final Offer o : controlFlow.getOffers()) {
			tokens.addAll(o.getOfferedTokens());
		}
		controlFlow.getOffers().clear();

		return tokens;
	}

}
