package fr.inria.diverse.ad.algebra.impl.operation.variable;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.BooleanValue;
import activitydiagram.Value;
import fr.inria.diverse.ad.algebra.operation.VariableOperation;

public class BooleanVariableVariableOperationImpl implements VariableOperation {

	private BooleanValue currentValue = ActivitydiagramFactory.eINSTANCE.createBooleanValue();

	@Override
	public Value getCurrentValue() {
		return currentValue;
	}

	@Override
	public void setCurrentValue(Value value) {
		if(value instanceof BooleanValue) {
			BooleanValue booleanValue = (BooleanValue) value;
			currentValue.setValue(booleanValue.isValue());
		}
	}
}