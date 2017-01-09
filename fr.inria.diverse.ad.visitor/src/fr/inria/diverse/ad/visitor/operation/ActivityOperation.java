package fr.inria.diverse.ad.visitor.operation;

import java.util.List;

import activitydiagram.InputValue;

public interface ActivityOperation {
	void main(List<InputValue> inputValues);

	void terminate();

}
