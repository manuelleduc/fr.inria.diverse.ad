package fr.inria.diverse.ad.visitor;

import activitydiagram.Offer;
import activitydiagram.util.ActivitydiagramSwitch;
import fr.inria.diverse.ad.impl.operation.executable.offer.OfferOfferOperationImpl;
import fr.inria.diverse.ad.operation.OfferOperation;

public class OfferVisitor extends ActivitydiagramSwitch<OfferOperation> {

	@Override
	public OfferOperation caseOffer(Offer object) {
		return new OfferOfferOperationImpl(object);
	}

}
