package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.List;

import activitydiagram.ControlNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class ControlNodeActivityNodeImpl extends ActivityNodeActivityNodeOperationImpl {

	public ControlNodeActivityNodeImpl(ExecutableADAlgebra alg, ControlNode joinNode) {
		super(alg, joinNode);
	}

	@Override
	public void fire(List<Token> tokens) {
		addTokens(tokens);
		sendOffers(tokens);
		
	}

}
