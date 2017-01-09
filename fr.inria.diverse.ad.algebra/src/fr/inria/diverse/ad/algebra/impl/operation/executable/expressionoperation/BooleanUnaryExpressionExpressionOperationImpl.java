package fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation;

import activitydiagram.BooleanUnaryExpression;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class BooleanUnaryExpressionExpressionOperationImpl extends BooleanExpressionExpressionOperationImpl {
	private final BooleanUnaryExpression booleanUnaryExpression;

	public BooleanUnaryExpressionExpressionOperationImpl(final ExecutableADAlgebra alg,
			final BooleanUnaryExpression booleanUnaryExpression) {
		super(alg, booleanUnaryExpression);
		this.booleanUnaryExpression = booleanUnaryExpression;
	}

	@Override
	public void execute() {
		final boolean operandValue = this.getCurrentValue(this.booleanUnaryExpression.getOperand());

		Boolean result = null;
		switch (this.booleanUnaryExpression.getOperator()) {
		case NOT:
			result = !operandValue;
			break;
		}
		this.assignValue(result);
	}

}