package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import activitydiagram.ActivityEdge;
import activitydiagram.JoinNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class JoinNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	private final JoinNode joinNode;

	public JoinNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final JoinNode joinNode) {
		super(alg, joinNode);
		this.joinNode = joinNode;
	}
	
	@Override
	public boolean isReady() {
		boolean ready = true;
		for (final ActivityEdge edge : this.joinNode.getIncoming()) {
			if (!this.alg.$(edge).hasOffer()) {
				ready = false;
			}
		}
		return ready;
	}

	
}
