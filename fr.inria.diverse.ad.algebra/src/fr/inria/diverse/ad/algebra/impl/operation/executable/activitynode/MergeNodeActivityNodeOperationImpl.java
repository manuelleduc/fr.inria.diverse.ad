package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import activitydiagram.ActivityEdge;
import activitydiagram.MergeNode;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class MergeNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {

	private final MergeNode mergeNode;

	public MergeNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final MergeNode mergeNode) {
		super(alg, mergeNode);
		this.mergeNode = mergeNode;
	}
	
	@Override
	public boolean hasOffers() {
		for(final ActivityEdge edge : this.mergeNode. getIncoming()) {
			if(this.alg.$(edge).hasOffer()) {
				return true;
			}	
		}
		return false;
	}

}
