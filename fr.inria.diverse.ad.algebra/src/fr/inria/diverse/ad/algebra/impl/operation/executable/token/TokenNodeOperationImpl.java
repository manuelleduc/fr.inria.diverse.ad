package fr.inria.diverse.ad.algebra.impl.operation.executable.token;

import activitydiagram.ActivityNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;
import fr.inria.diverse.ad.algebra.operation.TokenOperation;

public abstract class TokenNodeOperationImpl implements TokenOperation {

	protected final ExecutableADAlgebra alg;
	private final Token token;

	public TokenNodeOperationImpl(final ExecutableADAlgebra alg, final Token token) {
		this.alg = alg;
		this.token = token;
	}

	@Override
	public void withdraw() {
		if (!this.isWithdrawn()) {
			final ActivityNodeOperation $ = this.alg.$(this.token.getHolder());
			$.removeToken(this.token);
			this.token.setHolder(null);
		}

	}

	@Override
	public boolean isWithdrawn() {
		return this.token.getHolder() == null;
	}

	@Override
	public Token transfer(final ActivityNode holder) {
		if (this.token.getHolder() != null) {
			this.withdraw();
		}
		this.token.setHolder(holder);
		return this.token;
	}

}