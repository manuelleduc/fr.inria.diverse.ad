package fr.inria.diverse.ad.impl.operation.executable.token;

import org.eclipse.emf.ecore.InternalEObject;

import activitydiagram.ForkedToken;
import activitydiagram.Token;
import fr.inria.diverse.ad.operation.TokenOperation;
import fr.inria.diverse.ad.visitor.TokenVisitor;

public class ForkedTokenNodeOperationImpl extends TokenNodeOperationImpl {
	private final ForkedToken forkedlToken;

	private final TokenVisitor tokenVisitor = new TokenVisitor();

	public ForkedTokenNodeOperationImpl(final ForkedToken forkedlToken) {
		super(forkedlToken);
		this.forkedlToken = forkedlToken;
	}

	@Override
	public void withdraw() {
		final Token baseToken = this.getBaseToken();
		final TokenOperation doSwitch = tokenVisitor.doSwitch(baseToken);
		if (!doSwitch.isWithdrawn()) {
			doSwitch.withdraw();
		}
		if (this.forkedlToken.getRemainingOffersCount() > 0) {
			this.forkedlToken.setRemainingOffersCount(this.forkedlToken.getRemainingOffersCount() - 1);
		}
		if (this.forkedlToken.getRemainingOffersCount() == 0) {
			super.withdraw();
		}
	}

	private Token getBaseToken() {
		if (this.forkedlToken.getBaseToken() != null && this.forkedlToken.getBaseToken().eIsProxy()) {
			final InternalEObject oldBaseToken = (InternalEObject) this.forkedlToken.getBaseToken();

			// FIXME : differs from standard implementation
			if (this.forkedlToken.getBaseToken() != oldBaseToken) {

			}
		}
		return this.forkedlToken.getBaseToken();
	}
}