package fr.inria.diverse.ad.visitor2.visitor;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.ActivityNode;
import activitydiagram.ControlToken;
import activitydiagram.ForkedToken;
import activitydiagram.Token;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;
import fr.inria.diverse.ad.visitor2.operation.TokenTransfertOperation;

public class TokenTransfertVisitor extends ActivityDiagramVisitorDefault<TokenTransfertOperation> {

	@Autowired
	private ActivityNodeRemoveTokenVisitor activityNodeRemoveTokenVisitor;

	@Override
	public TokenTransfertOperation visitControlToken(ControlToken controlToken) {

		return new TokenTransfertOperation() {

			@Override
			public Token transfer(ActivityNode activityNode) {
				if (controlToken.getHolder() != null) {
					this.withdraw();
				}
				controlToken.setHolder(activityNode);
				return controlToken;
			}

			private void withdraw() {
				if (!this.isWithdrawn()) {
					controlToken.getHolder().accept(activityNodeRemoveTokenVisitor).removeToken(controlToken);
					controlToken.setHolder(null);
				}

			}

			private boolean isWithdrawn() {
				return controlToken.getHolder() == null;
			}
		};
	}

	@Override
	public TokenTransfertOperation visitForkedToken(ForkedToken forkedToken) {

		return new TokenTransfertOperation() {

			@Override
			public Token transfer(ActivityNode activityNode) {
				if (forkedToken.getHolder() != null) {
					this.withdraw(forkedToken);
				}
				forkedToken.setHolder(activityNode);
				return forkedToken;
			}

			private void withdraw(ForkedToken forkedToken) {
				if (!this.isWithdrawn(forkedToken)) {
					final ActivityNode holder = forkedToken.getHolder();
					holder.accept(activityNodeRemoveTokenVisitor).removeToken(forkedToken);
					forkedToken.setHolder(null);
				}

			}

			private boolean isWithdrawn(ForkedToken forkedToken) {
				return forkedToken.getHolder() == null;
			}
		};
	}

}
