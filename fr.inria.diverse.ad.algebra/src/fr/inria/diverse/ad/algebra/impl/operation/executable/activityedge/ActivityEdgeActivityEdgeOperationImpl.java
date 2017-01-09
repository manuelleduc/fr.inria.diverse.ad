package fr.inria.diverse.ad.algebra.impl.operation.executable.activityedge;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.Offer;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityEdgeOperation;

public abstract class ActivityEdgeActivityEdgeOperationImpl implements ActivityEdgeOperation {

	private final ActivityEdge activityEdge;
	private final ExecutableADAlgebra alg;

	public ActivityEdgeActivityEdgeOperationImpl(final ExecutableADAlgebra alg,  final ActivityEdge activityEdge) {
		this.activityEdge = activityEdge;
		this.alg = alg;
	}

	@Override
	public void sendOffer(final List<Token> tokens) {
		final Offer offer = ActivitydiagramFactory.eINSTANCE.createOffer();
		for(final Token token : tokens) {
			offer.getOfferedTokens().add(token);
		}
		this.activityEdge.getOffers().add(offer);
	}
	
	@Override
	public List<Token> takeOfferedTokens() {
		final List<Token> tokens = new ArrayList<Token>();
		
		for(final Offer o : this.activityEdge.getOffers()) {
			tokens.addAll(o.getOfferedTokens());
		}
		this.activityEdge.getOffers().clear();
		
		return tokens;
	}
	
	@Override
	public boolean hasOffer() {
		for(final Offer o : this.activityEdge.getOffers()) {
			if (this.alg.$(o).hasTokens()) {
				return true;
			}
		}
		return false;
	}
	
}
