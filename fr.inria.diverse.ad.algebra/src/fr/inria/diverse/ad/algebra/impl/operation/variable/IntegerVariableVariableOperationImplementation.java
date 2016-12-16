package fr.inria.diverse.ad.algebra.impl.operation.variable;

import activitydiagram.IntegerVariable;
import fr.inria.diverse.ad.algebra.data.VariableType;
import fr.inria.diverse.ad.algebra.operation.VariableOperation;

public class IntegerVariableVariableOperationImplementation implements VariableOperation {
	private final IntegerVariable integerVariable;

	public IntegerVariableVariableOperationImplementation(IntegerVariable integerVariable) {
		this.integerVariable = integerVariable;
	}

	@Override
	public VariableType getVariable() {
		return new VariableType(integerVariable.getName(), VariableType.Type.INTEGER);
	}
}