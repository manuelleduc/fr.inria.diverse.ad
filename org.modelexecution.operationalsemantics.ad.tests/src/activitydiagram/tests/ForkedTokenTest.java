/**
 */
package activitydiagram.tests;

import activitydiagram.ActivitydiagramFactory;
import activitydiagram.ForkedToken;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Forked Token</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForkedTokenTest extends TokenTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ForkedTokenTest.class);
	}

	/**
	 * Constructs a new Forked Token test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkedTokenTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Forked Token test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ForkedToken getFixture() {
		return (ForkedToken)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ActivitydiagramFactory.eINSTANCE.createForkedToken());
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

} //ForkedTokenTest
