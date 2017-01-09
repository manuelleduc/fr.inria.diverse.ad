package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import activitydiagram.ExecutableNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class ExecutableNodeActivityNodeImpl extends ActivityNodeActivityNodeOperationImpl {

	public ExecutableNodeActivityNodeImpl(final ExecutableADAlgebra alg, final ExecutableNode joinNode) {
		super(alg, joinNode);
	}


}
