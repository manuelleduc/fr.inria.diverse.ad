package activitydiagram.algebra;

import activitydiagram.Activity;
import activitydiagram.ActivityEdge;
import activitydiagram.ActivityFinalNode;
import activitydiagram.ActivityNode;
import activitydiagram.BooleanBinaryExpression;
import activitydiagram.BooleanUnaryExpression;
import activitydiagram.BooleanValue;
import activitydiagram.BooleanVariable;
import activitydiagram.ControlFlow;
import activitydiagram.ControlToken;
import activitydiagram.DecisionNode;
import activitydiagram.Expression;
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
import activitydiagram.Token;
import activitydiagram.Trace;
import activitydiagram.Value;
import activitydiagram.Variable;
import java.util.Map;

public interface ActivitydiagramAlgebra<A, B, C, D, E, F, G, H, I, K, L> {

	B activity(final Activity activity);

	A activityFinalNode(final ActivityFinalNode activityFinalNode);

	D booleanBinaryExpression(final BooleanBinaryExpression booleanBinaryExpression);

	D booleanUnaryExpression(final BooleanUnaryExpression booleanUnaryExpression);

	E booleanValue(final BooleanValue booleanValue);

	F booleanVariable(final BooleanVariable booleanVariable);

	C controlFlow(final ControlFlow controlFlow);

	G controlToken(final ControlToken controlToken);

	A decisionNode(final DecisionNode decisionNode);

	A forkNode(final ForkNode forkNode);

	G forkedToken(final ForkedToken forkedToken);

	A initialNode(final InitialNode initialNode);

	H input(final Input input);

	I inputValue(final InputValue inputValue);

	D integerCalculationExpression(final IntegerCalculationExpression integerCalculationExpression);

	D integerComparisonExpression(final IntegerComparisonExpression integerComparisonExpression);

	E integerValue(final IntegerValue integerValue);

	F integerVariable(final IntegerVariable integerVariable);

	A joinNode(final JoinNode joinNode);

	A mergeNode(final MergeNode mergeNode);

	K offer(final Offer offer);

	A opaqueAction(final OpaqueAction opaqueAction);

	L trace(final Trace trace);

	
	public default Map<ActivityNode, A> getActivityNodeMemo() {
		return null;
	}
	
	public default A $(final ActivityNode activityNode) {
		final A ret;
		final Map<ActivityNode, A> memo = getActivityNodeMemo();
		if(memo != null && memo.containsKey(activityNode)) {
			ret = memo.get(activityNode);
		} else {
			if (activityNode.eClass().getName().equals("ActivityFinalNode")) {
				ret = this.activityFinalNode((ActivityFinalNode) activityNode);
			} else if (activityNode.eClass().getName().equals("DecisionNode")) {
				ret = this.decisionNode((DecisionNode) activityNode);
			} else if (activityNode.eClass().getName().equals("ForkNode")) {
				ret = this.forkNode((ForkNode) activityNode);
			} else if (activityNode.eClass().getName().equals("InitialNode")) {
				ret = this.initialNode((InitialNode) activityNode);
			} else if (activityNode.eClass().getName().equals("JoinNode")) {
				ret = this.joinNode((JoinNode) activityNode);
			} else if (activityNode.eClass().getName().equals("MergeNode")) {
				ret = this.mergeNode((MergeNode) activityNode);
			} else if (activityNode.eClass().getName().equals("OpaqueAction")) {
				ret = this.opaqueAction((OpaqueAction) activityNode);
			} else {
				throw new RuntimeException("Unknow ActivityNode " + activityNode);
		}
			if(memo != null) memo.put(activityNode, ret);
		}
		return ret;
	}
	
	public default Map<Activity, B> getActivityMemo() {
		return null;
	}
	
	public default B $(final Activity activity) {
		final B ret;
		final Map<Activity, B> memo = getActivityMemo();
		if(memo != null && memo.containsKey(activity)) {
			ret = memo.get(activity);
		} else {
			if (activity.eClass().getName().equals("Activity")) {
				ret = this.activity((Activity) activity);
			} else {
				throw new RuntimeException("Unknow Activity " + activity);
		}
			if(memo != null) memo.put(activity, ret);
		}
		return ret;
	}
	
	public default Map<ActivityEdge, C> getActivityEdgeMemo() {
		return null;
	}
	
	public default C $(final ActivityEdge activityEdge) {
		final C ret;
		final Map<ActivityEdge, C> memo = getActivityEdgeMemo();
		if(memo != null && memo.containsKey(activityEdge)) {
			ret = memo.get(activityEdge);
		} else {
			if (activityEdge.eClass().getName().equals("ControlFlow")) {
				ret = this.controlFlow((ControlFlow) activityEdge);
			} else {
				throw new RuntimeException("Unknow ActivityEdge " + activityEdge);
		}
			if(memo != null) memo.put(activityEdge, ret);
		}
		return ret;
	}
	
	public default Map<Expression, D> getExpressionMemo() {
		return null;
	}
	
	public default D $(final Expression expression) {
		final D ret;
		final Map<Expression, D> memo = getExpressionMemo();
		if(memo != null && memo.containsKey(expression)) {
			ret = memo.get(expression);
		} else {
			if (expression.eClass().getName().equals("BooleanBinaryExpression")) {
				ret = this.booleanBinaryExpression((BooleanBinaryExpression) expression);
			} else if (expression.eClass().getName().equals("BooleanUnaryExpression")) {
				ret = this.booleanUnaryExpression((BooleanUnaryExpression) expression);
			} else if (expression.eClass().getName().equals("IntegerCalculationExpression")) {
				ret = this.integerCalculationExpression((IntegerCalculationExpression) expression);
			} else if (expression.eClass().getName().equals("IntegerComparisonExpression")) {
				ret = this.integerComparisonExpression((IntegerComparisonExpression) expression);
			} else {
				throw new RuntimeException("Unknow Expression " + expression);
		}
			if(memo != null) memo.put(expression, ret);
		}
		return ret;
	}
	
	public default Map<Value, E> getValueMemo() {
		return null;
	}
	
	public default E $(final Value value) {
		final E ret;
		final Map<Value, E> memo = getValueMemo();
		if(memo != null && memo.containsKey(value)) {
			ret = memo.get(value);
		} else {
			if (value.eClass().getName().equals("BooleanValue")) {
				ret = this.booleanValue((BooleanValue) value);
			} else if (value.eClass().getName().equals("IntegerValue")) {
				ret = this.integerValue((IntegerValue) value);
			} else {
				throw new RuntimeException("Unknow Value " + value);
		}
			if(memo != null) memo.put(value, ret);
		}
		return ret;
	}
	
	public default Map<Variable, F> getVariableMemo() {
		return null;
	}
	
	public default F $(final Variable variable) {
		final F ret;
		final Map<Variable, F> memo = getVariableMemo();
		if(memo != null && memo.containsKey(variable)) {
			ret = memo.get(variable);
		} else {
			if (variable.eClass().getName().equals("BooleanVariable")) {
				ret = this.booleanVariable((BooleanVariable) variable);
			} else if (variable.eClass().getName().equals("IntegerVariable")) {
				ret = this.integerVariable((IntegerVariable) variable);
			} else {
				throw new RuntimeException("Unknow Variable " + variable);
		}
			if(memo != null) memo.put(variable, ret);
		}
		return ret;
	}
	
	public default Map<Token, G> getTokenMemo() {
		return null;
	}
	
	public default G $(final Token token) {
		final G ret;
		final Map<Token, G> memo = getTokenMemo();
		if(memo != null && memo.containsKey(token)) {
			ret = memo.get(token);
		} else {
			if (token.eClass().getName().equals("ControlToken")) {
				ret = this.controlToken((ControlToken) token);
			} else if (token.eClass().getName().equals("ForkedToken")) {
				ret = this.forkedToken((ForkedToken) token);
			} else {
				throw new RuntimeException("Unknow Token " + token);
		}
			if(memo != null) memo.put(token, ret);
		}
		return ret;
	}
	
	public default Map<Input, H> getInputMemo() {
		return null;
	}
	
	public default H $(final Input input) {
		final H ret;
		final Map<Input, H> memo = getInputMemo();
		if(memo != null && memo.containsKey(input)) {
			ret = memo.get(input);
		} else {
			if (input.eClass().getName().equals("Input")) {
				ret = this.input((Input) input);
			} else {
				throw new RuntimeException("Unknow Input " + input);
		}
			if(memo != null) memo.put(input, ret);
		}
		return ret;
	}
	
	public default Map<InputValue, I> getInputValueMemo() {
		return null;
	}
	
	public default I $(final InputValue inputValue) {
		final I ret;
		final Map<InputValue, I> memo = getInputValueMemo();
		if(memo != null && memo.containsKey(inputValue)) {
			ret = memo.get(inputValue);
		} else {
			if (inputValue.eClass().getName().equals("InputValue")) {
				ret = this.inputValue((InputValue) inputValue);
			} else {
				throw new RuntimeException("Unknow InputValue " + inputValue);
		}
			if(memo != null) memo.put(inputValue, ret);
		}
		return ret;
	}
	
	public default Map<Offer, K> getOfferMemo() {
		return null;
	}
	
	public default K $(final Offer offer) {
		final K ret;
		final Map<Offer, K> memo = getOfferMemo();
		if(memo != null && memo.containsKey(offer)) {
			ret = memo.get(offer);
		} else {
			if (offer.eClass().getName().equals("Offer")) {
				ret = this.offer((Offer) offer);
			} else {
				throw new RuntimeException("Unknow Offer " + offer);
		}
			if(memo != null) memo.put(offer, ret);
		}
		return ret;
	}
	
	public default Map<Trace, L> getTraceMemo() {
		return null;
	}
	
	public default L $(final Trace trace) {
		final L ret;
		final Map<Trace, L> memo = getTraceMemo();
		if(memo != null && memo.containsKey(trace)) {
			ret = memo.get(trace);
		} else {
			if (trace.eClass().getName().equals("Trace")) {
				ret = this.trace((Trace) trace);
			} else {
				throw new RuntimeException("Unknow Trace " + trace);
		}
			if(memo != null) memo.put(trace, ret);
		}
		return ret;
	}
}