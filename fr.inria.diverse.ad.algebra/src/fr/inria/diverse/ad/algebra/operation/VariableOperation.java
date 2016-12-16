package fr.inria.diverse.ad.algebra.operation;

import activitydiagram.Value;

public interface VariableOperation {

	Value getCurrentValue();

	void setCurrentValue(Value value);
}
