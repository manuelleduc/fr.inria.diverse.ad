package fr.inria.diverse.ad.algebra.impl.operation.executable.token;

import org.eclipse.emf.ecore.InternalEObject;

import activitydiagram.ForkedToken;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class ForkedTokenNodeOperationImpl extends TokenNodeOperationImpl {
	private final ForkedToken forkedlToken;

	public ForkedTokenNodeOperationImpl(final ExecutableADAlgebra alg, final ForkedToken forkedlToken) {
		super(alg, forkedlToken);
		this.forkedlToken = forkedlToken;
	}

	@Override
	public void withdraw() {
		if (!this.alg.$(this.getBaseToken()).isWithdrawn()) {
			this.alg.$(this.getBaseToken()).withdraw();
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