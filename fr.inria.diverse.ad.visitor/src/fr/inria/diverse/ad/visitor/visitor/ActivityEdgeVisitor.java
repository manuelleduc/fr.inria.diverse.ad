package fr.inria.diverse.ad.visitor.visitor;

import activitydiagram.ControlFlow;
import activitydiagram.util.ActivitydiagramSwitch;
import fr.inria.diverse.ad.visitor.impl.operation.executable.activityedge.ControlFlowActivityEdgeOperationImpl;
import fr.inria.diverse.ad.visitor.operation.ActivityEdgeOperation;

public class ActivityEdgeVisitor extends ActivitydiagramSwitch<ActivityEdgeOperation> {

	@Override
	public ActivityEdgeOperation caseControlFlow(ControlFlow object) {
		return new ControlFlowActivityEdgeOperationImpl(object);
	}

}
