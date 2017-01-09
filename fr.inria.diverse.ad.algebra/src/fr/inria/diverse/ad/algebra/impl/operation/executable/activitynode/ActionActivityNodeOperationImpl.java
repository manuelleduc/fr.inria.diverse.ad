package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.Action;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class ActionActivityNodeOperationImpl extends ExecutableNodeActivityNodeImpl {

	private final Action action;

	public ActionActivityNodeOperationImpl(final ExecutableADAlgebra alg, final Action action) {
		super(alg, action);
		this.action = action;
	}
	
	@Override
	public void fire(final List<Token> tokens) {
		this.doAction();
		this.sendOffers();
	}
		
	abstract void doAction();

	public void sendOffers() {
		if(this.action.getOutgoing().size() > 0) {
			final List<Token> tokens = new ArrayList<Token>();
			tokens.add(ActivitydiagramFactory.eINSTANCE.createControlToken());
			this.addTokens(tokens);
			this.alg.$(this.action.getOutgoing().get(0)).sendOffer(tokens);
		}
	}
	
	@Override
	public boolean isReady() {
		return super.isReady() && this.hasOffers();
	}

}
