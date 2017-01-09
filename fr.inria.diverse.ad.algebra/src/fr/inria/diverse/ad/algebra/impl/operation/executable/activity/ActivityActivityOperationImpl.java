package fr.inria.diverse.ad.algebra.impl.operation.executable.activity;

import java.util.ArrayList;
import java.util.List;

import activitydiagram.Activity;
import activitydiagram.ActivityNode;
import activitydiagram.ActivitydiagramFactory;
import activitydiagram.InitialNode;
import activitydiagram.InputValue;
import activitydiagram.Token;
import activitydiagram.Trace;
import activitydiagram.Variable;
import fr.inria.diverse.ad.algebra.impl.ExecutableADAlgebra;
import fr.inria.diverse.ad.algebra.operation.ActivityOperation;

public class ActivityActivityOperationImpl implements ActivityOperation {
	private final Activity activity;
	private final ExecutableADAlgebra alg;

	public ActivityActivityOperationImpl(final ExecutableADAlgebra alg, final Activity activity) {
		this.activity = activity;
		this.alg = alg;
	}

	private void initialize(final List<InputValue> inputValues) {
		for (final Variable v : this.activity.getLocals()) {
			v.setCurrentValue(v.getInitialValue());
		}
		if (inputValues != null) {
			for (final InputValue v : inputValues) {
				v.getVariable().setCurrentValue(v.getValue());
			}
		}

	}

	@Override
	public void main(final List<InputValue> inputValues) {
		this.initialize(inputValues);
		this.initializeTrace();
		this.run();
	}

	private void run() {
		this.runNodes();

		this.fireInitialNode();

		List<ActivityNode> enabledNodes = this.getEnabledNodes();
		while (enabledNodes.size() > 0) {
			final ActivityNode nextNode = this.selectNextNode(enabledNodes);
			this.fireNode(nextNode);
			enabledNodes = this.getEnabledNodes();
		}

	}

	private ActivityNode selectNextNode(final List<ActivityNode> activityNodes) {
		return activityNodes.get(0);
	}

	private List<ActivityNode> getEnabledNodes() {
		final List<ActivityNode> enabledNodes = new ArrayList<ActivityNode>();
		for (final ActivityNode node : this.activity.getNodes()) {
			if (this.alg.$(node).isReady()) {
				enabledNodes.add(node);
			}
		}
		return enabledNodes;
	}

	private void fireInitialNode() {
		final InitialNode initialNode = this.getInitialNode();
		this.fireNode(initialNode);

	}

	private void fireNode(final ActivityNode node) {
		// System.out.println("fire node " + node.getName());
		final List<Token> tokens = this.alg.$(node).takeOfferdTokens();
		this.alg.$(node).fire(tokens);
		this.activity.getTrace().getExecutedNodes().add(node);
	}

	private InitialNode getInitialNode() {
		for (final ActivityNode node : this.activity.getNodes()) {
			if (node instanceof InitialNode) {
				return (InitialNode) node;
			}
		}
		return null;
	}

	private void runNodes() {
		for (final ActivityNode node : this.activity.getNodes()) {
			this.alg.$(node).run();
		}

	}

	private void initializeTrace() {
		final Trace trace = ActivitydiagramFactory.eINSTANCE.createTrace();
		this.activity.setTrace(trace);

	}

	@Override
	public void terminate() {
		for (final ActivityNode node : this.activity.getNodes()) {
			this.alg.$(node).terminate();
		}
	}
}