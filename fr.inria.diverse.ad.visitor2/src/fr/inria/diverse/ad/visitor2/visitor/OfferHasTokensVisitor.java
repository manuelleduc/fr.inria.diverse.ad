package fr.inria.diverse.ad.visitor2.visitor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.Offer;
import activitydiagram.Token;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class OfferHasTokensVisitor extends ActivityDiagramVisitorDefault<Boolean> {

	@Autowired
	private TokenIsWithdrawVisitor tokenIsWithdrawVisitor;

	@Override
	public Boolean visitOffer(Offer offer) {
		this.removeWithdrawnTokens(offer);
		return offer.getOfferedTokens().size() > 0;
	}

	private void removeWithdrawnTokens(Offer offer) {
		final List<Token> tokensToBeRemoved = new ArrayList<Token>();
		for (final Token token : offer.getOfferedTokens()) {
			if (token.accept(tokenIsWithdrawVisitor)) {
				tokensToBeRemoved.add(token);
			}
		}
		offer.getOfferedTokens().removeAll(tokensToBeRemoved);

	}

}
