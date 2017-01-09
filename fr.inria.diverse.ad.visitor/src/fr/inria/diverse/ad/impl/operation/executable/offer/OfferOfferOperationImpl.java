package fr.inria.diverse.ad.impl.operation.executable.offer;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.Offer;
import activitydiagram.Token;
import fr.inria.diverse.ad.operation.OfferOperation;
import fr.inria.diverse.ad.visitor.TokenVisitor;

public class OfferOfferOperationImpl implements OfferOperation {
	private final Offer offer;
	private final TokenVisitor tokenVisitor = new TokenVisitor();

	public OfferOfferOperationImpl(final Offer offer) {
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
			if (tokenVisitor.doSwitch(token).isWithdrawn()) {
				tokensToBeRemoved.add(token);
			}
		}
		this.offer.getOfferedTokens().removeAll(tokensToBeRemoved);
	}
}