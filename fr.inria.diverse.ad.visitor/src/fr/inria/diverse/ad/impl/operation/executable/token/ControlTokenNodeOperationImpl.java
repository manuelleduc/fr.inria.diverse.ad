package fr.inria.diverse.ad.impl.operation.executable.token;

import activitydiagram.ControlToken;

public class ControlTokenNodeOperationImpl extends TokenNodeOperationImpl {
	final ControlToken controlToken;

	public ControlTokenNodeOperationImpl(final ControlToken controlToken) {
		super(controlToken);
		this.controlToken = controlToken;
	}
}