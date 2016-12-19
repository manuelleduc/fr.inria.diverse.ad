/**
 */
package activitydiagram.impl;

import activitydiagram.Activity;
import activitydiagram.ActivityEdge;
import activitydiagram.ActivityNode;
import activitydiagram.ActivitydiagramPackage;
import activitydiagram.Trace;
import activitydiagram.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link activitydiagram.impl.ActivityImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link activitydiagram.impl.ActivityImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link activitydiagram.impl.ActivityImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link activitydiagram.impl.ActivityImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link activitydiagram.impl.ActivityImpl#getTrace <em>Trace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityImpl extends NamedElementImpl implements Activity {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityNode> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityEdge> edges;

	/**
	 * The cached value of the '{@link #getLocals() <em>Locals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> locals;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> inputs;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected Trace trace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitydiagramPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<ActivityNode>(ActivityNode.class, this, ActivitydiagramPackage.ACTIVITY__NODES, ActivitydiagramPackage.ACTIVITY_NODE__ACTIVITY);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<ActivityEdge>(ActivityEdge.class, this, ActivitydiagramPackage.ACTIVITY__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getLocals() {
		if (locals == null) {
			locals = new EObjectContainmentEList<Variable>(Variable.class, this, ActivitydiagramPackage.ACTIVITY__LOCALS);
		}
		return locals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<Variable>(Variable.class, this, ActivitydiagramPackage.ACTIVITY__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace getTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrace(Trace newTrace, NotificationChain msgs) {
		Trace oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivitydiagramPackage.ACTIVITY__TRACE, oldTrace, newTrace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(Trace newTrace) {
		if (newTrace != trace) {
			NotificationChain msgs = null;
			if (trace != null)
				msgs = ((InternalEObject)trace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActivitydiagramPackage.ACTIVITY__TRACE, null, msgs);
			if (newTrace != null)
				msgs = ((InternalEObject)newTrace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActivitydiagramPackage.ACTIVITY__TRACE, null, msgs);
			msgs = basicSetTrace(newTrace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitydiagramPackage.ACTIVITY__TRACE, newTrace, newTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivitydiagramPackage.ACTIVITY__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivitydiagramPackage.ACTIVITY__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case ActivitydiagramPackage.ACTIVITY__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
			case ActivitydiagramPackage.ACTIVITY__LOCALS:
				return ((InternalEList<?>)getLocals()).basicRemove(otherEnd, msgs);
			case ActivitydiagramPackage.ACTIVITY__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ActivitydiagramPackage.ACTIVITY__TRACE:
				return basicSetTrace(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivitydiagramPackage.ACTIVITY__NODES:
				return getNodes();
			case ActivitydiagramPackage.ACTIVITY__EDGES:
				return getEdges();
			case ActivitydiagramPackage.ACTIVITY__LOCALS:
				return getLocals();
			case ActivitydiagramPackage.ACTIVITY__INPUTS:
				return getInputs();
			case ActivitydiagramPackage.ACTIVITY__TRACE:
				return getTrace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActivitydiagramPackage.ACTIVITY__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ActivityNode>)newValue);
				return;
			case ActivitydiagramPackage.ACTIVITY__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends ActivityEdge>)newValue);
				return;
			case ActivitydiagramPackage.ACTIVITY__LOCALS:
				getLocals().clear();
				getLocals().addAll((Collection<? extends Variable>)newValue);
				return;
			case ActivitydiagramPackage.ACTIVITY__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Variable>)newValue);
				return;
			case ActivitydiagramPackage.ACTIVITY__TRACE:
				setTrace((Trace)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActivitydiagramPackage.ACTIVITY__NODES:
				getNodes().clear();
				return;
			case ActivitydiagramPackage.ACTIVITY__EDGES:
				getEdges().clear();
				return;
			case ActivitydiagramPackage.ACTIVITY__LOCALS:
				getLocals().clear();
				return;
			case ActivitydiagramPackage.ACTIVITY__INPUTS:
				getInputs().clear();
				return;
			case ActivitydiagramPackage.ACTIVITY__TRACE:
				setTrace((Trace)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActivitydiagramPackage.ACTIVITY__NODES:
				return nodes != null && !nodes.isEmpty();
			case ActivitydiagramPackage.ACTIVITY__EDGES:
				return edges != null && !edges.isEmpty();
			case ActivitydiagramPackage.ACTIVITY__LOCALS:
				return locals != null && !locals.isEmpty();
			case ActivitydiagramPackage.ACTIVITY__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ActivitydiagramPackage.ACTIVITY__TRACE:
				return trace != null;
		}
		return super.eIsSet(featureID);
	}

} //ActivityImpl
