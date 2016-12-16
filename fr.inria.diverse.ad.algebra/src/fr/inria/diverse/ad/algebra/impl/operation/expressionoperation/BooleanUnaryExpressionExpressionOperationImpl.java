package fr.inria.diverse.ad.algebra.impl.operation.expressionoperation;

import activitydiagram.BooleanUnaryExpression;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class BooleanUnaryExpressionExpressionOperationImpl extends BooleanExpressionExpressionOperationImpl {
	private BooleanUnaryExpression booleanUnaryExpression;

	public BooleanUnaryExpressionExpressionOperationImpl(ExecutableADAlgebra alg,
			BooleanUnaryExpression booleanUnaryExpression) {
		super(alg, booleanUnaryExpression);
		this.booleanUnaryExpression = booleanUnaryExpression;
	}

	@Override
	public void execute() {
		boolean operandValue = getCurrentValue(booleanUnaryExpression.getOperand());

		Boolean result = null;
		switch (booleanUnaryExpression.getOperator()) {
		case NOT:
			result = !operandValue;
			break;
		}
		assignValue(result);
	}

}