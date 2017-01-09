package fr.inria.diverse.ad.algebra.impl.operation.executable.offer;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.Offer;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.OfferOperation;

public class OfferOfferOperationImpl implements OfferOperation {
	private final ExecutableADAlgebra alg;
	private final Offer offer;

	public OfferOfferOperationImpl(final ExecutableADAlgebra alg, final Offer offer) {
		this.alg = alg;
		this.offer = offer;
	}

	@Override
	public boolean hasTokens() {
		this.removeWithdrawnTokens();
		return this.offer.getOfferedTokens().size() > 0;
	}

	private void removeWithdrawnTokens() {
		final List<Token> tokensToBeRemoved = new ArrayList<Token>();
		for (final Token token : this.offer.getOfferedTokens()) {
			if (this.alg.$(token).isWithdrawn()) {
				tokensToBeRemoved.add(token);
			}
		}
		this.offer.getOfferedTokens().removeAll(tokensToBeRemoved);
	}
}