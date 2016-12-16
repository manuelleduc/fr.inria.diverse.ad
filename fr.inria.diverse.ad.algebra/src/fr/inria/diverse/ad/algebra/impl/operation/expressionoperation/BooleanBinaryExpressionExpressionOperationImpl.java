package fr.inria.diverse.ad.algebra.impl.operation.expressionoperation;

import activitydiagram.BooleanBinaryExpression;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class BooleanBinaryExpressionExpressionOperationImpl extends BooleanExpressionExpressionOperationImpl{
	private BooleanBinaryExpression booleanBinaryExpression;

	public BooleanBinaryExpressionExpressionOperationImpl(ExecutableADAlgebra alg,
			BooleanBinaryExpression booleanBinaryExpression) {
		super(alg, booleanBinaryExpression);
		this.booleanBinaryExpression = booleanBinaryExpression;
	}

	@Override
	public void execute() {
		boolean operandValue1 = getCurrentValue(booleanBinaryExpression.getOperand1());
		boolean operandValue2 = getCurrentValue(booleanBinaryExpression.getOperand2());

		Boolean result = null;
		switch (booleanBinaryExpression.getOperator()) {
		case AND:
			result = operandValue1 && operandValue2;
			break;
		case OR:
			result = operandValue1 || operandValue2;
			break;
		}		
		assignValue(result);

	}
}