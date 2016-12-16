package fr.inria.diverse.ad.algebra.impl.operation.contextprocessor;

import activitydiagram.InputValue;
import fr.inria.diverse.ad.algebra.data.ADContext;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ContextProcessorOperation;

public class InputValueContextProcessorOperationImplementation implements ContextProcessorOperation {
	private final InputValue inputValue;
	private ExecutableADAlgebra alg;

	public InputValueContextProcessorOperationImplementation(ExecutableADAlgebra alg, InputValue inputValue) {
		this.inputValue = inputValue;
		this.alg = alg;
	}

	@Override
	public ADContext process(ADContext context) {
		return new ADContext(context, alg.$(inputValue.getVariable()).getVariable(),
				alg.$(inputValue.getValue()).getValue());
	}
}