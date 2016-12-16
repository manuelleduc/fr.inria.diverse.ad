package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.List;

import activitydiagram.MergeNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class ActivityMergeNodeActivityNodeOperationImpl implements ActivityNodeOperation {

	private MergeNode mergeNode;
	private ExecutableADAlgebra alg;

	public ActivityMergeNodeActivityNodeOperationImpl(ExecutableADAlgebra alg, MergeNode mergeNode) {
		this.mergeNode = mergeNode;
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
