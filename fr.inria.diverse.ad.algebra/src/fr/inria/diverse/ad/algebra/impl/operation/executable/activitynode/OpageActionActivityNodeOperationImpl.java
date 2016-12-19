package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.List;

import activitydiagram.Expression;
import activitydiagram.OpaqueAction;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class OpageActionActivityNodeOperationImpl extends ActionActivityNodeOperationImpl {

	private OpaqueAction opaqueAction;

	public OpageActionActivityNodeOperationImpl(ExecutableADAlgebra alg, OpaqueAction opaqueAction) {
		super(alg, opaqueAction);
		this.opaqueAction = opaqueAction;
	}

	@Override
	void doAction() {
		for (Expression e : opaqueAction.getExpressions()) {
			alg.$(e).execute();
		}
		
	}

}
