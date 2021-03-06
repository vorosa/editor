package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.CreateEventToInstance_c.java
//
// WARNING: Do not edit this generated file
// Generated by ../MC-Java/java.arc, $Revision: 1.111 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//====================================================================

// No special imports
import java.util.*;
import java.lang.reflect.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import com.mentor.nucleus.bp.core.util.PersistenceUtil;
import org.eclipse.core.runtime.NullProgressMonitor;
import com.mentor.nucleus.bp.core.ui.marker.UmlProblem;
import com.mentor.nucleus.bp.core.common.*;
abstract class EV_CREATE_EVENT_TO_INSTANCE extends genericEvent_c {
	public abstract int getEvtcode();
}

public class CreateEventToInstance_c extends NonRootModelElement
		implements
			IAdaptable,
			Cloneable {
	// Public Constructors
	public CreateEventToInstance_c(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, java.util.UUID p_m_var_id) {
		super(modelRoot);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_statement_id = IdAssigner.preprocessUUID(p_m_statement_id);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_var_id = IdAssigner.preprocessUUID(p_m_var_id);

		Object[] key = {m_statement_id};
		addInstanceToMap(key);
	}
	static public CreateEventToInstance_c createProxy(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, java.util.UUID p_m_var_id,
			String p_contentPath, IPath p_localPath) {
		ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot,
				p_contentPath, p_localPath);
		// if a model root was not resolved it is most likely
		// due to a missing file of the proxy, defualt back to
		// the original model root
		if (resolvedModelRoot != null)
			modelRoot = resolvedModelRoot;
		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);
		CreateEventToInstance_c new_inst = null;
		synchronized (instances) {
			Object[] key = {p_m_statement_id};
			new_inst = (CreateEventToInstance_c) instances.get(key);
		}
		String contentPath = PersistenceUtil.resolveRelativePath(p_localPath,
				new Path(p_contentPath));
		if (modelRoot.isNewCompareRoot()) {
			// for comparisons we do not want to change
			// the content path
			contentPath = p_contentPath;
		}
		if (new_inst != null && !modelRoot.isCompareRoot()) {
			PersistableModelComponent pmc = new_inst.getPersistableComponent();
			if (pmc == null) {
				// dangling reference, redo this instance
				new_inst.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_statement_id = IdAssigner
						.preprocessUUID(p_m_statement_id);
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_var_id = IdAssigner.preprocessUUID(p_m_var_id);

			}
		}
		if (new_inst == null) {
			// there is no instance matching the id, create a proxy
			// if the resource doesn't exist then this will be a dangling reference
			new_inst = new CreateEventToInstance_c(modelRoot, p_m_statement_id,
					p_m_var_id);
			new_inst.m_contentPath = contentPath;
		}
		return new_inst;
	}

	static public CreateEventToInstance_c resolveInstance(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, java.util.UUID p_m_var_id) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);
		CreateEventToInstance_c source = null;
		synchronized (instances) {
			Object[] key = {p_m_statement_id};
			source = (CreateEventToInstance_c) instances.get(key);
			if (source != null && !modelRoot.isCompareRoot()) {
				source.convertFromProxy();
				source.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_statement_id = IdAssigner
						.preprocessUUID(p_m_statement_id);
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_var_id = IdAssigner.preprocessUUID(p_m_var_id);

				return source;
			}
		}
		// there is no instance matching the id
		CreateEventToInstance_c new_inst = new CreateEventToInstance_c(
				modelRoot, p_m_statement_id, p_m_var_id);
		return new_inst;
	}
	public CreateEventToInstance_c(ModelRoot modelRoot) {
		super(modelRoot);
		m_statement_id = IdAssigner.NULL_UUID;
		m_var_id = IdAssigner.NULL_UUID;
		Object[] key = {m_statement_id};
		addInstanceToMap(key);
	}

	public Object getInstanceKey() {
		Object[] key = {m_statement_id};
		return key;
	}

	public boolean setInstanceKey(UUID p_newKey) {

		boolean changed = false;
		// round p1
		// round p2
		// round p3
		// round p4
		// round p5
		if (m_statement_id != p_newKey) {

			m_statement_id = p_newKey;
			changed = true;
		}
		return changed;
	}

	public boolean equals(Object elem) {
		if (!(elem instanceof CreateEventToInstance_c)) {
			return false;
		}
		// check that the model-roots are the same
		if (((NonRootModelElement) elem).getModelRoot() != getModelRoot()) {
			return false;
		}

		return identityEquals(elem);
	}

	public boolean identityEquals(Object elem) {
		if (!(elem instanceof CreateEventToInstance_c)) {
			return false;
		}

		CreateEventToInstance_c me = (CreateEventToInstance_c) elem;
		// don't allow an empty id-value to produce a false positive result;
		// in this case, use whether the two instances are actually the same 
		// one in memory, instead
		if ((IdAssigner.NULL_UUID.equals(getStatement_id()) || IdAssigner.NULL_UUID
				.equals(((CreateEventToInstance_c) elem).getStatement_id()))
				&& this != elem) {
			return false;
		}
		if (!getStatement_id().equals(
				((CreateEventToInstance_c) elem).getStatement_id()))
			return false;
		return true;
	}

	public boolean cachedIdentityEquals(Object elem) {
		if (!(elem instanceof CreateEventToInstance_c)) {
			return false;
		}

		CreateEventToInstance_c me = (CreateEventToInstance_c) elem;
		if (!getStatement_idCachedValue().equals(
				((CreateEventToInstance_c) elem).getStatement_idCachedValue()))
			return false;
		return true;
	}

	// Attributes
	private java.util.UUID m_statement_id;
	private java.util.UUID m_var_id;

	// declare association references from this class

	// referring navigation

	CreateSmEventStatement_c IsSupertypeCreateSmEventStatement;
	public void relateAcrossR704To(CreateSmEventStatement_c target) {
		relateAcrossR704To(target, true);
	}
	public void relateAcrossR704To(CreateSmEventStatement_c target,
			boolean notifyChanges) {
		if (target == null)
			return;

		if (target == IsSupertypeCreateSmEventStatement)
			return; // already related

		if (IsSupertypeCreateSmEventStatement != target) {

			Object oldKey = getInstanceKey();

			if (IsSupertypeCreateSmEventStatement != null) {

				IsSupertypeCreateSmEventStatement.clearBackPointerR704To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"CreateEventToInstance_c.relateAcrossR704To(CreateSmEventStatement_c target)",
									"Relate performed across R704 from Create Event to Instance to Create SM Event Statement without unrelate of prior instance.");
				}
			}

			IsSupertypeCreateSmEventStatement = target;
			if (IdAssigner.NULL_UUID.equals(target.getStatement_id())) {
				// do not update cached value
			} else {
				// update cached value
				m_statement_id = target.getStatement_idCachedValue();
			}
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR704To(this);
			target.addRef();
		}
	}
	public void unrelateAcrossR704From(CreateSmEventStatement_c target) {
		unrelateAcrossR704From(target, true);
	}
	public void unrelateAcrossR704From(CreateSmEventStatement_c target,
			boolean notifyChanges) {
		if (target == null)
			return;

		if (IsSupertypeCreateSmEventStatement == null)
			return; // already unrelated

		if (target != IsSupertypeCreateSmEventStatement) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R704",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR704To(this);
		}

		if (IsSupertypeCreateSmEventStatement != null) {

			m_statement_id = IsSupertypeCreateSmEventStatement
					.getStatement_id();
			if (IdAssigner.NULL_UUID.equals(m_statement_id)) {
				m_statement_id = IsSupertypeCreateSmEventStatement
						.getStatement_idCachedValue();
			}
			IsSupertypeCreateSmEventStatement = null;
			target.removeRef();
		}
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			CreateSmEventStatement_c[] targets) {
		return getOneE_CEIOnR704(targets, null);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			CreateSmEventStatement_c[] targets, ClassQueryInterface_c test) {
		CreateEventToInstance_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneE_CEIOnR704(targets[i], test);
			}
		}

		return ret_val;
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			CreateSmEventStatement_c target) {
		return getOneE_CEIOnR704(target, null);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			CreateSmEventStatement_c target, boolean loadComponent) {
		return getOneE_CEIOnR704(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			CreateSmEventStatement_c target, ClassQueryInterface_c test) {
		if (target != null) {
			return getOneE_CEIOnR704(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			ModelRoot modelRoot, CreateSmEventStatement_c target,
			ClassQueryInterface_c test) {
		return getOneE_CEIOnR704(modelRoot, target, test, true);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR704(
			ModelRoot modelRoot, CreateSmEventStatement_c target,
			ClassQueryInterface_c test, boolean loadComponent) {
		return find_getOneE_CEIOnR704(modelRoot, target, test);
	}
	private static CreateEventToInstance_c find_getOneE_CEIOnR704(
			ModelRoot modelRoot, CreateSmEventStatement_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			CreateEventToInstance_c source = (CreateEventToInstance_c) target.backPointer_IsSubtypeCreateEventToInstanceIsSubtype_R704;
			if (source != null && (test == null || test.evaluate(source))) {
				return source;
			}
		}
		// not found
		return null;
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR704(
			CreateSmEventStatement_c[] targets) {
		return getManyE_CEIsOnR704(targets, null);
	}
	public static CreateEventToInstance_c[] getManyE_CEIsOnR704(
			CreateSmEventStatement_c[] targets, boolean loadComponent) {
		return getManyE_CEIsOnR704(targets, null, loadComponent);
	}
	public static CreateEventToInstance_c[] getManyE_CEIsOnR704(
			CreateSmEventStatement_c[] targets, ClassQueryInterface_c test) {
		return getManyE_CEIsOnR704(targets, test, true);
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR704(
			CreateSmEventStatement_c[] targets, ClassQueryInterface_c test,
			boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new CreateEventToInstance_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			CreateEventToInstance_c source = (CreateEventToInstance_c) targets[i].backPointer_IsSubtypeCreateEventToInstanceIsSubtype_R704;
			if (source != null && (test == null || test.evaluate(source))) {
				matches.add(source);
			}
		}
		if (matches.size() > 0) {
			CreateEventToInstance_c[] ret_set = new CreateEventToInstance_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new CreateEventToInstance_c[0];
		}
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR704(
			CreateSmEventStatement_c target) {
		if (target != null) {
			CreateSmEventStatement_c[] targetArray = new CreateSmEventStatement_c[1];
			targetArray[0] = target;
			return getManyE_CEIsOnR704(targetArray);
		} else {
			CreateEventToInstance_c[] result = new CreateEventToInstance_c[0];
			return result;
		}
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR704(
			CreateSmEventStatement_c target, boolean loadComponent) {
		if (target != null) {
			CreateSmEventStatement_c[] targetArray = new CreateSmEventStatement_c[1];
			targetArray[0] = target;
			return getManyE_CEIsOnR704(targetArray, loadComponent);
		} else {
			CreateEventToInstance_c[] result = new CreateEventToInstance_c[0];
			return result;
		}
	}

	// referring navigation

	Variable_c HasRecipientVariable;
	public void relateAcrossR711To(Variable_c target) {
		relateAcrossR711To(target, true);
	}
	public void relateAcrossR711To(Variable_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == HasRecipientVariable)
			return; // already related

		if (HasRecipientVariable != target) {

			Object oldKey = getInstanceKey();

			if (HasRecipientVariable != null) {

				HasRecipientVariable.clearBackPointerR711To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"CreateEventToInstance_c.relateAcrossR711To(Variable_c target)",
									"Relate performed across R711 from Create Event to Instance to Variable without unrelate of prior instance.");
				}
			}

			HasRecipientVariable = target;
			m_var_id = target.getVar_id();
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR711To(this);
			target.addRef();
		}
	}
	public void unrelateAcrossR711From(Variable_c target) {
		unrelateAcrossR711From(target, true);
	}
	public void unrelateAcrossR711From(Variable_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (HasRecipientVariable == null)
			return; // already unrelated

		if (target != HasRecipientVariable) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R711",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR711To(this);
		}

		if (HasRecipientVariable != null) {

			m_var_id = HasRecipientVariable.getVar_id();
			HasRecipientVariable = null;
			target.removeRef();
		}
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(Variable_c[] targets) {
		return getOneE_CEIOnR711(targets, null);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(
			Variable_c[] targets, ClassQueryInterface_c test) {
		CreateEventToInstance_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneE_CEIOnR711(targets[i], test);
			}
		}

		return ret_val;
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(Variable_c target) {
		return getOneE_CEIOnR711(target, null);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(Variable_c target,
			boolean loadComponent) {
		return getOneE_CEIOnR711(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(Variable_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneE_CEIOnR711(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(
			ModelRoot modelRoot, Variable_c target, ClassQueryInterface_c test) {
		return getOneE_CEIOnR711(modelRoot, target, test, true);
	}

	public static CreateEventToInstance_c getOneE_CEIOnR711(
			ModelRoot modelRoot, Variable_c target, ClassQueryInterface_c test,
			boolean loadComponent) {
		return find_getOneE_CEIOnR711(modelRoot, target, test);
	}
	private static CreateEventToInstance_c find_getOneE_CEIOnR711(
			ModelRoot modelRoot, Variable_c target, ClassQueryInterface_c test) {
		if (target != null) {
			synchronized (target.backPointer_CreateEventToInstance_R711) {
				for (int i = 0; i < target.backPointer_CreateEventToInstance_R711
						.size(); ++i) {
					CreateEventToInstance_c source = (CreateEventToInstance_c) target.backPointer_CreateEventToInstance_R711
							.get(i);
					if (source != null
							&& (test == null || test.evaluate(source))) {
						return source;
					}
				}
			}
		}
		// not found
		return null;
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c[] targets) {
		return getManyE_CEIsOnR711(targets, null);
	}
	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c[] targets, boolean loadComponent) {
		return getManyE_CEIsOnR711(targets, null, loadComponent);
	}
	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c[] targets, ClassQueryInterface_c test) {
		return getManyE_CEIsOnR711(targets, test, true);
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c[] targets, ClassQueryInterface_c test,
			boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new CreateEventToInstance_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			synchronized (targets[i].backPointer_CreateEventToInstance_R711) {
				for (int j = 0; j < targets[i].backPointer_CreateEventToInstance_R711
						.size(); ++j) {
					CreateEventToInstance_c source = (CreateEventToInstance_c) targets[i].backPointer_CreateEventToInstance_R711
							.get(j);
					if (source != null
							&& (test == null || test.evaluate(source))) {
						matches.add(source);
					}
				}
			}
		}
		if (matches.size() > 0) {
			CreateEventToInstance_c[] ret_set = new CreateEventToInstance_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new CreateEventToInstance_c[0];
		}
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c target) {
		return getManyE_CEIsOnR711(target, null);
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c target, boolean loadComponent) {
		return getManyE_CEIsOnR711(target, null, loadComponent);
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c target, ClassQueryInterface_c test) {
		return getManyE_CEIsOnR711(target, test, true);
	}

	public static CreateEventToInstance_c[] getManyE_CEIsOnR711(
			Variable_c target, ClassQueryInterface_c test, boolean loadComponent) {
		if (target == null)
			return new CreateEventToInstance_c[0];

		ModelRoot modelRoot = target.getModelRoot();
		Vector matches = new Vector();
		synchronized (target.backPointer_CreateEventToInstance_R711) {
			for (int i = 0; i < target.backPointer_CreateEventToInstance_R711
					.size(); ++i) {
				CreateEventToInstance_c source = (CreateEventToInstance_c) target.backPointer_CreateEventToInstance_R711
						.get(i);
				if (source != null && (test == null || test.evaluate(source))) {

					matches.add(source);
				}
			}
		}

		if (matches.size() > 0) {
			CreateEventToInstance_c[] ret_set = new CreateEventToInstance_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new CreateEventToInstance_c[0];
		}
	}

	public void batchRelate(ModelRoot modelRoot, boolean notifyChanges,
			boolean searchAllRoots) {
		batchRelate(modelRoot, false, notifyChanges, searchAllRoots);
	}

	public void batchRelate(ModelRoot modelRoot, boolean relateProxies,
			boolean notifyChanges, boolean searchAllRoots) {
		InstanceList instances = null;
		ModelRoot baseRoot = modelRoot;

		// R704
		CreateSmEventStatement_c relInst54587 = (CreateSmEventStatement_c) baseRoot
				.getInstanceList(CreateSmEventStatement_c.class).get(
						new Object[]{m_statement_id});
		// if there was no local element, check for any global elements
		// failing that proceed to check other model roots
		if (relInst54587 == null) {
			relInst54587 = (CreateSmEventStatement_c) Ooaofooa
					.getDefaultInstance()
					.getInstanceList(CreateSmEventStatement_c.class)
					.get(new Object[]{m_statement_id});
		}
		if (relInst54587 == null && searchAllRoots && !baseRoot.isCompareRoot()) {
			Ooaofooa[] roots = Ooaofooa.getInstances();
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].isCompareRoot()) {
					// never use elements from any compare root
					continue;
				}
				relInst54587 = (CreateSmEventStatement_c) roots[i]
						.getInstanceList(CreateSmEventStatement_c.class).get(
								new Object[]{m_statement_id});
				if (relInst54587 != null)
					break;
			}
		}
		//synchronized
		if (relInst54587 != null) {
			if (relateProxies || !isProxy()
					|| (inSameComponent(this, relInst54587) && !isProxy())) {
				relInst54587.relateAcrossR704To(this, notifyChanges);
			}
		}

		if (HasRecipientVariable == null) {
			// R711
			Variable_c relInst54588 = (Variable_c) baseRoot.getInstanceList(
					Variable_c.class).get(new Object[]{m_var_id});
			// if there was no local element, check for any global elements
			// failing that proceed to check other model roots
			if (relInst54588 == null) {
				relInst54588 = (Variable_c) Ooaofooa.getDefaultInstance()
						.getInstanceList(Variable_c.class)
						.get(new Object[]{m_var_id});
			}
			if (relInst54588 == null && searchAllRoots
					&& !baseRoot.isCompareRoot()) {
				Ooaofooa[] roots = Ooaofooa.getInstances();
				for (int i = 0; i < roots.length; i++) {
					if (roots[i].isCompareRoot()) {
						// never use elements from any compare root
						continue;
					}
					relInst54588 = (Variable_c) roots[i].getInstanceList(
							Variable_c.class).get(new Object[]{m_var_id});
					if (relInst54588 != null)
						break;
				}
			}
			//synchronized
			if (relInst54588 != null) {
				if (relateProxies || !isProxy()
						|| (inSameComponent(this, relInst54588) && !isProxy())) {
					relInst54588.relateAcrossR711To(this, notifyChanges);
				}
			}
		}

	}
	public void batchUnrelate(boolean notifyChanges) {
		NonRootModelElement inst = null;
		// R704
		// E_CSME
		inst = IsSupertypeCreateSmEventStatement;
		unrelateAcrossR704From(IsSupertypeCreateSmEventStatement, notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
		// R711
		// V_VAR
		inst = HasRecipientVariable;
		unrelateAcrossR711From(HasRecipientVariable, notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
	}
	public static void batchRelateAll(ModelRoot modelRoot,
			boolean notifyChanges, boolean searchAllRoots) {
		batchRelateAll(modelRoot, notifyChanges, searchAllRoots, false);
	}
	public static void batchRelateAll(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots, boolean relateProxies)
  {
	InstanceList instances = modelRoot.getInstanceList(CreateEventToInstance_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final CreateEventToInstance_c inst = (CreateEventToInstance_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }
	public static void clearInstances(ModelRoot modelRoot) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);
		synchronized (instances) {
			for (int i = instances.size() - 1; i >= 0; i--) {
				((NonRootModelElement) instances.get(i)).delete_unchecked();
			}

		}
	}

	public static CreateEventToInstance_c CreateEventToInstanceInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		CreateEventToInstance_c result = findCreateEventToInstanceInstance(
				modelRoot, test, loadComponent);
		return result;
	}
	private static CreateEventToInstance_c findCreateEventToInstanceInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				CreateEventToInstance_c x = (CreateEventToInstance_c) instances
						.get(i);
				if (test == null || test.evaluate(x)) {
					return x;
				}
			}
		}
		return null;
	}
	public static CreateEventToInstance_c CreateEventToInstanceInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return CreateEventToInstanceInstance(modelRoot, test, true);
	}

	public static CreateEventToInstance_c CreateEventToInstanceInstance(
			ModelRoot modelRoot) {
		return CreateEventToInstanceInstance(modelRoot, null, true);
	}

	public static CreateEventToInstance_c[] CreateEventToInstanceInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateEventToInstance_c.class);
		Vector matches = new Vector();
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				CreateEventToInstance_c x = (CreateEventToInstance_c) instances
						.get(i);
				if (test == null || test.evaluate(x)) {
					matches.add(x);
				}
			}
			if (matches.size() > 0) {
				CreateEventToInstance_c[] ret_set = new CreateEventToInstance_c[matches
						.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new CreateEventToInstance_c[0];
			}
		}
	}
	public static CreateEventToInstance_c[] CreateEventToInstanceInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return CreateEventToInstanceInstances(modelRoot, test, true);
	}
	public static CreateEventToInstance_c[] CreateEventToInstanceInstances(
			ModelRoot modelRoot) {
		return CreateEventToInstanceInstances(modelRoot, null, true);
	}

	public boolean delete() {
		boolean result = super.delete();
		boolean delete_error = false;
		String errorMsg = "The following relationships were not torn down by the Create Event to Instance.dispose call: ";
		CreateSmEventStatement_c testR704Inst1 = CreateSmEventStatement_c
				.getOneE_CSMEOnR704(this, false);

		if (testR704Inst1 != null) {
			delete_error = true;
			errorMsg = errorMsg + "704 ";
		}
		Variable_c testR711Inst = Variable_c.getOneV_VAROnR711(this, false);

		if (testR711Inst != null) {
			delete_error = true;
			errorMsg = errorMsg + "711 ";
		}
		if (delete_error == true) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.DELETE,
						"Create Event to Instance", errorMsg);
			} else {
				Exception e = new Exception();
				e.fillInStackTrace();
				CorePlugin.logError(errorMsg, e);
			}
		}
		return result;
	}

	// end declare instance pool

	// declare attribute accessors
	public boolean isUUID(String attributeName) {
		if (attributeName.equals("statement_id")) {
			return true;
		}
		if (attributeName.equals("var_id")) {
			return true;
		}
		return false;
	}
	// declare attribute accessors
	public long getStatement_idLongBased() {
		if (IsSupertypeCreateSmEventStatement != null) {
			return IsSupertypeCreateSmEventStatement.getStatement_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getStatement_id() {
		if (IsSupertypeCreateSmEventStatement != null) {
			return IsSupertypeCreateSmEventStatement.getStatement_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public boolean hasSuperType() {
		return (IsSupertypeCreateSmEventStatement != null);

	}

	public java.util.UUID getStatement_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_statement_id))
			return m_statement_id;
		else
			return getStatement_id();
	}

	public void setStatement_id(java.util.UUID newValue) {
		m_statement_id = IdAssigner.preprocessUUID(newValue);
	}
	public long getVar_idLongBased() {
		if (HasRecipientVariable != null) {
			return HasRecipientVariable.getVar_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getVar_id() {
		if (HasRecipientVariable != null) {
			return HasRecipientVariable.getVar_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public java.util.UUID getVar_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_var_id))
			return m_var_id;
		else
			return getVar_id();
	}

	public void setVar_id(java.util.UUID newValue) {
		m_var_id = IdAssigner.preprocessUUID(newValue);
	}
	// end declare accessors
	public static void checkClassConsistency(ModelRoot modelRoot) {
		Ooaofooa.log
				.println(ILogger.OPERATION, "Create Event to Instance", //$NON-NLS-1$
						" Operation entered: Create Event to Instance::checkClassConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return;
		}
		CreateEventToInstance_c[] objs = CreateEventToInstance_c
				.CreateEventToInstanceInstances(modelRoot, null, false);

		for (int i = 0; i < objs.length; i++) {
			objs[i].checkConsistency();
		}
	}
	public boolean checkConsistency() {
		Ooaofooa.log
				.println(ILogger.OPERATION, "Create Event to Instance", //$NON-NLS-1$
						" Operation entered: Create Event to Instance::checkConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return true;
		}
		ModelRoot modelRoot = getModelRoot();
		boolean retval = true;
		class CreateEventToInstance_c_test54590_c
				implements
					ClassQueryInterface_c {
			CreateEventToInstance_c_test54590_c(java.util.UUID p54591) {
				m_p54591 = p54591;
			}
			private java.util.UUID m_p54591;
			public boolean evaluate(Object candidate) {
				CreateEventToInstance_c selected = (CreateEventToInstance_c) candidate;
				boolean retval = false;
				retval = (selected.getStatement_id().equals(m_p54591));
				return retval;
			}
		}

		CreateEventToInstance_c[] objs54589 = CreateEventToInstance_c
				.CreateEventToInstanceInstances(modelRoot,
						new CreateEventToInstance_c_test54590_c(
								getStatement_id()));

		if (((objs54589.length) == 0)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(
								ILogger.CONSISTENCY,
								"Create Event to Instance", //$NON-NLS-1$
								"Consistency: Object: Create Event to Instance: Cardinality of an identifier is zero. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs54589.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create Event to Instance: Cardinality of an identifier is zero. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs54589.length), e);
			}
			retval = false;

		}

		if (((objs54589.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(
								ILogger.CONSISTENCY,
								"Create Event to Instance", //$NON-NLS-1$
								"Consistency: Object: Create Event to Instance: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs54589.length)
										+ " Statement_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create Event to Instance: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs54589.length)
										+ " Statement_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		// Create Event to Instance is a subtype in association: rel.Numb = 704
		// The supertype class is: Create SM Event Statement
		class CreateSmEventStatement_c_test54595_c
				implements
					ClassQueryInterface_c {
			CreateSmEventStatement_c_test54595_c(java.util.UUID p54596) {
				m_p54596 = p54596;
			}
			private java.util.UUID m_p54596;
			public boolean evaluate(Object candidate) {
				CreateSmEventStatement_c selected = (CreateSmEventStatement_c) candidate;
				boolean retval = false;
				retval = (selected.getStatement_id().equals(m_p54596));
				return retval;
			}
		}

		CreateSmEventStatement_c[] objs54594 = CreateSmEventStatement_c
				.CreateSmEventStatementInstances(modelRoot,
						new CreateSmEventStatement_c_test54595_c(
								getStatement_id()));

		if (((objs54594.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(
								ILogger.CONSISTENCY,
								"Create Event to Instance", //$NON-NLS-1$
								"Consistency: Object: Create Event to Instance: Association: 704: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs54594.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create Event to Instance: Association: 704: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs54594.length), e);
			}
			retval = false;

		}

		// Create Event to Instance is a referring class in association: rel.Numb = 711
		// The participating class is: Variable
		class Variable_c_test54598_c implements ClassQueryInterface_c {
			Variable_c_test54598_c(java.util.UUID p54599) {
				m_p54599 = p54599;
			}
			private java.util.UUID m_p54599;
			public boolean evaluate(Object candidate) {
				Variable_c selected = (Variable_c) candidate;
				boolean retval = false;
				retval = (selected.getVar_id().equals(m_p54599));
				return retval;
			}
		}

		Variable_c[] objs54597 = Variable_c.VariableInstances(modelRoot,
				new Variable_c_test54598_c(getVar_id()));

		// The participant is unconditional
		// The multiplicity of the participant is one
		if (((objs54597.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(
								ILogger.CONSISTENCY,
								"Create Event to Instance", //$NON-NLS-1$
								"Consistency: Object: Create Event to Instance: Association: 711: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs54597.length)
										+ " Var_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create Event to Instance: Association: 711: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs54597.length)
										+ " Var_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		return retval;
	}

	// declare transform functions
	public void Dispose() {
		Ooaofooa.log.println(ILogger.OPERATION, "Create Event to Instance",
				" Operation entered: CreateEventToInstance::Dispose");
		final ModelRoot modelRoot = getModelRoot();
		Variable_c v_var = Variable_c.getOneV_VAROnR711(this);

		if ((!(v_var == null))) {

			this.unrelateAcrossR711From(v_var);

		}

		delete();

	} // End dispose
	public void Execute(final java.util.UUID p_Stack_frame_id) {
		Ooaofooa.log.println(ILogger.OPERATION, "Create Event to Instance",
				" Operation entered: CreateEventToInstance::Execute");
		final ModelRoot modelRoot = getModelRoot();

	} // End execute

	// end transform functions

	public Object getAdapter(Class adapter) {
		Object superAdapter = super.getAdapter(adapter);
		if (superAdapter != null) {
			return superAdapter;
		}
		return null;
	}
} // end Create Event to Instance
