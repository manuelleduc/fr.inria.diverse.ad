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

	private ActivityEdge activityEdge;
	private ExecutableADAlgebra alg;

	public ActivityEdgeActivityEdgeOperationImpl(ExecutableADAlgebra alg,  ActivityEdge activityEdge) {
		this.activityEdge = activityEdge;
		this.alg = alg;
	}

	@Override
	public void sendOffer(List<Token> tokens) {
		Offer offer = ActivitydiagramFactory.eINSTANCE.createOffer();
		for(Token token : tokens) {
			offer.getOfferedTokens().add(token);
		}
		activityEdge.getOffers().add(offer);
	}
	
	@Override
	public List<Token> takeOfferedTokens() {
		List<Token> tokens = new ArrayList<Token>();
		
		for(Offer o : activityEdge.getOffers()) {
			tokens.addAll(o.getOfferedTokens());
		}
		activityEdge.getOffers().clear();
		
		return tokens;
	}
	
	@Override
	public boolean hasOffer() {
		for(Offer o : activityEdge.getOffers()) {
			if (alg.$(o).hasTokens()) {
				return true;
			}
		}
		return false;
	}
	
}
