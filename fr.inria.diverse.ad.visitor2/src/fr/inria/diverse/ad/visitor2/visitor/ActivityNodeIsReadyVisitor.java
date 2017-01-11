package fr.inria.diverse.ad.visitor2.visitor;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivityFinalNode;
import activitydiagram.ActivityNode;
import activitydiagram.DecisionNode;
import activitydiagram.ForkNode;
import activitydiagram.InitialNode;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.OpaqueAction;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class ActivityNodeIsReadyVisitor extends ActivityDiagramVisitorDefault<Boolean> {

	@Autowired
	ActivityEdgeHasOfferVisitor activityEdgeHasOfferVisitor;

	@Override
	public Boolean visitInitialNode(InitialNode initialNode) {
		return false;
	}

	@Override
	public Boolean visitActivityFinalNode(ActivityFinalNode activityFinalNode) {
		return activityFinalNode.isRunning() && this.hasOffers(activityFinalNode);
	}

	private boolean hasOffers(ActivityNode activityNode) {
		boolean hasOffer = true;
		for (final ActivityEdge edge : activityNode.getIncoming()) {
			if (!edge.accept(activityEdgeHasOfferVisitor)) {
				hasOffer = false;
			}
		}
		return hasOffer;
	}

	@Override
	public Boolean visitOpaqueAction(OpaqueAction opaqueAction) {
		return opaqueAction.isRunning() && this.hasOffers(opaqueAction);
	}

	@Override
	public Boolean visitForkNode(ForkNode forkNode) {
		return forkNode.isRunning() && this.hasOffers(forkNode);
	}

	@Override
	public Boolean visitJoinNode(JoinNode joinNode) {
		boolean ready = true;
		for (final ActivityEdge edge : joinNode.getIncoming()) {
			if (!edge.accept(activityEdgeHasOfferVisitor)) {
				ready = false;
			}
		}
		return ready;
	}

	@Override
	public Boolean visitMergeNode(MergeNode mergeNode) {
		return mergeNode.isRunning() && this.hasOffersMergeNode(mergeNode);
	}

	private boolean hasOffersMergeNode(MergeNode mergeNode) {
		for (final ActivityEdge edge : mergeNode.getIncoming()) {
			if (edge.accept(activityEdgeHasOfferVisitor)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visitDecisionNode(DecisionNode decisionNode) {
		boolean ready = true;
		for (final ActivityEdge edge : decisionNode.getIncoming()) {
			if (!edge.accept(activityEdgeHasOfferVisitor)) {
				ready = false;
			}
		}
		return ready;
	}

}
