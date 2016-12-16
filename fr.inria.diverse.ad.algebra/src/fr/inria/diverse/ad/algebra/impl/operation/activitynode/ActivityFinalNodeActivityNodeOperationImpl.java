package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.List;

import activitydiagram.ActivityFinalNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class ActivityFinalNodeActivityNodeOperationImpl extends FinalNodeActivityNodeOperationImpl {
	private final ActivityFinalNode activityFinalNode;

	public ActivityFinalNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final ActivityFinalNode activityFinalNode) {
		super(alg, activityFinalNode);
		this.activityFinalNode = activityFinalNode;
	}

	@Override
	public void fire(final List<Token> tokens) {
		this.alg.$(this.activityFinalNode.getActivity()).terminate();
		
	}
}