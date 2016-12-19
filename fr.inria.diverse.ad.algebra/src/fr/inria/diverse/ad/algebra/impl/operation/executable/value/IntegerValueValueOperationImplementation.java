package fr.inria.diverse.ad.algebra.impl.operation.executable.value;

import activitydiagram.IntegerValue;
import fr.inria.diverse.ad.algebra.data.ValueType;
import fr.inria.diverse.ad.algebra.operation.ValueOperation;

public class IntegerValueValueOperationImplementation implements ValueOperation {
	private final IntegerValue integerValue;

	public IntegerValueValueOperationImplementation(IntegerValue integerValue) {
		this.integerValue = integerValue;
	}

	@Override
	public ValueType getValue() {
		return new ValueType(integerValue.getValue());
	}
}