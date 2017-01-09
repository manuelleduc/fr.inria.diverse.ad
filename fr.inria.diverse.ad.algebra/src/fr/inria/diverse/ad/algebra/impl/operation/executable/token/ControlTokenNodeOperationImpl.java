package fr.inria.diverse.ad.algebra.impl.operation.executable.token;

import activitydiagram.ControlToken;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class ControlTokenNodeOperationImpl extends TokenNodeOperationImpl {
	final ControlToken controlToken;

	public ControlTokenNodeOperationImpl(final ExecutableADAlgebra alg, final ControlToken controlToken) {
		super(alg, controlToken);
		this.controlToken = controlToken;
	}
}