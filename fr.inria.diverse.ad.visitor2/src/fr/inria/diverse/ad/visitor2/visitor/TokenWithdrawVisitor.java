package fr.inria.diverse.ad.visitor2.visitor;

import org.eclipse.emf.ecore.InternalEObject;
import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.ActivityNode;
import activitydiagram.ControlToken;
import activitydiagram.ForkedToken;
import activitydiagram.Token;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class TokenWithdrawVisitor extends ActivityDiagramVisitorDefault<Void> {

	@Autowired
	ActivityNodeRemoveTokenVisitor activityNodeRemoveTokenVisitor;
	@Autowired
	TokenIsWithdrawVisitor tokenIsWithdrawVisitor;
	@Autowired
	TokenWithdrawVisitor tokenWithdrawVisitor;

	@Override
	public Void visitControlToken(final ControlToken controlToken) {
		if (!this.isWithdrawn(controlToken)) {
			final ActivityNode holder = controlToken.getHolder();
			holder.accept(this.activityNodeRemoveTokenVisitor).removeToken(controlToken);
			controlToken.setHolder(null);
		}

		return null;
	}

	private boolean isWithdrawn(final Token controlToken) {
		return controlToken.getHolder() == null;
	}

	@Override
	public Void visitForkedToken(final ForkedToken forkedToken) {
		final Token baseToken = this.getBaseToken(forkedToken);
		if (!baseToken.accept(this.tokenIsWithdrawVisitor)) {
			baseToken.accept(this.tokenWithdrawVisitor);
		}
		if (forkedToken.getRemainingOffersCount() > 0) {
			forkedToken.setRemainingOffersCount(forkedToken.getRemainingOffersCount() - 1);
		}
		if (forkedToken.getRemainingOffersCount() == 0) {
			if (!this.isWithdrawn(forkedToken)) {

				forkedToken.getHolder().accept(this.activityNodeRemoveTokenVisitor).removeToken(forkedToken);
				forkedToken.setHolder(null);
			}
		}

		return null;
	}

	private Token getBaseToken(final ForkedToken forkedToken) {
		if (forkedToken.getBaseToken() != null && forkedToken.getBaseToken().eIsProxy()) {
			final InternalEObject oldBaseToken = (InternalEObject) forkedToken.getBaseToken();

			// FIXME : differs from standard implementation
			if (forkedToken.getBaseToken() != oldBaseToken) {

			}
		}
		return forkedToken.getBaseToken();
	}
	
	

}
