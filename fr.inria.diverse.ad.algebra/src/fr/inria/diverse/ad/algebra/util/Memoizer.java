package fr.inria.diverse.ad.algebra.util;

import java.util.IdentityHashMap;
import java.util.Map;

public class Memoizer {
	public final static Map<Object, Object> memo = new IdentityHashMap<>();
	
	public static  boolean alreadyExists(Object activityNode) {
		return memo.containsKey(activityNode);
	}
	
	public static void register(Object activityNode, Object activityNodeOperation) {
		memo.put(activityNode, activityNodeOperation);
	}
}
