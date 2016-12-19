package activitydiagram.algebra;

import activitydiagram.Action;
import activitydiagram.Activity;
import activitydiagram.ActivityEdge;
import activitydiagram.ActivityFinalNode;
import activitydiagram.ActivityNode;
import activitydiagram.BooleanBinaryExpression;
import activitydiagram.BooleanExpression;
import activitydiagram.BooleanUnaryExpression;
import activitydiagram.BooleanValue;
import activitydiagram.BooleanVariable;
import activitydiagram.ControlFlow;
import activitydiagram.ControlNode;
import activitydiagram.ControlToken;
import activitydiagram.DecisionNode;
import activitydiagram.ExecutableNode;
import activitydiagram.Expression;
import activitydiagram.FinalNode;
import activitydiagram.ForkNode;
import activitydiagram.ForkedToken;
import activitydiagram.InitialNode;
import activitydiagram.Input;
import activitydiagram.InputValue;
import activitydiagram.IntegerCalculationExpression;
import activitydiagram.IntegerComparisonExpression;
import activitydiagram.IntegerExpression;
import activitydiagram.IntegerValue;
import activitydiagram.IntegerVariable;
import activitydiagram.JoinNode;
import activitydiagram.MergeNode;
import activitydiagram.NamedElement;
import activitydiagram.Offer;
import activitydiagram.OpaqueAction;
import activitydiagram.Token;
import activitydiagram.Trace;
import activitydiagram.Value;
import activitydiagram.Variable;

/*
# Generation details
## Roots details
- A: Activity
- B: ActivityNode
- C: ActivityEdge
- E: Variable
- F: Value
- G: Expression
- H: Offer
- I: Token
- J: Trace
- K: InputValue
- L: Input
*/

public interface ActivitydiagramAlgebra<A, B, C, D, E, F, G, H, I, J, K, L> {
	
	
		// root parent = Activity
		A activity(final Activity activity);
		
	
		// root parent = ActivityNode
		B activityFinalNode(final ActivityFinalNode activityFinalNode);
		
	
		// root parent = Expression
		G booleanBinaryExpression(final BooleanBinaryExpression booleanBinaryExpression);
		
	
		// root parent = Expression
		G booleanUnaryExpression(final BooleanUnaryExpression booleanUnaryExpression);
		
	
		// root parent = Value
		F booleanValue(final BooleanValue booleanValue);
		
	
		// root parent = Variable
		E booleanVariable(final BooleanVariable booleanVariable);
		
	
		// root parent = ActivityEdge
		C controlFlow(final ControlFlow controlFlow);
		
	
		// root parent = Token
		I controlToken(final ControlToken controlToken);
		
	
		// root parent = ActivityNode
		B decisionNode(final DecisionNode decisionNode);
		
	
		// root parent = ActivityNode
		B forkNode(final ForkNode forkNode);
		
	
		// root parent = Token
		I forkedToken(final ForkedToken forkedToken);
		
	
		// root parent = ActivityNode
		B initialNode(final InitialNode initialNode);
		
	
		// root parent = Input
		L input(final Input input);
		
	
		// root parent = InputValue
		K inputValue(final InputValue inputValue);
		
	
		// root parent = Expression
		G integerCalculationExpression(final IntegerCalculationExpression integerCalculationExpression);
		
	
		// root parent = Expression
		G integerComparisonExpression(final IntegerComparisonExpression integerComparisonExpression);
		
	
		// root parent = Value
		F integerValue(final IntegerValue integerValue);
		
	
		// root parent = Variable
		E integerVariable(final IntegerVariable integerVariable);
		
	
		// root parent = ActivityNode
		B joinNode(final JoinNode joinNode);
		
	
		// root parent = ActivityNode
		B mergeNode(final MergeNode mergeNode);
		
	
		// root parent = Offer
		H offer(final Offer offer);
		
	
		// root parent = ActivityNode
		B opaqueAction(final OpaqueAction opaqueAction);
		
	
		// root parent = Trace
		J trace(final Trace trace);
		
	public default A $(final Activity activity) {
		final A ret;
		if (activity instanceof Activity) {
						ret = this.activity((Activity) activity);
		} else {
			throw new RuntimeException("Unknow Activity " + activity);
		}
		return ret;
	}
	
	public default B $(final ActivityNode activityNode) {
		final B ret;
		if (activityNode instanceof DecisionNode) {
						ret = this.decisionNode((DecisionNode) activityNode);
		} else if (activityNode instanceof ActivityFinalNode) {
						ret = this.activityFinalNode((ActivityFinalNode) activityNode);
		} else if (activityNode instanceof ForkNode) {
						ret = this.forkNode((ForkNode) activityNode);
		} else if (activityNode instanceof InitialNode) {
						ret = this.initialNode((InitialNode) activityNode);
		} else if (activityNode instanceof JoinNode) {
						ret = this.joinNode((JoinNode) activityNode);
		} else if (activityNode instanceof MergeNode) {
						ret = this.mergeNode((MergeNode) activityNode);
		} else if (activityNode instanceof OpaqueAction) {
						ret = this.opaqueAction((OpaqueAction) activityNode);
		} else {
			throw new RuntimeException("Unknow ActivityNode " + activityNode);
		}
		return ret;
	}
	
	public default C $(final ActivityEdge activityEdge) {
		final C ret;
		if (activityEdge instanceof ControlFlow) {
						ret = this.controlFlow((ControlFlow) activityEdge);
		} else {
			throw new RuntimeException("Unknow ActivityEdge " + activityEdge);
		}
		return ret;
	}
	
	public default E $(final Variable variable) {
		final E ret;
		if (variable instanceof BooleanVariable) {
						ret = this.booleanVariable((BooleanVariable) variable);
		} else if (variable instanceof IntegerVariable) {
						ret = this.integerVariable((IntegerVariable) variable);
		} else {
			throw new RuntimeException("Unknow Variable " + variable);
		}
		return ret;
	}
	
	public default F $(final Value value) {
		final F ret;
		if (value instanceof BooleanValue) {
						ret = this.booleanValue((BooleanValue) value);
		} else if (value instanceof IntegerValue) {
						ret = this.integerValue((IntegerValue) value);
		} else {
			throw new RuntimeException("Unknow Value " + value);
		}
		return ret;
	}
	
	public default G $(final Expression expression) {
		final G ret;
		if (expression instanceof BooleanBinaryExpression) {
						ret = this.booleanBinaryExpression((BooleanBinaryExpression) expression);
		} else if (expression instanceof BooleanUnaryExpression) {
						ret = this.booleanUnaryExpression((BooleanUnaryExpression) expression);
		} else if (expression instanceof IntegerCalculationExpression) {
						ret = this.integerCalculationExpression((IntegerCalculationExpression) expression);
		} else if (expression instanceof IntegerComparisonExpression) {
						ret = this.integerComparisonExpression((IntegerComparisonExpression) expression);
		} else {
			throw new RuntimeException("Unknow Expression " + expression);
		}
		return ret;
	}
	
	public default H $(final Offer offer) {
		final H ret;
		if (offer instanceof Offer) {
						ret = this.offer((Offer) offer);
		} else {
			throw new RuntimeException("Unknow Offer " + offer);
		}
		return ret;
	}
	
	public default I $(final Token token) {
		final I ret;
		if (token instanceof ControlToken) {
						ret = this.controlToken((ControlToken) token);
		} else if (token instanceof ForkedToken) {
						ret = this.forkedToken((ForkedToken) token);
		} else {
			throw new RuntimeException("Unknow Token " + token);
		}
		return ret;
	}
	
	public default J $(final Trace trace) {
		final J ret;
		if (trace instanceof Trace) {
						ret = this.trace((Trace) trace);
		} else {
			throw new RuntimeException("Unknow Trace " + trace);
		}
		return ret;
	}
	
	public default K $(final InputValue inputValue) {
		final K ret;
		if (inputValue instanceof InputValue) {
						ret = this.inputValue((InputValue) inputValue);
		} else {
			throw new RuntimeException("Unknow InputValue " + inputValue);
		}
		return ret;
	}
	
	public default L $(final Input input) {
		final L ret;
		if (input instanceof Input) {
						ret = this.input((Input) input);
		} else {
			throw new RuntimeException("Unknow Input " + input);
		}
		return ret;
	}
}