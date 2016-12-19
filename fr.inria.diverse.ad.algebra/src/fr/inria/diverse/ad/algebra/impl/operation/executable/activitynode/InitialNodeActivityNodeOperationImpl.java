package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.InitialNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class InitialNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {
	private final InitialNode initialNode;

	public InitialNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final InitialNode initialNode) {
		super(alg, initialNode);
		this.initialNode = initialNode;
	}

	@Override
	public void fire(final List<Token> tokens) {
		final List<Token> producedTokens = new ArrayList<Token>();
		producedTokens.add(ActivitydiagramFactory.eINSTANCE.createControlToken());
		this.addTokens(producedTokens);
		this.sendOffers(producedTokens);

	}

	@Override
	public boolean isReady() {
		return false; // is fired by activity directly
	}

}