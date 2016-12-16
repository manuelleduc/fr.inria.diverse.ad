package fr.inria.diverse.ad.algebra.impl.operation.expressionoperation;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.IntegerCalculationExpression;
import activitydiagram.IntegerValue;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class IntegerCalculationExpressionExpressionOperationImpl extends IntegerExpressionExpressionOperationImpl {
	private IntegerCalculationExpression integerCalculationExpression;

	public IntegerCalculationExpressionExpressionOperationImpl(ExecutableADAlgebra alg,
			IntegerCalculationExpression integerCalculationExpression) {
		super(alg);
		this.integerCalculationExpression = integerCalculationExpression;
	}

	@Override
	public void execute() {
		int operandValue1 = getCurrentValue(integerCalculationExpression.getOperand1());
		int operandValue2 = getCurrentValue(integerCalculationExpression.getOperand2());

		Integer result = null;
		switch (integerCalculationExpression.getOperator()) {
		case ADD:
			result = operandValue1 + operandValue2;
			break;
		case SUBRACT:
			result = operandValue1 - operandValue2;
			break;
		}
		IntegerValue resultValue = ActivitydiagramFactory.eINSTANCE.createIntegerValue();
		resultValue.setValue(result);
		integerCalculationExpression.getAssignee().setCurrentValue(resultValue);

	}
}