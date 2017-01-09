package fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation;

import activitydiagram.BooleanBinaryExpression;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class BooleanBinaryExpressionExpressionOperationImpl extends BooleanExpressionExpressionOperationImpl{
	private final BooleanBinaryExpression booleanBinaryExpression;

	public BooleanBinaryExpressionExpressionOperationImpl(final ExecutableADAlgebra alg,
			final BooleanBinaryExpression booleanBinaryExpression) {
		super(alg, booleanBinaryExpression);
		this.booleanBinaryExpression = booleanBinaryExpression;
	}

	@Override
	public void execute() {
		final boolean operandValue1 = this.getCurrentValue(this.booleanBinaryExpression.getOperand1());
		final boolean operandValue2 = this.getCurrentValue(this.booleanBinaryExpression.getOperand2());

		Boolean result = null;
		switch (this.booleanBinaryExpression.getOperator()) {
		case AND:
			result = operandValue1 && operandValue2;
			break;
		case OR:
			result = operandValue1 || operandValue2;
			break;
		}		
		this.assignValue(result);

	}
}