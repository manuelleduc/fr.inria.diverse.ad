package fr.inria.diverse.ad.visitor.visitor;

import activitydiagram.BooleanBinaryExpression;
import activitydiagram.BooleanUnaryExpression;
import activitydiagram.IntegerCalculationExpression;
import activitydiagram.IntegerComparisonExpression;
import activitydiagram.util.ActivitydiagramSwitch;
import fr.inria.diverse.ad.visitor.impl.operation.executable.expressionoperation.BooleanBinaryExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.visitor.impl.operation.executable.expressionoperation.BooleanUnaryExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.visitor.impl.operation.executable.expressionoperation.IntegerCalculationExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.visitor.impl.operation.executable.expressionoperation.IntegerComparisonExpressionExpressionOperationImpl;
import fr.inria.diverse.ad.visitor.operation.ExpressionOperation;

public class ExpressionVisitor extends ActivitydiagramSwitch<ExpressionOperation> {

	@Override
	public ExpressionOperation caseBooleanBinaryExpression(BooleanBinaryExpression object) {
		return new BooleanBinaryExpressionExpressionOperationImpl(object);
	}

	@Override
	public ExpressionOperation caseBooleanUnaryExpression(BooleanUnaryExpression object) {
		return new BooleanUnaryExpressionExpressionOperationImpl(object);
	}

	@Override
	public ExpressionOperation caseIntegerCalculationExpression(IntegerCalculationExpression object) {
		return new IntegerCalculationExpressionExpressionOperationImpl(object);
	}

	@Override
	public ExpressionOperation caseIntegerComparisonExpression(IntegerComparisonExpression object) {
		return new IntegerComparisonExpressionExpressionOperationImpl(object);
	}

}
