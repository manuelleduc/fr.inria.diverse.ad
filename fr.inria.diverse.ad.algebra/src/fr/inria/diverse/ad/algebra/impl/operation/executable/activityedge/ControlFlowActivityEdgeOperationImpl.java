package fr.inria.diverse.ad.algebra.impl.operation.executable.activityedge;

import activitydiagram.ControlFlow;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class ControlFlowActivityEdgeOperationImpl extends ActivityEdgeActivityEdgeOperationImpl {
	private final ControlFlow controlFlow;
	
	

	public ControlFlowActivityEdgeOperationImpl(ExecutableADAlgebra alg,  ControlFlow controlFlow) {
		super(alg, controlFlow);
		this.controlFlow = controlFlow;
	}

	
}