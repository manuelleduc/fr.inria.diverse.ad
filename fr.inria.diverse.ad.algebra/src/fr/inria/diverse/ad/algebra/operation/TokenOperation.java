package fr.inria.diverse.ad.algebra.operation;

import activitydiagram.ActivityNode;
import activitydiagram.Token;

public interface TokenOperation {

	void withdraw();

	Token transfer(ActivityNode activityNode);

	boolean isWithdrawn();

}
