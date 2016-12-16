package fr.inria.diverse.ad.algebra.operation;

import java.util.List;

import activitydiagram.InputValue;

public interface ActivityOperation {
	void execute(List<InputValue> inputValues);

	void terminate();
}
