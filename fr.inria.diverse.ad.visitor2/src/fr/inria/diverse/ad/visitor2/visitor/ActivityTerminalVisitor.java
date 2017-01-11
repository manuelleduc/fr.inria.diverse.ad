package fr.inria.diverse.ad.visitor2.visitor;

import org.springframework.beans.factory.annotation.Autowired;

import activitydiagram.Activity;
import activitydiagram.ActivityNode;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class ActivityTerminalVisitor extends ActivityDiagramVisitorDefault<Void> {

	@Autowired
	ActivityNodeTerminateVisitor activityNodeTerminateVisitor;
	

	@Override
	public Void visitActivity(Activity activity) {
		for (final ActivityNode node : activity.getNodes()) {
			node.accept(activityNodeTerminateVisitor);
		}
		return null;
	}

}
