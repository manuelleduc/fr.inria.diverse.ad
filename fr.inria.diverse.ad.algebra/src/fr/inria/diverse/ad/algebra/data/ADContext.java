package fr.inria.diverse.ad.algebra.data;

import java.util.HashMap;

public class ADContext {

	private final HashMap<VariableType, ValueType> contextMap;

	public ADContext() {
		this.contextMap = new HashMap<VariableType, ValueType>();
	}

	public ADContext(final ADContext context, final VariableType variable, final ValueType value) {
		this.contextMap = new HashMap<>();
		this.contextMap.putAll(context.contextMap);
		this.contextMap.put(variable, value);
	}

	@Override
	public String toString() {
		return "ADContext [contextMap=" + this.contextMap + "]";
	}

}
