package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.List;

import activitydiagram.JoinNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;

public class JoinNodeActivityNodeOperationImpl implements ActivityNodeOperation {

	private JoinNode joinNode;
	private ExecutableADAlgebra alg;

	public JoinNodeActivityNodeOperationImpl(ExecutableADAlgebra alg, JoinNode joinNode) {
		this.joinNode = joinNode;
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
