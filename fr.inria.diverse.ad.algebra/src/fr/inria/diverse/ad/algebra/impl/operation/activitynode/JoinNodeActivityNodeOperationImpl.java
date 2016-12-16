package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import activitydiagram.ActivityEdge;
import activitydiagram.JoinNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class JoinNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	private JoinNode joinNode;

	public JoinNodeActivityNodeOperationImpl(ExecutableADAlgebra alg, JoinNode joinNode) {
		super(alg, joinNode);
		this.joinNode = joinNode;
	}
	
	@Override
	public boolean isReady() {
		boolean ready = true;
		for (ActivityEdge edge : joinNode.getIncoming()) {
			if (!this.alg.$(edge).hasOffer())
				ready = false;
		}
		return ready;
	}

	
}
