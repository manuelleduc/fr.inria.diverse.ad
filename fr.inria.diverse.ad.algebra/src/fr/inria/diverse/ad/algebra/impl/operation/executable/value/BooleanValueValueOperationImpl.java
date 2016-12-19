package fr.inria.diverse.ad.algebra.impl.operation.executable.value;

import activitydiagram.BooleanValue;
import fr.inria.diverse.ad.algebra.data.ValueType;
import fr.inria.diverse.ad.algebra.operation.ValueOperation;

public class BooleanValueValueOperationImpl implements ValueOperation {
	private final BooleanValue booleanValue;

	public BooleanValueValueOperationImpl(BooleanValue booleanValue) {
		this.booleanValue = booleanValue;
	}

	@Override
	public ValueType getValue() {
		return new ValueType(booleanValue.isValue());
	}
}