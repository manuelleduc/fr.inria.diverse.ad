package fr.inria.diverse.ad.visitor.operation;

import activitydiagram.ActivityNode;
import activitydiagram.Token;

public interface TokenOperation {

	void withdraw();

	Token transfer(ActivityNode activityNode);

	boolean isWithdrawn();

}
