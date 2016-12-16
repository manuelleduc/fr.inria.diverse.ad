package fr.inria.diverse.ad.algebra.data;

public class ValueType {

	private final Boolean booleanValue;
	private final boolean isInt;
	private final Integer intValue;

	public ValueType(final boolean value) {
		this.booleanValue = value;
		this.isInt = false;
		this.intValue = null;
	}

	public ValueType(final int value) {
		this.intValue = value;
		this.isInt = true;
		this.booleanValue = null;
	}

	public Boolean getBooleanValue() {
		return this.booleanValue;
	}

	public Integer getIntValue() {
		return this.intValue;
	}

	public boolean isInt() {
		return this.isInt;
	}

	@Override
	public String toString() {
		return String.valueOf(this.isInt ? this.intValue : this.booleanValue);
	}

}
