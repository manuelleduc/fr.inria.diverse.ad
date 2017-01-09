package fr.inria.diverse.ad.visitor.impl.operation.executable.activitynode;

import activitydiagram.ActivityEdge;
import activitydiagram.JoinNode;
import fr.inria.diverse.ad.visitor.visitor.ActivityEdgeVisitor;

public class JoinNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	private final JoinNode joinNode;

	private final ActivityEdgeVisitor activityEdgeVisitor = new ActivityEdgeVisitor();

	public JoinNodeActivityNodeOperationImpl(final JoinNode joinNode) {
		super(joinNode);
		this.joinNode = joinNode;
	}

	@Override
	public boolean isReady() {
		boolean ready = true;
		for (final ActivityEdge edge : this.joinNode.getIncoming()) {
			if (!activityEdgeVisitor.doSwitch(edge).hasOffer()) {
				ready = false;
			}
		}
		return ready;
	}

}
