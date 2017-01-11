package fr.inria.diverse.ad.visitor2.visitor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.ActivityEdge;
import activitydiagram.ActivityFinalNode;
import activitydiagram.ActivityNode;
import activitydiagram.DecisionNode;
import activitydiagram.ForkNode;
import activitydiagram.InitialNode;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.OpaqueAction;
import activitydiagram.Token;
import activitydiagram.visitor.ActivityDiagramVisitor;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class ActivityNodeTakeOfferdTokensVisitor extends ActivityDiagramVisitorDefault<List<Token>> {

	@Autowired
	ActivityDiagramVisitor<List<Token>> activityNodeActivityNodeTakeOfferdTokensVisitor;

	@Autowired
	TokenWithdrawVisitor tokenWithdrawVisitor;

	@Autowired
	TokenTakeOfferedTokensVisitor tokenTakeOfferedTokensVisitor;

	private List<Token> visitActivityNode(final ActivityNode activityNode) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : activityNode.getIncoming()) {
			final List<Token> tokens = edge.accept(this.activityNodeActivityNodeTakeOfferdTokensVisitor);
			for (final Token token : tokens) {
				token.accept(this.tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public List<Token> visitInitialNode(final InitialNode initialNode) {
		return this.visitActivityNode(initialNode);
	}

	@Override
	public List<Token> visitOpaqueAction(final OpaqueAction opaqueAction) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : opaqueAction.getIncoming()) {
			final List<Token> tokens = edge.accept(this.tokenTakeOfferedTokensVisitor);
			for (final Token token : tokens) {
				token.accept(this.tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public List<Token> visitActivityFinalNode(final ActivityFinalNode activityFinalNode) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : activityFinalNode.getIncoming()) {
			final List<Token> tokens = edge.accept(this.tokenTakeOfferedTokensVisitor);
			for (final Token token : tokens) {
				token.accept(this.tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public List<Token> visitForkNode(ForkNode forkNode) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : forkNode.getIncoming()) {
			final List<Token> tokens = edge.accept(tokenTakeOfferedTokensVisitor);
			for (final Token token : tokens) {
				token.accept(tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public List<Token> visitJoinNode(JoinNode joinNode) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : joinNode.getIncoming()) {
			final List<Token> tokens = edge.accept(activityNodeActivityNodeTakeOfferdTokensVisitor);
			for (final Token token : tokens) {
				token.accept(tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public List<Token> visitDecisionNode(DecisionNode decisionNode) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : decisionNode.getIncoming()) {
			final List<Token> tokens = edge.accept(activityNodeActivityNodeTakeOfferdTokensVisitor);
			for (final Token token : tokens) {
				token.accept(tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

	@Override
	public List<Token> visitMergeNode(MergeNode mergeNode) {
		final List<Token> allTokens = new ArrayList<Token>();
		for (final ActivityEdge edge : mergeNode.getIncoming()) {
			final List<Token> tokens = edge.accept(activityNodeActivityNodeTakeOfferdTokensVisitor);
			for (final Token token : tokens) {
				token.accept(tokenWithdrawVisitor);
			}
			allTokens.addAll(tokens);
		}
		return allTokens;
	}

}
