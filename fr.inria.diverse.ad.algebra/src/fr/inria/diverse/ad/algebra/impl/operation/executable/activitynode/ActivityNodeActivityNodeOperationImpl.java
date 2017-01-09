package fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivityNode;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityEdgeOperation;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;
import fr.inria.diverse.ad.algebra.operation.TokenOperation;

public abstract class ActivityNodeActivityNodeOperationImpl implements ActivityNodeOperation {
			
			
	private final ActivityNode activityNode;
	protected ExecutableADAlgebra alg;

	public ActivityNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final ActivityNode activityNode) {
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
		return this.isRunning();
	}

	@Override
	public void sendOffers(final List<Token> tokens) {
		for (final ActivityEdge edge : this.activityNode.getOutgoing()) {
			this.alg.$(edge).sendOffer(tokens);
		}
	}

	@Override
	public List<Token> takeOfferdTokens() {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : this.activityNode.getIncoming())	 {
			final ActivityEdgeOperation activityEdgeOperation = this.alg.$(edge);
			final List<Token> tokens = activityEdgeOperation.takeOfferedTokens();
			for (final Token token : tokens) {
				final TokenOperation $2 = this.alg.$(token);
				$2.withdraw();
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public void addTokens(final List<Token> tokens) {
		for (final Token token : tokens) {
			final TokenOperation nodeOperation = this.alg.$(token);
			final Token transferredToken = nodeOperation.transfer(this.activityNode);
			this.activityNode.getHeldTokens().add(transferredToken);
		}
	}

	@Override
	public boolean hasOffers() {
		boolean hasOffer = true;
		for (final ActivityEdge edge : this.activityNode.getIncoming()) {
			if (!this.alg.$(edge).hasOffer()) {
				hasOffer = false;
			}
		}
		return hasOffer;
	}

	@Override
	public void removeToken(final Token token) {
		this.activityNode.getHeldTokens().remove(token);
	}

}
