package fr.inria.diverse.ad.visitor;

import activitydiagram.Activity;
import activitydiagram.util.ActivitydiagramSwitch;
import fr.inria.diverse.ad.impl.operation.executable.activity.ActivityActivityOperationImpl;
import fr.inria.diverse.ad.operation.ActivityOperation;

public class ActivityVisitor extends ActivitydiagramSwitch<ActivityOperation> {
	
	@Override
	public ActivityOperation caseActivity(final Activity activity) {
		return new ActivityActivityOperationImpl(activity);
	}

}
