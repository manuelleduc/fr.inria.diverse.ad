package fr.inria.diverse.ad.visitor2.visitor;

import activitydiagram.DecisionNode;
import activitydiagram.ForkNode;
import activitydiagram.InitialNode;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.OpaqueAction;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;
import fr.inria.diverse.ad.visitor2.operation.ActivityNodeRemoveTokenOperation;

public class ActivityNodeRemoveTokenVisitor extends ActivityDiagramVisitorDefault<ActivityNodeRemoveTokenOperation> {

	@Override
	public ActivityNodeRemoveTokenOperation visitInitialNode(final InitialNode initialNode) {
		return token -> initialNode.getHeldTokens().remove(token);
	}

	@Override
	public ActivityNodeRemoveTokenOperation visitOpaqueAction(final OpaqueAction opaqueAction) {
		return token -> opaqueAction.getHeldTokens().remove(token);
	}

	@Override
	public ActivityNodeRemoveTokenOperation visitForkNode(final ForkNode forkNode) {
		return token -> forkNode.getHeldTokens().remove(token);
	}

	@Override
	public ActivityNodeRemoveTokenOperation visitJoinNode(final JoinNode joinNode) {
		return token -> joinNode.getHeldTokens().remove(token);
	}

	@Override
	public ActivityNodeRemoveTokenOperation visitDecisionNode(final DecisionNode decisionNode) {
		return token -> decisionNode.getHeldTokens().remove(token);
	}

	@Override
	public ActivityNodeRemoveTokenOperation visitMergeNode(MergeNode mergeNode) {
		return token -> mergeNode.getHeldTokens().remove(token);
	}

}
