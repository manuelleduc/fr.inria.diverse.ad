package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import activitydiagram.ActivityEdge;
import activitydiagram.MergeNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class MergeNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	private MergeNode mergeNode;

	public MergeNodeActivityNodeOperationImpl(ExecutableADAlgebra alg, MergeNode mergeNode) {
		super(alg, mergeNode);
		this.mergeNode = mergeNode;
	}
	
	@Override
	public boolean hasOffers() {
		boolean hasOffer = true;
		for(ActivityEdge edge : this.mergeNode. getIncoming()) {
			if(!this.alg.$(edge).hasOffer()) {
				hasOffer = false;
			}	
		}
		return hasOffer;
	}

}
