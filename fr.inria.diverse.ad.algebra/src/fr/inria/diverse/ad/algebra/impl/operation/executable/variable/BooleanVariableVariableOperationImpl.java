package fr.inria.diverse.ad.algebra.impl.operation.executable.variable;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.BooleanValue;
import activitydiagram.BooleanVariable;
import activitydiagram.Value;
import fr.inria.diverse.ad.algebra.operation.VariableOperation;

public class BooleanVariableVariableOperationImpl implements VariableOperation {

private BooleanVariable booleanVariable;

//	private BooleanValue currentValue = ActivitydiagramFactory.eINSTANCE.createBooleanValue();

	public BooleanVariableVariableOperationImpl(BooleanVariable booleanVariable) {
		this.booleanVariable = booleanVariable;
	}

//	@Override
//	public Value getCurrentValue() {
//		return this.booleanVariable.getCurrentValue();
//	}
//
//	@Override
//	public void setCurrentValue(Value value) {
//		if(value instanceof BooleanValue) {
//			BooleanValue booleanValue = (BooleanValue) value;
//			this.booleanVariable.s.setValue(booleanValue.isValue());
//		}
//	}
}