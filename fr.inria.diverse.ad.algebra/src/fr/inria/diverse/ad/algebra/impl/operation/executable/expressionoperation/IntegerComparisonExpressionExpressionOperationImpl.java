package fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.BooleanValue;
import activitydiagram.IntegerComparisonExpression;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class IntegerComparisonExpressionExpressionOperationImpl extends IntegerExpressionExpressionOperationImpl {
	private IntegerComparisonExpression integerComparisonExpression;

	public IntegerComparisonExpressionExpressionOperationImpl(ExecutableADAlgebra alg,
			IntegerComparisonExpression integerComparisonExpression) {
		super(alg);
		this.integerComparisonExpression = integerComparisonExpression;
	}

	@Override
	public void execute() {
		int operandValue1 = getCurrentValue(integerComparisonExpression.getOperand1());
		int operandValue2 = getCurrentValue(integerComparisonExpression.getOperand2());

		Boolean result = null;
		switch (integerComparisonExpression.getOperator()) {
		case EQUALS:
			result = operandValue1 == operandValue2;
			break;
		case GREATER:
			result = operandValue1 > operandValue2;
			break;
		case GREATER_EQUALS:
			result = operandValue1 >= operandValue2;
			break;
		case SMALLER:
			result = operandValue1 < operandValue2;
			break;
		case SMALLER_EQUALS:
			result = operandValue1 <= operandValue2;
			break;
		}
		BooleanValue resultValue = ActivitydiagramFactory.eINSTANCE.createBooleanValue();
		resultValue.setValue(result);
		integerComparisonExpression.getAssignee().setCurrentValue(resultValue);
	}
}