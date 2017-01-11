/**
 */
package activitydiagram.impl;

import activitydiagram.ActivitydiagramPackage;
import activitydiagram.IntegerVariable;
import activitydiagram.visitor.ActivityDiagramVisitor;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class IntegerVariableImpl extends VariableImpl implements IntegerVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitydiagramPackage.Literals.INTEGER_VARIABLE;
	}
	
	/**
	 * @generated NOT
	 */
	public <T> T accept(ActivityDiagramVisitor<T> visitor) {
		return visitor.visitIntegerVariable(this);
	}

} //IntegerVariableImpl
