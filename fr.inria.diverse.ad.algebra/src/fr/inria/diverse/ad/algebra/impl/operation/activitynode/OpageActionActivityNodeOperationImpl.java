package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.List;

import activitydiagram.OpaqueAction;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class OpageActionActivityNodeOperationImpl implements ActivityNodeOperation {

	private OpaqueAction opaqueAction;
	private ExecutableADAlgebra alg;

	public OpageActionActivityNodeOperationImpl(ExecutableADAlgebra alg, OpaqueAction opaqueAction) {
		this.opaqueAction = opaqueAction;
		this.alg = alg;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Token> takeOfferdTokens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fire(List<Token> tokens) {
		// TODO Auto-generated method stub

	}

	@Override
	public void terminate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTokens(List<Token> tokens) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeToken(Token token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendOffers(List<Token> forkedTokens) {
		// TODO Auto-generated method stub

	}

}
