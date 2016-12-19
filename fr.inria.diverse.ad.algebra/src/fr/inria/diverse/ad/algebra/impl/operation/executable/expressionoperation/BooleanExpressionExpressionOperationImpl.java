package fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.BooleanExpression;
import activitydiagram.BooleanValue;
import activitydiagram.BooleanVariable;
import activitydiagram.Value;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ExpressionOperation;

public abstract class BooleanExpressionExpressionOperationImpl implements ExpressionOperation {

	
	private BooleanExpression booleanExpression;
	private ExecutableADAlgebra alg;

	public BooleanExpressionExpressionOperationImpl(ExecutableADAlgebra alg,
			BooleanExpression booleanExpression) {
		this.alg = alg;
		this.booleanExpression = booleanExpression;
	}

	protected void assignValue(Boolean value) {
		BooleanValue resultValue = ActivitydiagramFactory.eINSTANCE.createBooleanValue();
		resultValue.setValue(value);
		booleanExpression.getAssignee().setCurrentValue(resultValue);
	}

	protected boolean getCurrentValue(BooleanVariable variable) {
		Boolean currentValue = null; 
		Value value = variable.getCurrentValue();
		if(value instanceof BooleanValue) {
			BooleanValue booleanValue = (BooleanValue) value;
			currentValue = booleanValue.isValue();
		}
		return currentValue;
	}
}
