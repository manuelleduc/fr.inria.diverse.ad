package fr.inria.diverse.ad.algebra.impl.operation.variable;

import activitydiagram.BooleanVariable;
import fr.inria.diverse.ad.algebra.data.VariableType;
import fr.inria.diverse.ad.algebra.operation.VariableOperation;

public class BooleanVariableVariableOperationImpl implements VariableOperation {
	private final BooleanVariable booleanVariable;

	public BooleanVariableVariableOperationImpl(BooleanVariable booleanVariable) {
		this.booleanVariable = booleanVariable;
	}

	@Override
	public VariableType getVariable() {
		return new VariableType(booleanVariable.getName(), VariableType.Type.BOOLEAN);
	}
}