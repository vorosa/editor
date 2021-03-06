package com.mentor.nucleus.bp.ui.explorer.adapters;
//======================================================================
//
// File: com/mentor/nucleus/bp/ui/explorer/adapters/InterfacePackagesAdapter.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/create_adapters.inc
// Version:      $Revision: 1.31 $
//
// (c) Copyright 2006-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================
//
// This class is responsible for decoupling the client model entity
// class InterfacePackage_c from the tree viewer and the hierarchy
// it imposes.
//
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import com.mentor.nucleus.bp.core.*;

import com.mentor.nucleus.bp.ui.explorer.*;
/**
 * This file adapts the meta-model entity; 'InterfacePackage_c'
 * so that it works with the Eclipse JFace user interface components.
 * <p>
 * Do not edit this class, it was created using the Mentor 
 * Graphics MC-Java code generator product.
 * </p>
 */
public class InterfacePackagesAdapter implements ITreeContentProvider {
	static InterfacePackagesAdapter interfacepackagesadapter = null;
	/**
	 * Returns the adapters singleton instance. If this
	 * is the first time, the instance is created.
	 */
	public static InterfacePackagesAdapter getInstance() {
		if (interfacepackagesadapter == null) {
			interfacepackagesadapter = new InterfacePackagesAdapter();
		}
		return interfacepackagesadapter;
	}
	/**
	 * @see IContentProvider#inputChanged(Viewer, Object, Object)
	 * Called when the tree's input has been changed
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing to do
	}
	/**
	 * @see IContentProvider#dispose()
	 * Called when this viewer is no longer needed
	 */
	public void dispose() {
		// Nothing to dispose
	}
	/**
	 * @see ITreeContentProvider#getParent(Object)
	 * Returns the parent of this node
	 */
	public Object getParent(Object arg) {
		SystemModel_c result156 = SystemModel_c
				.getOneS_SYSOnR4302((InterfacePackage_c) arg);
		if (result156 != null) {
			return result156;
		}
		InterfacePackage_c result157 = InterfacePackage_c
				.getOneIP_IPOnR4300(InterfacePackageInInterfacePackage_c
						.getOneIP_IPINIPOnR4301((InterfacePackage_c) arg));
		if (result157 != null) {
			return result157;
		}
		Package_c result158 = Package_c
				.getOneEP_PKGOnR1400(SpecificationPackage_c
						.getOneEP_SPKGOnR1402((InterfacePackage_c) arg));
		if (result158 != null) {
			return result158;
		}
		ComponentPackage_c result159 = ComponentPackage_c
				.getOneCP_CPOnR4607((InterfacePackage_c) arg);
		if (result159 != null) {
			return result159;
		}
		Component_c result160 = Component_c
				.getOneC_COnR4206((InterfacePackage_c) arg);
		if (result160 != null) {
			return result160;
		}
		return null;
	}
	/**
	 * @see IStructuredContentProvider#getElements(Object)
	 * Returns the elements below this node
	 */
	public Object[] getElements(Object arg) {
		return getChildren(arg);
	}

	/**
	 * @see ITreeContentProvider#getChildren(Object)
	 * Returns the children of this node
	 */
	public Object[] getChildren(Object arg) {
		int resultSize = 0;
		InterfacePackage_c[] interfacepackages_4300_1 = InterfacePackage_c
				.getManyIP_IPsOnR4301(InterfacePackageInInterfacePackage_c
						.getManyIP_IPINIPsOnR4300((InterfacePackage_c) arg));

		ModelContentProvider.sort(interfacepackages_4300_1);
		resultSize += interfacepackages_4300_1.length;
		Interface_c[] interfaces_4303_2 = Interface_c
				.getManyC_IsOnR4303((InterfacePackage_c) arg);

		ModelContentProvider.sort(interfaces_4303_2);
		resultSize += interfaces_4303_2.length;

		Object[] result = new Object[resultSize];
		int count = 0;
		for (int i = 0; i < interfacepackages_4300_1.length; i++) {
			result[count] = interfacepackages_4300_1[i];
			count++;
		}
		for (int i = 0; i < interfaces_4303_2.length; i++) {
			result[count] = interfaces_4303_2[i];
			count++;
		}
		return result;
	}
	/**
	 * @see ITreeContentProvider#hasChildren(Object)
	 * Returns true if this node has any children
	 */
	public boolean hasChildren(Object arg) {
		InterfacePackage_c[] interfacepackages_4300_1 = InterfacePackage_c
				.getManyIP_IPsOnR4301(InterfacePackageInInterfacePackage_c
						.getManyIP_IPINIPsOnR4300((InterfacePackage_c) arg));

		if (interfacepackages_4300_1.length > 0)
			return true;
		Interface_c[] interfaces_4303_2 = Interface_c
				.getManyC_IsOnR4303((InterfacePackage_c) arg);

		if (interfaces_4303_2.length > 0)
			return true;
		return false;
	}
}
