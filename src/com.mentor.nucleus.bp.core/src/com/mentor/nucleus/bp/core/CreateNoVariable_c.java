package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.CreateNoVariable_c.java
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
abstract class EV_CREATE_NO_VARIABLE extends genericEvent_c {
	public abstract int getEvtcode();
}

public class CreateNoVariable_c extends NonRootModelElement
		implements
			IAdaptable,
			Cloneable {
	// Public Constructors
	public CreateNoVariable_c(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, java.util.UUID p_m_obj_id,
			int p_m_modelclasskeyletterslinenumber,
			int p_m_modelclasskeyletterscolumn) {
		super(modelRoot);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_statement_id = IdAssigner.preprocessUUID(p_m_statement_id);
		m_modelclasskeyletterslinenumber = p_m_modelclasskeyletterslinenumber;
		m_modelclasskeyletterscolumn = p_m_modelclasskeyletterscolumn;
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_obj_id = IdAssigner.preprocessUUID(p_m_obj_id);

		Object[] key = {m_statement_id};
		addInstanceToMap(key);
	}
	static public CreateNoVariable_c createProxy(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, java.util.UUID p_m_obj_id,
			int p_m_modelclasskeyletterslinenumber,
			int p_m_modelclasskeyletterscolumn, String p_contentPath,
			IPath p_localPath) {
		ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot,
				p_contentPath, p_localPath);
		// if a model root was not resolved it is most likely
		// due to a missing file of the proxy, defualt back to
		// the original model root
		if (resolvedModelRoot != null)
			modelRoot = resolvedModelRoot;
		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);
		CreateNoVariable_c new_inst = null;
		synchronized (instances) {
			Object[] key = {p_m_statement_id};
			new_inst = (CreateNoVariable_c) instances.get(key);
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
				new_inst.m_modelclasskeyletterslinenumber = p_m_modelclasskeyletterslinenumber;
				new_inst.m_modelclasskeyletterscolumn = p_m_modelclasskeyletterscolumn;
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_obj_id = IdAssigner.preprocessUUID(p_m_obj_id);

			}
		}
		if (new_inst == null) {
			// there is no instance matching the id, create a proxy
			// if the resource doesn't exist then this will be a dangling reference
			new_inst = new CreateNoVariable_c(modelRoot, p_m_statement_id,
					p_m_obj_id, p_m_modelclasskeyletterslinenumber,
					p_m_modelclasskeyletterscolumn);
			new_inst.m_contentPath = contentPath;
		}
		return new_inst;
	}

	static public CreateNoVariable_c resolveInstance(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, java.util.UUID p_m_obj_id,
			int p_m_modelclasskeyletterslinenumber,
			int p_m_modelclasskeyletterscolumn) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);
		CreateNoVariable_c source = null;
		synchronized (instances) {
			Object[] key = {p_m_statement_id};
			source = (CreateNoVariable_c) instances.get(key);
			if (source != null && !modelRoot.isCompareRoot()) {
				source.convertFromProxy();
				source.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_statement_id = IdAssigner
						.preprocessUUID(p_m_statement_id);
				source.m_modelclasskeyletterslinenumber = p_m_modelclasskeyletterslinenumber;
				source.m_modelclasskeyletterscolumn = p_m_modelclasskeyletterscolumn;
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_obj_id = IdAssigner.preprocessUUID(p_m_obj_id);

				return source;
			}
		}
		// there is no instance matching the id
		CreateNoVariable_c new_inst = new CreateNoVariable_c(modelRoot,
				p_m_statement_id, p_m_obj_id,
				p_m_modelclasskeyletterslinenumber,
				p_m_modelclasskeyletterscolumn);
		return new_inst;
	}
	public CreateNoVariable_c(ModelRoot modelRoot) {
		super(modelRoot);
		m_statement_id = IdAssigner.NULL_UUID;
		m_obj_id = IdAssigner.NULL_UUID;
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
		if (!(elem instanceof CreateNoVariable_c)) {
			return false;
		}
		// check that the model-roots are the same
		if (((NonRootModelElement) elem).getModelRoot() != getModelRoot()) {
			return false;
		}

		return identityEquals(elem);
	}

	public boolean identityEquals(Object elem) {
		if (!(elem instanceof CreateNoVariable_c)) {
			return false;
		}

		CreateNoVariable_c me = (CreateNoVariable_c) elem;
		// don't allow an empty id-value to produce a false positive result;
		// in this case, use whether the two instances are actually the same 
		// one in memory, instead
		if ((IdAssigner.NULL_UUID.equals(getStatement_id()) || IdAssigner.NULL_UUID
				.equals(((CreateNoVariable_c) elem).getStatement_id()))
				&& this != elem) {
			return false;
		}
		if (!getStatement_id().equals(
				((CreateNoVariable_c) elem).getStatement_id()))
			return false;
		return true;
	}

	public boolean cachedIdentityEquals(Object elem) {
		if (!(elem instanceof CreateNoVariable_c)) {
			return false;
		}

		CreateNoVariable_c me = (CreateNoVariable_c) elem;
		if (!getStatement_idCachedValue().equals(
				((CreateNoVariable_c) elem).getStatement_idCachedValue()))
			return false;
		return true;
	}

	// Attributes
	private java.util.UUID m_statement_id;
	private int m_modelclasskeyletterslinenumber;
	private int m_modelclasskeyletterscolumn;
	private java.util.UUID m_obj_id;

	// declare association references from this class

	// referring navigation

	ModelClass_c InstanceOfModelClass;
	public void relateAcrossR672To(ModelClass_c target) {
		relateAcrossR672To(target, true);
	}
	public void relateAcrossR672To(ModelClass_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == InstanceOfModelClass)
			return; // already related

		if (InstanceOfModelClass != target) {

			Object oldKey = getInstanceKey();

			if (InstanceOfModelClass != null) {

				InstanceOfModelClass.clearBackPointerR672To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"CreateNoVariable_c.relateAcrossR672To(ModelClass_c target)",
									"Relate performed across R672 from Create No Variable to Model Class without unrelate of prior instance.");
				}
			}

			InstanceOfModelClass = target;
			if (IdAssigner.NULL_UUID.equals(target.getObj_id())) {
				// do not update cached value
			} else {
				// update cached value
				m_obj_id = target.getObj_idCachedValue();
			}
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR672To(this);
			target.addRef();
		}
	}
	public void unrelateAcrossR672From(ModelClass_c target) {
		unrelateAcrossR672From(target, true);
	}
	public void unrelateAcrossR672From(ModelClass_c target,
			boolean notifyChanges) {
		if (target == null)
			return;

		if (InstanceOfModelClass == null)
			return; // already unrelated

		if (target != InstanceOfModelClass) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R672",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR672To(this);
		}

		if (InstanceOfModelClass != null) {

			m_obj_id = InstanceOfModelClass.getObj_id();
			if (IdAssigner.NULL_UUID.equals(m_obj_id)) {
				m_obj_id = InstanceOfModelClass.getObj_idCachedValue();
			}
			InstanceOfModelClass = null;
			target.removeRef();
		}
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(ModelClass_c[] targets) {
		return getOneACT_CNVOnR672(targets, null);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(
			ModelClass_c[] targets, ClassQueryInterface_c test) {
		CreateNoVariable_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneACT_CNVOnR672(targets[i], test);
			}
		}

		return ret_val;
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(ModelClass_c target) {
		return getOneACT_CNVOnR672(target, null);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(ModelClass_c target,
			boolean loadComponent) {
		return getOneACT_CNVOnR672(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(ModelClass_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneACT_CNVOnR672(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(ModelRoot modelRoot,
			ModelClass_c target, ClassQueryInterface_c test) {
		return getOneACT_CNVOnR672(modelRoot, target, test, true);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR672(ModelRoot modelRoot,
			ModelClass_c target, ClassQueryInterface_c test,
			boolean loadComponent) {
		return find_getOneACT_CNVOnR672(modelRoot, target, test);
	}
	private static CreateNoVariable_c find_getOneACT_CNVOnR672(
			ModelRoot modelRoot, ModelClass_c target, ClassQueryInterface_c test) {
		if (target != null) {
			synchronized (target.backPointer_CreateNoVariable_R672) {
				for (int i = 0; i < target.backPointer_CreateNoVariable_R672
						.size(); ++i) {
					CreateNoVariable_c source = (CreateNoVariable_c) target.backPointer_CreateNoVariable_R672
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

	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c[] targets) {
		return getManyACT_CNVsOnR672(targets, null);
	}
	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c[] targets, boolean loadComponent) {
		return getManyACT_CNVsOnR672(targets, null, loadComponent);
	}
	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c[] targets, ClassQueryInterface_c test) {
		return getManyACT_CNVsOnR672(targets, test, true);
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c[] targets, ClassQueryInterface_c test,
			boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new CreateNoVariable_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			synchronized (targets[i].backPointer_CreateNoVariable_R672) {
				for (int j = 0; j < targets[i].backPointer_CreateNoVariable_R672
						.size(); ++j) {
					CreateNoVariable_c source = (CreateNoVariable_c) targets[i].backPointer_CreateNoVariable_R672
							.get(j);
					if (source != null
							&& (test == null || test.evaluate(source))) {
						matches.add(source);
					}
				}
			}
		}
		if (matches.size() > 0) {
			CreateNoVariable_c[] ret_set = new CreateNoVariable_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new CreateNoVariable_c[0];
		}
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(ModelClass_c target) {
		return getManyACT_CNVsOnR672(target, null);
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c target, boolean loadComponent) {
		return getManyACT_CNVsOnR672(target, null, loadComponent);
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c target, ClassQueryInterface_c test) {
		return getManyACT_CNVsOnR672(target, test, true);
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR672(
			ModelClass_c target, ClassQueryInterface_c test,
			boolean loadComponent) {
		if (target == null)
			return new CreateNoVariable_c[0];

		ModelRoot modelRoot = target.getModelRoot();
		Vector matches = new Vector();
		synchronized (target.backPointer_CreateNoVariable_R672) {
			for (int i = 0; i < target.backPointer_CreateNoVariable_R672.size(); ++i) {
				CreateNoVariable_c source = (CreateNoVariable_c) target.backPointer_CreateNoVariable_R672
						.get(i);
				if (source != null && (test == null || test.evaluate(source))) {

					matches.add(source);
				}
			}
		}

		if (matches.size() > 0) {
			CreateNoVariable_c[] ret_set = new CreateNoVariable_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new CreateNoVariable_c[0];
		}
	}

	// referring navigation

	Statement_c IsSupertypeStatement;
	public void relateAcrossR603To(Statement_c target) {
		relateAcrossR603To(target, true);
	}
	public void relateAcrossR603To(Statement_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == IsSupertypeStatement)
			return; // already related

		if (IsSupertypeStatement != target) {

			Object oldKey = getInstanceKey();

			if (IsSupertypeStatement != null) {

				IsSupertypeStatement.clearBackPointerR603To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"CreateNoVariable_c.relateAcrossR603To(Statement_c target)",
									"Relate performed across R603 from Create No Variable to Statement without unrelate of prior instance.");
				}
			}

			IsSupertypeStatement = target;
			m_statement_id = target.getStatement_id();
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR603To(this);
			target.addRef();
		}
	}
	public void unrelateAcrossR603From(Statement_c target) {
		unrelateAcrossR603From(target, true);
	}
	public void unrelateAcrossR603From(Statement_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (IsSupertypeStatement == null)
			return; // already unrelated

		if (target != IsSupertypeStatement) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R603",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR603To(this);
		}

		if (IsSupertypeStatement != null) {

			m_statement_id = IsSupertypeStatement.getStatement_id();
			IsSupertypeStatement = null;
			target.removeRef();
		}
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(Statement_c[] targets) {
		return getOneACT_CNVOnR603(targets, null);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(Statement_c[] targets,
			ClassQueryInterface_c test) {
		CreateNoVariable_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneACT_CNVOnR603(targets[i], test);
			}
		}

		return ret_val;
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(Statement_c target) {
		return getOneACT_CNVOnR603(target, null);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(Statement_c target,
			boolean loadComponent) {
		return getOneACT_CNVOnR603(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(Statement_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneACT_CNVOnR603(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(ModelRoot modelRoot,
			Statement_c target, ClassQueryInterface_c test) {
		return getOneACT_CNVOnR603(modelRoot, target, test, true);
	}

	public static CreateNoVariable_c getOneACT_CNVOnR603(ModelRoot modelRoot,
			Statement_c target, ClassQueryInterface_c test,
			boolean loadComponent) {
		return find_getOneACT_CNVOnR603(modelRoot, target, test);
	}
	private static CreateNoVariable_c find_getOneACT_CNVOnR603(
			ModelRoot modelRoot, Statement_c target, ClassQueryInterface_c test) {
		if (target != null) {
			CreateNoVariable_c source = (CreateNoVariable_c) target.backPointer_IsSubtypeCreateNoVariableIsSubtype_R603;
			if (source != null && (test == null || test.evaluate(source))) {
				return source;
			}
		}
		// not found
		return null;
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR603(
			Statement_c[] targets) {
		return getManyACT_CNVsOnR603(targets, null);
	}
	public static CreateNoVariable_c[] getManyACT_CNVsOnR603(
			Statement_c[] targets, boolean loadComponent) {
		return getManyACT_CNVsOnR603(targets, null, loadComponent);
	}
	public static CreateNoVariable_c[] getManyACT_CNVsOnR603(
			Statement_c[] targets, ClassQueryInterface_c test) {
		return getManyACT_CNVsOnR603(targets, test, true);
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR603(
			Statement_c[] targets, ClassQueryInterface_c test,
			boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new CreateNoVariable_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			CreateNoVariable_c source = (CreateNoVariable_c) targets[i].backPointer_IsSubtypeCreateNoVariableIsSubtype_R603;
			if (source != null && (test == null || test.evaluate(source))) {
				matches.add(source);
			}
		}
		if (matches.size() > 0) {
			CreateNoVariable_c[] ret_set = new CreateNoVariable_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new CreateNoVariable_c[0];
		}
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR603(Statement_c target) {
		if (target != null) {
			Statement_c[] targetArray = new Statement_c[1];
			targetArray[0] = target;
			return getManyACT_CNVsOnR603(targetArray);
		} else {
			CreateNoVariable_c[] result = new CreateNoVariable_c[0];
			return result;
		}
	}

	public static CreateNoVariable_c[] getManyACT_CNVsOnR603(
			Statement_c target, boolean loadComponent) {
		if (target != null) {
			Statement_c[] targetArray = new Statement_c[1];
			targetArray[0] = target;
			return getManyACT_CNVsOnR603(targetArray, loadComponent);
		} else {
			CreateNoVariable_c[] result = new CreateNoVariable_c[0];
			return result;
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

		if (InstanceOfModelClass == null) {
			// R672
			ModelClass_c relInst40116 = (ModelClass_c) baseRoot
					.getInstanceList(ModelClass_c.class).get(
							new Object[]{m_obj_id});
			// if there was no local element, check for any global elements
			// failing that proceed to check other model roots
			if (relInst40116 == null) {
				relInst40116 = (ModelClass_c) Ooaofooa.getDefaultInstance()
						.getInstanceList(ModelClass_c.class)
						.get(new Object[]{m_obj_id});
			}
			if (relInst40116 == null && searchAllRoots
					&& !baseRoot.isCompareRoot()) {
				Ooaofooa[] roots = Ooaofooa.getInstances();
				for (int i = 0; i < roots.length; i++) {
					if (roots[i].isCompareRoot()) {
						// never use elements from any compare root
						continue;
					}
					relInst40116 = (ModelClass_c) roots[i].getInstanceList(
							ModelClass_c.class).get(new Object[]{m_obj_id});
					if (relInst40116 != null)
						break;
				}
			}
			//synchronized
			if (relInst40116 != null) {
				if (relateProxies || !isProxy()
						|| (inSameComponent(this, relInst40116) && !isProxy())) {
					relInst40116.relateAcrossR672To(this, notifyChanges);
				}
			}
		}

		// R603
		Statement_c relInst40117 = (Statement_c) baseRoot.getInstanceList(
				Statement_c.class).get(new Object[]{m_statement_id});
		// if there was no local element, check for any global elements
		// failing that proceed to check other model roots
		if (relInst40117 == null) {
			relInst40117 = (Statement_c) Ooaofooa.getDefaultInstance()
					.getInstanceList(Statement_c.class)
					.get(new Object[]{m_statement_id});
		}
		if (relInst40117 == null && searchAllRoots && !baseRoot.isCompareRoot()) {
			Ooaofooa[] roots = Ooaofooa.getInstances();
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].isCompareRoot()) {
					// never use elements from any compare root
					continue;
				}
				relInst40117 = (Statement_c) roots[i].getInstanceList(
						Statement_c.class).get(new Object[]{m_statement_id});
				if (relInst40117 != null)
					break;
			}
		}
		//synchronized
		if (relInst40117 != null) {
			if (relateProxies || !isProxy()
					|| (inSameComponent(this, relInst40117) && !isProxy())) {
				relInst40117.relateAcrossR603To(this, notifyChanges);
			}
		}

	}
	public void batchUnrelate(boolean notifyChanges) {
		NonRootModelElement inst = null;
		// R672
		// O_OBJ
		inst = InstanceOfModelClass;
		unrelateAcrossR672From(InstanceOfModelClass, notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
		// R603
		// ACT_SMT
		inst = IsSupertypeStatement;
		unrelateAcrossR603From(IsSupertypeStatement, notifyChanges);
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
	InstanceList instances = modelRoot.getInstanceList(CreateNoVariable_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final CreateNoVariable_c inst = (CreateNoVariable_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }
	public static void clearInstances(ModelRoot modelRoot) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);
		synchronized (instances) {
			for (int i = instances.size() - 1; i >= 0; i--) {
				((NonRootModelElement) instances.get(i)).delete_unchecked();
			}

		}
	}

	public static CreateNoVariable_c CreateNoVariableInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		CreateNoVariable_c result = findCreateNoVariableInstance(modelRoot,
				test, loadComponent);
		return result;
	}
	private static CreateNoVariable_c findCreateNoVariableInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				CreateNoVariable_c x = (CreateNoVariable_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					return x;
				}
			}
		}
		return null;
	}
	public static CreateNoVariable_c CreateNoVariableInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return CreateNoVariableInstance(modelRoot, test, true);
	}

	public static CreateNoVariable_c CreateNoVariableInstance(
			ModelRoot modelRoot) {
		return CreateNoVariableInstance(modelRoot, null, true);
	}

	public static CreateNoVariable_c[] CreateNoVariableInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(CreateNoVariable_c.class);
		Vector matches = new Vector();
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				CreateNoVariable_c x = (CreateNoVariable_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					matches.add(x);
				}
			}
			if (matches.size() > 0) {
				CreateNoVariable_c[] ret_set = new CreateNoVariable_c[matches
						.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new CreateNoVariable_c[0];
			}
		}
	}
	public static CreateNoVariable_c[] CreateNoVariableInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return CreateNoVariableInstances(modelRoot, test, true);
	}
	public static CreateNoVariable_c[] CreateNoVariableInstances(
			ModelRoot modelRoot) {
		return CreateNoVariableInstances(modelRoot, null, true);
	}

	public boolean delete() {
		boolean result = super.delete();
		boolean delete_error = false;
		String errorMsg = "The following relationships were not torn down by the Create No Variable.dispose call: ";
		ModelClass_c testR672Inst = ModelClass_c.getOneO_OBJOnR672(this, false);

		if (testR672Inst != null) {
			delete_error = true;
			errorMsg = errorMsg + "672 ";
		}
		Statement_c testR603Inst13 = Statement_c.getOneACT_SMTOnR603(this,
				false);

		if (testR603Inst13 != null) {
			delete_error = true;
			errorMsg = errorMsg + "603 ";
		}
		if (delete_error == true) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.DELETE, "Create No Variable",
						errorMsg);
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
		if (attributeName.equals("obj_id")) {
			return true;
		}
		return false;
	}
	// declare attribute accessors
	public long getStatement_idLongBased() {
		if (IsSupertypeStatement != null) {
			return IsSupertypeStatement.getStatement_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getStatement_id() {
		if (IsSupertypeStatement != null) {
			return IsSupertypeStatement.getStatement_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public boolean hasSuperType() {
		return (IsSupertypeStatement != null);

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
	public int getModelclasskeyletterslinenumber() {
		return m_modelclasskeyletterslinenumber;
	}

	public void setModelclasskeyletterslinenumber(int newValue) {
		m_modelclasskeyletterslinenumber = newValue;
	}
	public int getModelclasskeyletterscolumn() {
		return m_modelclasskeyletterscolumn;
	}

	public void setModelclasskeyletterscolumn(int newValue) {
		m_modelclasskeyletterscolumn = newValue;
	}
	public long getObj_idLongBased() {
		if (InstanceOfModelClass != null) {
			return InstanceOfModelClass.getObj_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getObj_id() {
		if (InstanceOfModelClass != null) {
			return InstanceOfModelClass.getObj_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public java.util.UUID getObj_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_obj_id))
			return m_obj_id;
		else
			return getObj_id();
	}

	public void setObj_id(java.util.UUID newValue) {
		m_obj_id = IdAssigner.preprocessUUID(newValue);
	}
	// end declare accessors
	public static void checkClassConsistency(ModelRoot modelRoot) {
		Ooaofooa.log
				.println(ILogger.OPERATION, "Create No Variable", //$NON-NLS-1$
						" Operation entered: Create No Variable::checkClassConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return;
		}
		CreateNoVariable_c[] objs = CreateNoVariable_c
				.CreateNoVariableInstances(modelRoot, null, false);

		for (int i = 0; i < objs.length; i++) {
			objs[i].checkConsistency();
		}
	}
	public boolean checkConsistency() {
		Ooaofooa.log.println(ILogger.OPERATION, "Create No Variable", //$NON-NLS-1$
				" Operation entered: Create No Variable::checkConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return true;
		}
		ModelRoot modelRoot = getModelRoot();
		boolean retval = true;
		class CreateNoVariable_c_test40119_c implements ClassQueryInterface_c {
			CreateNoVariable_c_test40119_c(java.util.UUID p40120) {
				m_p40120 = p40120;
			}
			private java.util.UUID m_p40120;
			public boolean evaluate(Object candidate) {
				CreateNoVariable_c selected = (CreateNoVariable_c) candidate;
				boolean retval = false;
				retval = (selected.getStatement_id().equals(m_p40120));
				return retval;
			}
		}

		CreateNoVariable_c[] objs40118 = CreateNoVariable_c
				.CreateNoVariableInstances(modelRoot,
						new CreateNoVariable_c_test40119_c(getStatement_id()));

		if (((objs40118.length) == 0)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Create No Variable", //$NON-NLS-1$
								"Consistency: Object: Create No Variable: Cardinality of an identifier is zero. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs40118.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create No Variable: Cardinality of an identifier is zero. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs40118.length), e);
			}
			retval = false;

		}

		if (((objs40118.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Create No Variable", //$NON-NLS-1$
								"Consistency: Object: Create No Variable: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs40118.length)
										+ " Statement_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create No Variable: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs40118.length)
										+ " Statement_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		// Create No Variable is a subtype in association: rel.Numb = 603
		// The supertype class is: Statement
		class Statement_c_test40124_c implements ClassQueryInterface_c {
			Statement_c_test40124_c(java.util.UUID p40125) {
				m_p40125 = p40125;
			}
			private java.util.UUID m_p40125;
			public boolean evaluate(Object candidate) {
				Statement_c selected = (Statement_c) candidate;
				boolean retval = false;
				retval = (selected.getStatement_id().equals(m_p40125));
				return retval;
			}
		}

		Statement_c[] objs40123 = Statement_c.StatementInstances(modelRoot,
				new Statement_c_test40124_c(getStatement_id()));

		if (((objs40123.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Create No Variable", //$NON-NLS-1$
								"Consistency: Object: Create No Variable: Association: 603: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs40123.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create No Variable: Association: 603: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs40123.length), e);
			}
			retval = false;

		}

		// Create No Variable is a referring class in association: rel.Numb = 672
		// The participating class is: Model Class
		class ModelClass_c_test40127_c implements ClassQueryInterface_c {
			ModelClass_c_test40127_c(java.util.UUID p40128) {
				m_p40128 = p40128;
			}
			private java.util.UUID m_p40128;
			public boolean evaluate(Object candidate) {
				ModelClass_c selected = (ModelClass_c) candidate;
				boolean retval = false;
				retval = (selected.getObj_id().equals(m_p40128));
				return retval;
			}
		}

		ModelClass_c[] objs40126 = ModelClass_c.ModelClassInstances(modelRoot,
				new ModelClass_c_test40127_c(getObj_id()));

		// The participant is unconditional
		// The multiplicity of the participant is one
		if (((objs40126.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Create No Variable", //$NON-NLS-1$
								"Consistency: Object: Create No Variable: Association: 672: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs40126.length)
										+ " Obj_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Create No Variable: Association: 672: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs40126.length)
										+ " Obj_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		return retval;
	}

	// declare transform functions
	public void Dispose() {
		Ooaofooa.log.println(ILogger.OPERATION, "Create No Variable",
				" Operation entered: CreateNoVariable::Dispose");
		final ModelRoot modelRoot = getModelRoot();
		ModelClass_c v_obj = ModelClass_c.getOneO_OBJOnR672(this);

		if (((v_obj != null))) {

			this.unrelateAcrossR672From(v_obj);

		}

		delete();

	} // End dispose
	public void Execute() {
		Ooaofooa.log.println(ILogger.OPERATION, "Create No Variable",
				" Operation entered: CreateNoVariable::Execute");
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
} // end Create No Variable
