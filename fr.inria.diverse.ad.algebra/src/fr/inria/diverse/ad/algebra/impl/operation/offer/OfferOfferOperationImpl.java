package fr.inria.diverse.ad.algebra.impl.operation.offer;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.Offer;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.OfferOperation;

public class OfferOfferOperationImpl implements OfferOperation {
	private ExecutableADAlgebra alg;
	private Offer offer;

	public OfferOfferOperationImpl(ExecutableADAlgebra alg, Offer offer) {
		this.alg = alg;
		this.offer = offer;
	}

	@Override
	public boolean hasTokens() {
		removeWithdrawnTokens();
		return offer.getOfferedTokens().size() > 0;
	}

	private void removeWithdrawnTokens() {
		List<Token> tokensToBeRemoved = new ArrayList<Token>();
		for (Token token : offer.getOfferedTokens()) {
			if (alg.$(token).isWithdrawn()) {
				tokensToBeRemoved.add(token);
			}
		}
		offer.getOfferedTokens().removeAll(tokensToBeRemoved);
	}
}