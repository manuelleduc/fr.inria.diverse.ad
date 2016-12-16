package fr.inria.diverse.ad.algebra.data;

public class VariableType {
	private final String name;
	private final Type type;

	public enum Type {
		INTEGER, BOOLEAN
	}

	public VariableType(final String name, final VariableType.Type type) {
		this.name = name;
		this.type = type;
	}

	public boolean isInt() {
		return this.type == VariableType.Type.INTEGER;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name + "("+this.type+")";
	}
	
	

}
