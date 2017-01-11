package fr.inria.diverse.ad.visitor2.visitor;

import activitydiagram.ActivityFinalNode;
import activitydiagram.DecisionNode;
import activitydiagram.ForkNode;
import activitydiagram.InitialNode;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.OpaqueAction;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class ActivityNodeRunVisitor extends ActivityDiagramVisitorDefault<Void> {

	@Override
	public Void visitInitialNode(InitialNode initialNode) {
		initialNode.setRunning(true);
		return null;
	}

	@Override
	public Void visitActivityFinalNode(ActivityFinalNode activityFinalNode) {
		activityFinalNode.setRunning(true);
		return null;
	}

	@Override
	public Void visitOpaqueAction(OpaqueAction opaqueAction) {
		opaqueAction.setRunning(true);
		return null;
	}

	@Override
	public Void visitForkNode(ForkNode forkNode) {
		forkNode.setRunning(true);
		return null;
	}

	@Override
	public Void visitJoinNode(JoinNode joinNode) {
		joinNode.setRunning(true);
		return null;
	}

	@Override
	public Void visitMergeNode(MergeNode mergeNode) {
		mergeNode.setRunning(true);
		return null;
	}

	@Override
	public Void visitDecisionNode(DecisionNode decisionNode) {
		decisionNode.setRunning(true);
		return null;
	}

}
