package fr.inria.diverse.ad.algebra.impl.operation.expressionoperation;

import activitydiagram.IntegerValue;
import activitydiagram.Value;
import activitydiagram.Variable;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ExpressionOperation;

public abstract class IntegerExpressionExpressionOperationImpl implements ExpressionOperation {

	private ExecutableADAlgebra alg;

	public IntegerExpressionExpressionOperationImpl(ExecutableADAlgebra alg) {
		this.alg = alg;
	}

	protected Integer getCurrentValue(Variable variable) {
		Integer currentValue = null;
		Value value = alg.$(variable).getCurrentValue();
		if (value instanceof IntegerValue) {
			IntegerValue integerValue = (IntegerValue) value;
			currentValue = integerValue.getValue();
		}
		return currentValue;
	}

}
