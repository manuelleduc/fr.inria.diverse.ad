package fr.inria.diverse.ad.algebra.impl.operation.node;

import org.eclipse.emf.ecore.InternalEObject;

import activitydiagram.ForkedToken;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class ForkedTokenNodeOperationImpl extends TokenNodeOperationImpl {
	private final ForkedToken forkedlToken;

	public ForkedTokenNodeOperationImpl(ExecutableADAlgebra alg, ForkedToken forkedlToken) {
		super(alg, forkedlToken);
		this.forkedlToken = forkedlToken;
	}

	@Override
	public void withdraw() {
		if (!this.getBaseToken().isWithdrawn()) {
			alg.$(this.getBaseToken()).withdraw();
		}
		if (forkedlToken.getRemainingOffersCount() > 0) {
			forkedlToken.setRemainingOffersCount(forkedlToken.getRemainingOffersCount() - 1);
		}
		if (forkedlToken.getRemainingOffersCount() == 0) {
			super.withdraw();
		}
	}

	private Token getBaseToken() {
		if (forkedlToken.getBaseToken() != null && forkedlToken.getBaseToken().eIsProxy()) {
			final InternalEObject oldBaseToken = (InternalEObject) forkedlToken.getBaseToken();

			// TODO: figure out what is going on here !
			// forkedToken.setBaseToken((Token)forkedToken.eResolveProxy(oldBaseToken));
			if (forkedlToken.getBaseToken() != oldBaseToken) {

				// TODO : How to use internal ecore macanism in the
				// algebra ?
				// if (forkedToken.eNotificationRequired())
				// eNotify(new ENotificationImpl(this,
				// Notification.RESOLVE,
				// ActivitydiagramPackage.FORKED_TOKEN__BASE_TOKEN,
				// oldBaseToken, baseToken));
			}
		}
		return forkedlToken.getBaseToken();
	}
}