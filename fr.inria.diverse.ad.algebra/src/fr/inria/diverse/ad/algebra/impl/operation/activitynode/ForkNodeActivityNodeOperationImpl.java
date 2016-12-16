package fr.inria.diverse.ad.algebra.impl.operation.activitynode;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.ForkNode;
import activitydiagram.ForkedToken;
import activitydiagram.Token;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;

public class ForkNodeActivityNodeOperationImpl extends ControlNodeActivityNodeImpl {
	private final ForkNode forkNode;

	public ForkNodeActivityNodeOperationImpl(final ExecutableADAlgebra alg, final ForkNode forkNode) {
		super(alg, forkNode);
		this.forkNode = forkNode;
	}

	@Override
	public void fire(final List<Token> tokens) {
		// TODO
		final List<Token> forkedTokens = new ArrayList<Token>();
		for (final Token token : tokens) {
			final ForkedToken forkedToken = ActivitydiagramFactory.eINSTANCE.createForkedToken();
			forkedToken.setBaseToken(token);
			forkedToken.setRemainingOffersCount(this.forkNode.getOutgoing().size());
			forkedTokens.add(forkedToken);
		}
		this.addTokens(forkedTokens);
		this.sendOffers(forkedTokens);

	}
}