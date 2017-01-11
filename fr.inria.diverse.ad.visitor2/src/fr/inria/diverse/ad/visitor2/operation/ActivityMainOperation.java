package fr.inria.diverse.ad.visitor2.operation;

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
import fr.inria.diverse.ad.visitor2.injector.SpringInjector;
import fr.inria.diverse.ad.visitor2.visitor.ActivityNodeFireVisitor;
import fr.inria.diverse.ad.visitor2.visitor.ActivityNodeIsReadyVisitor;
import fr.inria.diverse.ad.visitor2.visitor.ActivityNodeRunVisitor;
import fr.inria.diverse.ad.visitor2.visitor.ActivityNodeTakeOfferdTokensVisitor;

public class ActivityMainOperation {

	private final Activity activity;

	private ActivityNodeTakeOfferdTokensVisitor activityNodeTakeOfferdTokensVisitor = SpringInjector
			.getBean(ActivityNodeTakeOfferdTokensVisitor.class);

	private ActivityNodeFireVisitor activityNodeFireVisitor = SpringInjector.getBean(ActivityNodeFireVisitor.class);

	private ActivityNodeIsReadyVisitor activityNodeIsReadyVisitor = SpringInjector
			.getBean(ActivityNodeIsReadyVisitor.class);

	private ActivityNodeRunVisitor activityNodeRunVisitor = SpringInjector.getBean(ActivityNodeRunVisitor.class);

	public ActivityMainOperation(final Activity activity) {
		this.activity = activity;
	}

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

	private void fireNode(final ActivityNode node) {
		// System.out.println("fire node " + node.getName());
		final List<Token> tokens = node.accept(this.activityNodeTakeOfferdTokensVisitor);
		node.accept(this.activityNodeFireVisitor).fire(tokens);
		this.activity.getTrace().getExecutedNodes().add(node);

	}

	private ActivityNode selectNextNode(final List<ActivityNode> activityNodes) {
		return activityNodes.get(0);
	}

	private List<ActivityNode> getEnabledNodes() {
		final List<ActivityNode> enabledNodes = new ArrayList<ActivityNode>();
		for (final ActivityNode node : this.activity.getNodes()) {
			if (node.accept(this.activityNodeIsReadyVisitor)) {
				enabledNodes.add(node);
			}
		}
		return enabledNodes;
	}

	private void fireInitialNode() {
		final InitialNode initialNode = this.getInitialNode();
		this.fireNode(initialNode);

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
			node.accept(this.activityNodeRunVisitor);
		}
	}

	private void initializeTrace() {
		final Trace trace = ActivitydiagramFactory.eINSTANCE.createTrace();
		this.activity.setTrace(trace);

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
}
