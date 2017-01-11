package fr.inria.diverse.ad.visitor2.visitor;

import activitydiagram.ControlToken;
import activitydiagram.ForkedToken;
import activitydiagram.visitor.ActivityDiagramVisitorDefault;

public class TokenIsWithdrawVisitor extends ActivityDiagramVisitorDefault<Boolean> {

	@Override
	public Boolean visitControlToken(ControlToken controlToken) {
		return controlToken.getHolder() == null;
	}

	@Override
	public Boolean visitForkedToken(ForkedToken forkedToken) {
		return forkedToken.getHolder() == null;
	}
	
	

}
