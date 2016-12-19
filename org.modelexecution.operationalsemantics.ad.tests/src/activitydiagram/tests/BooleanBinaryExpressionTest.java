/**
 */
package activitydiagram.tests;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.BooleanBinaryExpression;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Boolean Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BooleanBinaryExpressionTest extends BooleanExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BooleanBinaryExpressionTest.class);
	}

	/**
	 * Constructs a new Boolean Binary Expression test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanBinaryExpressionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Boolean Binary Expression test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BooleanBinaryExpression getFixture() {
		return (BooleanBinaryExpression)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ActivitydiagramFactory.eINSTANCE.createBooleanBinaryExpression());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //BooleanBinaryExpressionTest
