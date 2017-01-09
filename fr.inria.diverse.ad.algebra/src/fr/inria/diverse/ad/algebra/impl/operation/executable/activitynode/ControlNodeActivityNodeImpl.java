package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.List;

import activitydiagram.ControlNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class ControlNodeActivityNodeImpl extends ActivityNodeActivityNodeOperationImpl {

	public ControlNodeActivityNodeImpl(final ExecutableADAlgebra alg, final ControlNode joinNode) {
		super(alg, joinNode);
	}

	@Override
	public void fire(final List<Token> tokens) {
		this.addTokens(tokens);
		this.sendOffers(tokens);
		
	}

	@Override
	public boolean isReady() {
		return super.isReady() && this.hasOffers();
	}
	
	

}
