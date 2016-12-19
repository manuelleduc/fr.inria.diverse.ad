package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivityNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityEdgeOperation;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;
import fr.inria.diverse.ad.algebra.operation.NodeOperation;

public abstract class ActivityNodeActivityNodeOperationImpl implements ActivityNodeOperation {

	private ActivityNode activityNode;
	protected ExecutableADAlgebra alg;

	public ActivityNodeActivityNodeOperationImpl(ExecutableADAlgebra alg, ActivityNode activityNode) {
		this.activityNode = activityNode;
		this.alg = alg;
	}

	@Override
	public void run() {
		this.activityNode.setRunning(true);
	}

	@Override
	public boolean isRunning() {
		return this.activityNode.isRunning();
	}

	@Override
	public void terminate() {
		this.activityNode.setRunning(false);
	}

	@Override
	public boolean isReady() {
		return isRunning();
	}

	@Override
	public void sendOffers(List<Token> tokens) {
		for (ActivityEdge edge : this.activityNode.getOutgoing()) {
			this.alg.$(edge).sendOffer(tokens);
		}
	}

	@Override
	public List<Token> takeOfferdTokens() {
		List<Token> allTokens = new ArrayList<Token>();
		for (ActivityEdge edge : this.activityNode.getIncoming())	 {
			ActivityEdgeOperation $ = this.alg.$(edge);
			List<Token> tokens = $.takeOfferedTokens();
			for (Token token : tokens) {
				NodeOperation $2 = this.alg.$(token);
				$2.withdraw();
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public void addTokens(List<Token> tokens) {
		for (Token token : tokens) {
			NodeOperation $ = this.alg.$(token);
			Token transferredToken = $.transfer(this.activityNode);
			activityNode.getHeldTokens().add(transferredToken);
		}
	}

	@Override
	public boolean hasOffers() {
		boolean hasOffer = true;
		for (ActivityEdge edge : activityNode.getIncoming()) {
			if (!this.alg.$(edge).hasOffer()) {
				hasOffer = false;
			}
		}
		return hasOffer;
	}

	@Override
	public void removeToken(Token token) {
		activityNode.getHeldTokens().remove(token);
	}

}