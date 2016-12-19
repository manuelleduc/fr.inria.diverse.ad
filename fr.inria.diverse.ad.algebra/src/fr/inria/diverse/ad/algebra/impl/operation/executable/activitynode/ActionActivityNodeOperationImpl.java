package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.Action;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public abstract class ActionActivityNodeOperationImpl extends ExecutableNodeActivityNodeImpl {

	private Action action;

	public ActionActivityNodeOperationImpl(ExecutableADAlgebra alg, Action action) {
		super(alg, action);
		this.action = action;
	}
	
	@Override
	public void fire(List<Token> tokens) {
		doAction();
		sendOffers();
	}
		
	abstract void doAction();

	public void sendOffers() {
		if(action.getOutgoing().size() > 0) {
			List<Token> tokens = new ArrayList<Token>();
			tokens.add(ActivitydiagramFactory.eINSTANCE.createControlToken());
			addTokens(tokens);
			alg.$(action.getOutgoing().get(0)).sendOffer(tokens);
		}
	}
	
	@Override
	public boolean isReady() {
		return super.isReady() && hasOffers();
	}

}
