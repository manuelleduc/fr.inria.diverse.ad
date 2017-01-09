package fr.inria.diverse.ad.visitor.impl.operation.executable.activitynode;

import activitydiagram.Expression;
import activitydiagram.OpaqueAction;
import fr.inria.diverse.ad.visitor.visitor.ExpressionVisitor;

public class OpageActionActivityNodeOperationImpl extends ActionActivityNodeOperationImpl {

	private final OpaqueAction opaqueAction;

	private final ExpressionVisitor expressionVisitor = new ExpressionVisitor();

	public OpageActionActivityNodeOperationImpl(final OpaqueAction opaqueAction) {
		super(opaqueAction);
		this.opaqueAction = opaqueAction;
	}

	@Override
	void doAction() {
		for (final Expression e : this.opaqueAction.getExpressions()) {
			expressionVisitor.doSwitch(e).execute();
		}

	}

}
