package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    InheritanceFormalizeOnR_RELWizard.java
//
// WARNING: Do not edit this generated file
// Generated by arc/wizard.inc
//
// (c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.
//
//====================================================================
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.*;
import org.eclipse.ui.IWorkbench;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.core.util.TransactionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * InheritanceFormalizeOnR_RELWizard class
 */
public class InheritanceFormalizeOnR_RELWizard extends Wizard {
	public static final String copyright = "(c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.";

	// workbench selection when the wizard was started
	protected IStructuredSelection m_selection;

	// the workbench instance
	protected IWorkbench m_workbench;

	// the viewer the wizard was started from. This must be replaced with a listener system
	protected Viewer m_viewer;

	// Pages stack
	protected Stack m_pagesStack = new Stack();

	// wizard pages
	InheritanceFormalizeOnR_RELWizardPage1 R_REL_InheritanceFormalizePage1;

	// wizard state
	// constants
	protected static final int INITIAL_WIZARD_STATE = -1;
	protected static final int R_REL_INHERITANCEFORMALIZE0_WIZARD_STATE = 0;
	// member
	protected int m_state = INITIAL_WIZARD_STATE;
	// end wizard state

	// cache for contextual selections (public for use by unit tests)
	public Association_c v_rel = null;

	// cache for the users selections (public for use by unit tests)
	public ClassIdentifier_c v_Identifier = null;

	/**
	 * Constructor for InheritanceFormalizeOnR_RELWizard.
	 */
	public InheritanceFormalizeOnR_RELWizard() {
		super();
	}

	/**
	 * See field.
	 */
	public IStructuredSelection getSelection() {
		return m_selection;
	}

	public void addPages() {
		R_REL_InheritanceFormalizePage1 = new InheritanceFormalizeOnR_RELWizardPage1(
				"InheritanceFormalizeOnR_RELWizardPage1");
		addPage(R_REL_InheritanceFormalizePage1);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection,
			Viewer viewer) {
		this.m_workbench = workbench;
		this.m_selection = selection;
		this.m_viewer = viewer;
		for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
			Object context = iterator.next();
			if (context instanceof Association_c) {
				v_rel = (Association_c) context;
			}
		}
	}

	public boolean canFinish() {
		boolean pagesComplete = true;
		pagesComplete = pagesComplete
				&& R_REL_InheritanceFormalizePage1.isPageComplete();
		return pagesComplete;
	}

	public IWizardPage getNextPage(IWizardPage page) {
		List pages = new ArrayList(getPages().length);
		for (int i = 0; i < getPages().length; i++) {
			pages.add(getPages()[i]);
		}
		switch (pages.indexOf(page)) {
			case R_REL_INHERITANCEFORMALIZE0_WIZARD_STATE :
				return null;
		}
		return null;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		if (m_pagesStack.empty()) {
			return null;
		} else {
			List pages = new ArrayList(getPages().length);
			for (int i = 0; i < getPages().length; i++) {
				pages.add(getPages()[i]);
			}
			m_state = pages.indexOf((IWizardPage) m_pagesStack.peek());
			((PtWizardPage) m_pagesStack.peek()).onPageEntry();
			return (IWizardPage) m_pagesStack.pop();
		}
	}

	public boolean performFinish() {
		TransactionUtil.TransactionGroup transactionGroup = null;
		ModelRoot modelRoot = v_rel.getModelRoot();
		try {
			transactionGroup = TransactionUtil
					.startTransactionsOnSelectedModelRoots("Inheritance Formalize"); //$NON-NLS-1$
			SubtypeSupertypeAssociation_c v_ss_rel = SubtypeSupertypeAssociation_c
					.getOneR_SUBSUPOnR206(v_rel);

			ModelClass_c v_super_obj = ModelClass_c
					.getOneO_OBJOnR201(ClassInAssociation_c
							.getOneR_OIROnR203(ReferredToClassInAssoc_c
									.getOneR_RTOOnR204(ClassAsSupertype_c
											.getOneR_SUPEROnR212(v_ss_rel))));

			if (((v_Identifier != null))) {

				if (v_ss_rel != null) {
					v_ss_rel.Formalize(v_Identifier.getOid_id());
				} else {
					Throwable t = new Throwable();
					t.fillInStackTrace();
					CorePlugin
							.logError(
									"Attempted to call an operation on a null instance.",
									t);
				}

			}

			// catch all exceptions and cancel the transaction
		} catch (Exception e) {
			if (transactionGroup != null)
				TransactionUtil.cancelTransactions(transactionGroup, e);
			CorePlugin.logError("Transaction: Inheritance Formalize failed", e);//$NON-NLS-1$
			// return true so that the wizard will
			// close
			return true;
		}
		if (transactionGroup != null)
			TransactionUtil.endTransactions(transactionGroup);
		if (m_viewer != null) {
			if (m_viewer instanceof StructuredViewer) {
				((StructuredViewer) m_viewer).refresh(v_rel);
			} else {
				m_viewer.refresh();
			}
		}
		return true;
	}
}