package fr.inria.diverse.ad.visitor.impl.operation.executable.activitynode;

import java.util.List;

import activitydiagram.Activity;
import activitydiagram.ActivityFinalNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.visitor.visitor.ActivityVisitor;

public class ActivityFinalNodeActivityNodeOperationImpl extends FinalNodeActivityNodeOperationImpl {
	private final ActivityFinalNode activityFinalNode;
	private final ActivityVisitor activityVisitor = new ActivityVisitor();

	public ActivityFinalNodeActivityNodeOperationImpl(final ActivityFinalNode activityFinalNode) {
		super(activityFinalNode);
		this.activityFinalNode = activityFinalNode;
	}

	@Override
	public void fire(final List<Token> tokens) {
		Activity activity = this.activityFinalNode.getActivity();
		activityVisitor.doSwitch(activity).terminate();

	}
}