package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import activitydiagram.FinalNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class FinalNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	private FinalNode finalNode;

	public FinalNodeActivityNodeOperationImpl(ExecutableADAlgebra alg, FinalNode finalNode) {
		super(alg, finalNode);
		this.finalNode = finalNode;
	}

}
