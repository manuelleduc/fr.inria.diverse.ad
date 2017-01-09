package fr.inria.diverse.ad.visitor.visitor;

import activitydiagram.ControlToken;
import activitydiagram.ForkedToken;
import activitydiagram.util.ActivitydiagramSwitch;
import fr.inria.diverse.ad.visitor.impl.operation.executable.token.ControlTokenNodeOperationImpl;
import fr.inria.diverse.ad.visitor.impl.operation.executable.token.ForkedTokenNodeOperationImpl;
import fr.inria.diverse.ad.visitor.operation.TokenOperation;

public class TokenVisitor extends ActivitydiagramSwitch<TokenOperation>{

	@Override
	public TokenOperation caseControlToken(ControlToken object) {
		return new ControlTokenNodeOperationImpl(object);
	}

	@Override
	public TokenOperation caseForkedToken(ForkedToken object) {
		return new ForkedTokenNodeOperationImpl(object);
	}

	
	
}
