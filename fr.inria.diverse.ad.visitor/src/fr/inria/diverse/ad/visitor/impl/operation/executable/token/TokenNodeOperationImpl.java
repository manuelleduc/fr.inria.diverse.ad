package fr.inria.diverse.ad.visitor.impl.operation.executable.token;

import activitydiagram.ActivityNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.visitor.operation.ActivityNodeOperation;
import fr.inria.diverse.ad.visitor.operation.TokenOperation;
import fr.inria.diverse.ad.visitor.visitor.ActivityNodeVisitor;

public abstract class TokenNodeOperationImpl implements TokenOperation {

	private final Token token;

	private final ActivityNodeVisitor activityNodeVisitor = new ActivityNodeVisitor();

	public TokenNodeOperationImpl(final Token token) {
		this.token = token;
	}

	@Override
	public void withdraw() {
		if (!this.isWithdrawn()) {
			ActivityNode holder = this.token.getHolder();
			final ActivityNodeOperation visitor = activityNodeVisitor.doSwitch(holder);
			visitor.removeToken(this.token);
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