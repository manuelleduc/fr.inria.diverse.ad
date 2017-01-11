package fr.inria.diverse.ad.visitor2.visitor;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.ControlFlow;
import activitydiagram.Offer;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class ActivityEdgeHasOfferVisitor extends ActivityDiagramVisitorDefault<Boolean> {

	@Autowired
	private OfferHasTokensVisitor offerHasTokensVisitor;

	@Override
	public Boolean visitControlFlow(ControlFlow controlFlow) {
		for (final Offer o : controlFlow.getOffers()) {
			if (o.accept(offerHasTokensVisitor)) {
				return true;
			}
		}
		return false;
	}

}
