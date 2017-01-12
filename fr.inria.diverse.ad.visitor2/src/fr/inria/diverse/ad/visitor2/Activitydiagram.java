package fr.inria.diverse.ad.visitor2;

import java.util.List;

import activitydiagram.Activity;
import activitydiagram.InputValue;
import fr.inria.diverse.ad.visitor2.injector.SpringInjector;
import fr.inria.diverse.ad.visitor2.visitor.ActivityMainVisitor;

public class Activitydiagram {

	public long start(final Activity activity, final List<InputValue> inputValues) {
		SpringInjector.start();

		final ActivityMainVisitor activityMainVisitor = SpringInjector.getBean(ActivityMainVisitor.class);

		final long start = System.currentTimeMillis();
		activity.accept(activityMainVisitor).main(inputValues);
		final long stop = System.currentTimeMillis();

		SpringInjector.close();
		return stop - start;
	}

}
