package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import activitydiagram.FinalNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class FinalNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	public FinalNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final FinalNode finalNode) {
		super(alg, finalNode);
	}

}
