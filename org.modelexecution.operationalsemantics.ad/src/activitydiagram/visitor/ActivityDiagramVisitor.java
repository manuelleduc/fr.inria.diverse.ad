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

public interface ActivityDiagramVisitor<T> {

	T visitActivity(Activity activity);

	T visitActivityFinalNode(ActivityFinalNode activityFinalNode);

	T visitBooleanBinaryExpression(BooleanBinaryExpression booleanBinaryExpression);

	T visitBooleanUnaryExpression(BooleanUnaryExpression booleanUnaryExpression);

	T visitBooleanValue(BooleanValue booleanValue);

	T visitBooleanVariable(BooleanVariable booleanVariable);

	T visitControlFlow(ControlFlow controlFlow);

	T visitControlToken(ControlToken controlToken);

	T visitDecisionNode(DecisionNode decisionNode);

	T visitForkedToken(ForkedToken forkedToken);

	T visitForkNode(ForkNode forkNode);

	T visitInitialNode(InitialNode initialNode);

	T visitInput(Input input);

	T visitInputValue(InputValue inputValue);

	T visitIntegerCalculationExpression(IntegerCalculationExpression integerCalculationExpression);

	T visitIntegerComparisonExpression(IntegerComparisonExpression integerComparisonExpression);

	T visitIntegerValue(IntegerValue integerValue);

	T visitIntegerVariable(IntegerVariable integerVariable);

	T visitJoinNode(JoinNode joinNode);

	T visitMergeNode(MergeNode mergeNode);

	T visitOffer(Offer offer);

	T visitOpaqueAction(OpaqueAction opaqueAction);

	T visitTrace(Trace trace);

}
