package activitydiagram.visitor;

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

public abstract class ActivityDiagramVisitorDefault<T> implements ActivityDiagramVisitor<T> {

	@Override
	public T visitActivity(Activity activity) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitActivityFinalNode(ActivityFinalNode activityFinalNode) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitBooleanBinaryExpression(BooleanBinaryExpression booleanBinaryExpression) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitBooleanUnaryExpression(BooleanUnaryExpression booleanUnaryExpression) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitBooleanValue(BooleanValue booleanValue) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitBooleanVariable(BooleanVariable booleanVariable) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitControlFlow(ControlFlow controlFlow) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitControlToken(ControlToken controlToken) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitDecisionNode(DecisionNode decisionNode) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitForkedToken(ForkedToken forkedToken) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitForkNode(ForkNode forkNode) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitInitialNode(InitialNode initialNode) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitInput(Input input) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitInputValue(InputValue inputValue) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitIntegerCalculationExpression(IntegerCalculationExpression integerCalculationExpression) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitIntegerComparisonExpression(IntegerComparisonExpression integerComparisonExpression) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitIntegerValue(IntegerValue integerValue) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitIntegerVariable(IntegerVariable integerVariable) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitJoinNode(JoinNode joinNode) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitMergeNode(MergeNode mergeNode) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitOffer(Offer offer) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitOpaqueAction(OpaqueAction opaqueAction) {

		throw new RuntimeException("not implemented");
	}

	@Override
	public T visitTrace(Trace trace) {

		throw new RuntimeException("not implemented");
	}

}
