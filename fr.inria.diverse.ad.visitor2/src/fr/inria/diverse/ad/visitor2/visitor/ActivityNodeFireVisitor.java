package fr.inria.diverse.ad.visitor2.visitor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivityFinalNode;
import activitydiagram.ActivityNode;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.BooleanValue;
import activitydiagram.ControlFlow;
import activitydiagram.ControlNode;
import activitydiagram.DecisionNode;
import activitydiagram.Expression;
import activitydiagram.ForkNode;
import activitydiagram.ForkedToken;
import activitydiagram.InitialNode;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.OpaqueAction;
import activitydiagram.Token;
import activitydiagram.Value;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;
import fr.inria.diverse.ad.visitor2.operation.ActivityNodeFireOperation;

public class ActivityNodeFireVisitor extends ActivityDiagramVisitorDefault<ActivityNodeFireOperation> {

	@Autowired
	ActivityEdgeSendOfferVisitor activityEdgeSendOfferVisitor;

	@Autowired
	ActivityTerminalVisitor activityTerminalVisitor;

	@Autowired
	TokenTransfertVisitor tokenTransfertVisitor;

	@Autowired
	ExpressionExecutionVisitor expressionExecuteVisitor;

	@Override
	public ActivityNodeFireOperation visitActivityFinalNode(final ActivityFinalNode activityFinalNode) {
		return tokens -> activityFinalNode.getActivity().accept(ActivityNodeFireVisitor.this.activityTerminalVisitor);
	}

	@Override
	public ActivityNodeFireOperation visitDecisionNode(final DecisionNode decisionNode) {

		return new ActivityNodeFireOperation() {

			@Override
			public void fire(final List<Token> tokens) {
				ActivityEdge selectedEdge = null;
				for (final ActivityEdge edge : decisionNode.getOutgoing()) {
					if (edge instanceof ControlFlow) {
						final ControlFlow controlFlow = (ControlFlow) edge;
						final Value guardValue = controlFlow.getGuard().getCurrentValue();
						if (guardValue instanceof BooleanValue) {
							final BooleanValue booleanValue = (BooleanValue) guardValue;
							if (booleanValue.isValue()) {
								selectedEdge = edge;
								break;
							}
						}
					}
				}

				if (selectedEdge != null) {
					this.addTokens(tokens, decisionNode);
					selectedEdge.accept(ActivityNodeFireVisitor.this.activityEdgeSendOfferVisitor).sendOffer(tokens);
				}
			}

			private void addTokens(final List<Token> tokens, final ActivityNode activityNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(ActivityNodeFireVisitor.this.tokenTransfertVisitor)
							.transfer(activityNode);
					activityNode.getHeldTokens().add(transferredToken);
				}

			}

		};
	}

	private ActivityNodeFireOperation visitControlNode(final ControlNode controlNode) {
		return new ActivityNodeFireOperation() {

			@Override
			public void fire(final List<Token> tokens) {
				this.addTokens(tokens, controlNode);
				this.sendOffers(tokens, controlNode);

			}

			private void sendOffers(final List<Token> tokens, final ControlNode controlNode) {
				for (final ActivityEdge edge : controlNode.getOutgoing()) {
					edge.accept(ActivityNodeFireVisitor.this.activityEdgeSendOfferVisitor).sendOffer(tokens);
				}

			}

			private void addTokens(final List<Token> tokens, final ControlNode controlNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(ActivityNodeFireVisitor.this.tokenTransfertVisitor)
							.transfer(controlNode);
					controlNode.getHeldTokens().add(transferredToken);
				}

			}
		};
	}

	@Override
	public ActivityNodeFireOperation visitInitialNode(final InitialNode initialNode) {

		return new ActivityNodeFireOperation() {

			@Override
			public void fire(final List<Token> tokens) {
				final List<Token> producedTokens = new ArrayList<Token>();
				producedTokens.add(ActivitydiagramFactory.eINSTANCE.createControlToken());
				this.addTokens(producedTokens, initialNode);
				this.sendOffers(producedTokens, initialNode);

			}

			private void sendOffers(final List<Token> tokens, final InitialNode initialNode) {
				for (final ActivityEdge edge : initialNode.getOutgoing()) {
					edge.accept(ActivityNodeFireVisitor.this.activityEdgeSendOfferVisitor).sendOffer(tokens);
				}

			}

			private void addTokens(final List<Token> tokens, final InitialNode initialNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(ActivityNodeFireVisitor.this.tokenTransfertVisitor)
							.transfer(initialNode);
					initialNode.getHeldTokens().add(transferredToken);
				}

			}
		};
	}

	@Override
	public ActivityNodeFireOperation visitOpaqueAction(final OpaqueAction opaqueAction) {
		return new ActivityNodeFireOperation() {

			@Override
			public void fire(final List<Token> tokens) {
				this.doAction(opaqueAction);
				this.sendOffers(opaqueAction);

			}

			private void sendOffers(final OpaqueAction opaqueAction) {
				if (opaqueAction.getOutgoing().size() > 0) {
					final List<Token> tokens = new ArrayList<Token>();
					tokens.add(ActivitydiagramFactory.eINSTANCE.createControlToken());
					this.addTokens(tokens, opaqueAction);
					final ActivityEdge activityEdge = opaqueAction.getOutgoing().get(0);
					activityEdge.accept(ActivityNodeFireVisitor.this.activityEdgeSendOfferVisitor).sendOffer(tokens);
				}

			}

			private void addTokens(final List<Token> tokens, final ActivityNode activityNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(ActivityNodeFireVisitor.this.tokenTransfertVisitor)
							.transfer(activityNode);
					activityNode.getHeldTokens().add(transferredToken);
				}

			}

			private void doAction(final OpaqueAction opaqueAction) {
				for (final Expression e : opaqueAction.getExpressions()) {
					e.accept(ActivityNodeFireVisitor.this.expressionExecuteVisitor);
				}

			}
		};
	}

	@Override
	public ActivityNodeFireOperation visitForkNode(final ForkNode forkNode) {

		return new ActivityNodeFireOperation() {

			@Override
			public void fire(final List<Token> tokens) {
				final List<Token> forkedTokens = new ArrayList<Token>();
				for (final Token token : tokens) {
					final ForkedToken forkedToken = ActivitydiagramFactory.eINSTANCE.createForkedToken();
					forkedToken.setBaseToken(token);
					forkedToken.setRemainingOffersCount(forkNode.getOutgoing().size());
					forkedTokens.add(forkedToken);
				}
				this.addTokens(forkedTokens, forkNode);
				this.sendOffers(forkedTokens, forkNode);

			}

			private void sendOffers(final List<Token> tokens, final ForkNode forkNode) {
				for (final ActivityEdge edge : forkNode.getOutgoing()) {
					edge.accept(ActivityNodeFireVisitor.this.activityEdgeSendOfferVisitor).sendOffer(tokens);
				}

			}

			private void addTokens(final List<Token> tokens, final ForkNode forkNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(ActivityNodeFireVisitor.this.tokenTransfertVisitor)
							.transfer(forkNode);
					forkNode.getHeldTokens().add(transferredToken);
				}

			}
		};
	}

	@Override
	public ActivityNodeFireOperation visitJoinNode(JoinNode joinNode) {
		return new ActivityNodeFireOperation() {

			@Override
			public void fire(List<Token> tokens) {
				this.addTokens(tokens, joinNode);
				this.sendOffers(tokens, joinNode);

			}

			private void sendOffers(List<Token> tokens, JoinNode joinNode) {
				for (final ActivityEdge edge : joinNode.getOutgoing()) {
					edge.accept(activityEdgeSendOfferVisitor).sendOffer(tokens);
				}

			}

			private void addTokens(List<Token> tokens, ActivityNode activityNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(tokenTransfertVisitor).transfer(activityNode);
					activityNode.getHeldTokens().add(transferredToken);
				}

			}
		};
	}

	@Override
	public ActivityNodeFireOperation visitMergeNode(MergeNode mergeNode) {
		return new ActivityNodeFireOperation() {

			@Override
			public void fire(List<Token> tokens) {
				this.addTokens(tokens, mergeNode);
				this.sendOffers(tokens, mergeNode);

			}

			private void sendOffers(List<Token> tokens, MergeNode mergeNode) {
				for (final ActivityEdge edge : mergeNode.getOutgoing()) {
					edge.accept(activityEdgeSendOfferVisitor).sendOffer(tokens);
				}

			}

			private void addTokens(List<Token> tokens, MergeNode mergeNode) {
				for (final Token token : tokens) {
					final Token transferredToken = token.accept(tokenTransfertVisitor).transfer(mergeNode);
					mergeNode.getHeldTokens().add(transferredToken);
				}

			}
		};
	}

}
