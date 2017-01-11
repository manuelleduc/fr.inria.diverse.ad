package fr.inria.diverse.ad.visitor2.injector;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInjector {
	private static ConfigurableApplicationContext context;

	public static void start() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

	}

	public static <T> T getBean(Class<T> class1) {
		final T activityMainVisitor = context.getBean(class1);
		return activityMainVisitor;
	}

	public static void close() {
		context.close();

	}

}
