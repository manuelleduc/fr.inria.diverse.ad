package fr.inria.diverse.ad.visitor2;

import java.util.List;

import activitydiagram.Activity;
import activitydiagram.InputValue;
import fr.inria.diverse.ad.visitor2.injector.SpringInjector;
import fr.inria.diverse.ad.visitor2.visitor.ActivityMainVisitor;

public class Activitydiagram {

	public void start(final Activity activity, final List<InputValue> inputValues) {
		SpringInjector.start();

		final ActivityMainVisitor activityMainVisitor = SpringInjector.getBean(ActivityMainVisitor.class);

		activity.accept(activityMainVisitor).main(inputValues);

		SpringInjector.close();
	}

}
