package fr.inria.diverse.ad.visitor2.visitor;

import activitydiagram.Activity;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;
import fr.inria.diverse.ad.visitor2.operation.ActivityMainOperation;

public class ActivityMainVisitor extends ActivityDiagramVisitorDefault<ActivityMainOperation> {

	@Override
	public ActivityMainOperation visitActivity(Activity activity) {
		return new ActivityMainOperation(activity);
	}

}
