package fr.inria.diverse.ad.visitor2.visitor;

import java.util.List;

import org.springframework.stereotype.Service;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.ControlFlow;
import activitydiagram.Offer;
import activitydiagram.Token;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;
import fr.inria.diverse.ad.visitor2.operation.ActivityEdgeSendOfferOperation;

@Service
public class ActivityEdgeSendOfferVisitor extends ActivityDiagramVisitorDefault<ActivityEdgeSendOfferOperation> {

	@Override
	public ActivityEdgeSendOfferOperation visitControlFlow(ControlFlow controlFlow) {

		return new ActivityEdgeSendOfferOperation() {

			@Override
			public void sendOffer(List<Token> tokens) {
				final Offer offer = ActivitydiagramFactory.eINSTANCE.createOffer();
				for (final Token token : tokens) {
					offer.getOfferedTokens().add(token);
				}
				controlFlow.getOffers().add(offer);

			}

		};
	}

}
