package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import activitydiagram.Expression;
import activitydiagram.OpaqueAction;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class OpageActionActivityNodeOperationImpl extends ActionActivityNodeOperationImpl {

	private final OpaqueAction opaqueAction;

	public OpageActionActivityNodeOperationImpl(final ExecutableADAlgebra alg, final OpaqueAction opaqueAction) {
		super(alg, opaqueAction);
		this.opaqueAction = opaqueAction;
	}

	@Override
	void doAction() {
		for (final Expression e : this.opaqueAction.getExpressions()) {
			this.alg.$(e).execute();
		}
		
	}

}
