package fr.inria.diverse.ad.algebra.impl;

import activitydiagram.Activity;
import activitydiagram.ActivityFinalNode;
import activitydiagram.BooleanBinaryExpression;
import activitydiagram.BooleanUnaryExpression;
import activitydiagram.BooleanValue;
import activitydiagram.BooleanVariable;
import activitydiagram.ControlFlow;
import activitydiagram.ControlToken;
import activitydiagram.DecisionNode;
import activitydiagram.ForkNode;
import activitydiagram.ForkedToken;
import activitydiagram.InitialNode;
import activitydiagram.Input;
import activitydiagram.InputValue;
import activitydiagram.IntegerCalculationExpression;
import activitydiagram.IntegerComparisonExpression;
import activitydiagram.IntegerValue;
import activitydiagram.IntegerVariable;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.Offer;
import activitydiagram.OpaqueAction;
import activitydiagram.Trace;
import activitydiagram.algebra.ActivitydiagramAlgebra;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activity.ActivityActivityOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activityedge.ControlFlowActivityEdgeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.ActivityFinalNodeActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.DecisionNodeActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.ForkNodeActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.InitialNodeActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.JoinNodeActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.MergeNodeActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.activitynode.OpageActionActivityNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation.BooleanBinaryExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation.BooleanUnaryExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation.IntegerCalculationExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.expressionoperation.IntegerComparisonExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.offer.OfferOfferOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.token.ControlTokenNodeOperationImpl;
import fr.inria.diverse.ad.algebra.impl.operation.executable.token.ForkedTokenNodeOperationImpl;
import fr.inria.diverse.ad.algebra.operation.ActivityEdgeOperation;
import fr.inria.diverse.ad.algebra.operation.ActivityNodeOperation;
import fr.inria.diverse.ad.algebra.operation.ActivityOperation;
import fr.inria.diverse.ad.algebra.operation.ExpressionOperation;
import fr.inria.diverse.ad.algebra.operation.TokenOperation;
import fr.inria.diverse.ad.algebra.operation.OfferOperation;

public interface ExecutableADAlgebra extends
		ActivitydiagramAlgebra<ActivityNodeOperation, ActivityOperation, ActivityEdgeOperation, ExpressionOperation, Void, Void, TokenOperation, Void, Void, OfferOperation, Void> {

	@Override
	default ActivityOperation activity(final Activity activity) {
		return new ActivityActivityOperationImpl(this, activity);
	}

	@Override
	default ActivityNodeOperation activityFinalNode(final ActivityFinalNode activityFinalNode) {
		return new ActivityFinalNodeActivityNodeOperationImpl(this, activityFinalNode);
	}

	@Override
	default ActivityNodeOperation decisionNode(final DecisionNode decisionNode) {
		return new DecisionNodeActivityNodeOperationImpl(this, decisionNode);
	}

	@Override
	default ActivityNodeOperation forkNode(final ForkNode forkNode) {
		return new ForkNodeActivityNodeOperationImpl(this, forkNode);
	}

	@Override
	default ActivityNodeOperation initialNode(final InitialNode initialNode) {
		return new InitialNodeActivityNodeOperationImpl(this, initialNode);
	}

	@Override
	default ActivityNodeOperation joinNode(final JoinNode joinNode) {
		return new JoinNodeActivityNodeOperationImpl(this, joinNode);
	}

	@Override
	default ActivityNodeOperation mergeNode(final MergeNode mergeNode) {
		return new MergeNodeActivityNodeOperationImpl(this, mergeNode);
	}

	@Override
	default ActivityNodeOperation opaqueAction(final OpaqueAction opaqueAction) {
		return new OpageActionActivityNodeOperationImpl(this, opaqueAction);
	}

	@Override
	default ExpressionOperation booleanBinaryExpression(final BooleanBinaryExpression booleanBinaryExpression) {
		return new BooleanBinaryExpressionExpressionOperationImpl(this, booleanBinaryExpression);
	}

	@Override
	default ExpressionOperation booleanUnaryExpression(final BooleanUnaryExpression booleanUnaryExpression) {
		return new BooleanUnaryExpressionExpressionOperationImpl(this, booleanUnaryExpression);
	}

	@Override
	default Void booleanValue(final BooleanValue booleanValue) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	default Void booleanVariable(final BooleanVariable booleanVariable) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	default ActivityEdgeOperation controlFlow(final ControlFlow controlFlow) {
		return new ControlFlowActivityEdgeOperationImpl(this, controlFlow);
	}

	@Override
	default TokenOperation controlToken(final ControlToken controlToken) {
		return new ControlTokenNodeOperationImpl(this, controlToken);
	}

	@Override
	default TokenOperation forkedToken(final ForkedToken forkedlToken) {
		return new ForkedTokenNodeOperationImpl(this, forkedlToken);
	}

	@Override
	default Void input(final Input input) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	default Void inputValue(final InputValue inputValue) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	default ExpressionOperation integerCalculationExpression(
			final IntegerCalculationExpression integerCalculationExpression) {
		return new IntegerCalculationExpressionExpressionOperationImpl(this, integerCalculationExpression);
	}

	@Override
	default ExpressionOperation integerComparisonExpression(
			final IntegerComparisonExpression integerComparisonExpression) {
		return new IntegerComparisonExpressionExpressionOperationImpl(this, integerComparisonExpression);
	}

	@Override
	default Void integerValue(final IntegerValue integerValue) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	default Void integerVariable(final IntegerVariable integerVariable) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	default OfferOperation offer(final Offer offer) {
		return new OfferOfferOperationImpl(this, offer);
	}

	@Override
	default Void trace(final Trace trace) {
		throw new RuntimeException("Not implemented");
	}

}
