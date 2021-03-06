package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    SpecializedPackageAssignClassOnO_IOBJWizard.java
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
 * SpecializedPackageAssignClassOnO_IOBJWizard class
 */
public class SpecializedPackageAssignClassOnO_IOBJWizard extends Wizard {
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
	SpecializedPackageAssignClassOnO_IOBJWizardPage1 O_IOBJ_SpecializedPackageAssignClassPage1;
	SpecializedPackageAssignClassOnO_IOBJWizardPage2 O_IOBJ_SpecializedPackageAssignClassPage2;

	// wizard state
	// constants
	protected static final int INITIAL_WIZARD_STATE = -1;
	protected static final int O_IOBJ_SPECIALIZEDPACKAGEASSIGNCLASS0_WIZARD_STATE = 0;
	protected static final int O_IOBJ_SPECIALIZEDPACKAGEASSIGNCLASS1_WIZARD_STATE = 1;
	// member
	protected int m_state = INITIAL_WIZARD_STATE;
	// end wizard state

	// cache for contextual selections (public for use by unit tests)
	public ImportedClass_c v_iobj = null;

	// cache for the users selections (public for use by unit tests)
	public Subsystem_c v_Subsystem = null;
	public ModelClass_c v_Class = null;

	/**
	 * Constructor for SpecializedPackageAssignClassOnO_IOBJWizard.
	 */
	public SpecializedPackageAssignClassOnO_IOBJWizard() {
		super();
	}

	/**
	 * See field.
	 */
	public IStructuredSelection getSelection() {
		return m_selection;
	}

	public void addPages() {
		O_IOBJ_SpecializedPackageAssignClassPage1 = new SpecializedPackageAssignClassOnO_IOBJWizardPage1(
				"SpecializedPackageAssignClassOnO_IOBJWizardPage1");
		addPage(O_IOBJ_SpecializedPackageAssignClassPage1);
		O_IOBJ_SpecializedPackageAssignClassPage2 = new SpecializedPackageAssignClassOnO_IOBJWizardPage2(
				"SpecializedPackageAssignClassOnO_IOBJWizardPage2");
		addPage(O_IOBJ_SpecializedPackageAssignClassPage2);
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
			if (context instanceof ImportedClass_c) {
				v_iobj = (ImportedClass_c) context;
			}
		}
	}

	public boolean canFinish() {
		boolean pagesComplete = true;
		pagesComplete = pagesComplete
				&& O_IOBJ_SpecializedPackageAssignClassPage1.isPageComplete();
		pagesComplete = pagesComplete
				&& O_IOBJ_SpecializedPackageAssignClassPage2.isPageComplete();
		return pagesComplete;
	}

	public IWizardPage getNextPage(IWizardPage page) {
		List pages = new ArrayList(getPages().length);
		for (int i = 0; i < getPages().length; i++) {
			pages.add(getPages()[i]);
		}
		switch (pages.indexOf(page)) {
			case O_IOBJ_SPECIALIZEDPACKAGEASSIGNCLASS0_WIZARD_STATE :
				m_state = pages
						.indexOf(O_IOBJ_SpecializedPackageAssignClassPage2);
				O_IOBJ_SpecializedPackageAssignClassPage2.onPageEntry();
				return O_IOBJ_SpecializedPackageAssignClassPage2;

			case O_IOBJ_SPECIALIZEDPACKAGEASSIGNCLASS1_WIZARD_STATE :
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
		ModelRoot modelRoot = v_iobj.getModelRoot();
		try {
			transactionGroup = TransactionUtil
					.startTransactionsOnSelectedModelRoots("Specialized Package Assign Class"); //$NON-NLS-1$
			if (((v_Subsystem != null))) {

				if (((v_Class != null))) {

					if (v_iobj != null) {
						v_iobj.relateAcrossR101To(v_Class);
					} else {
						Throwable t = new Throwable();
						t.fillInStackTrace();
						CorePlugin.logError(
								"Relate attempted on null left hand instance.",
								t);
					}

				}

			}

			// catch all exceptions and cancel the transaction
		} catch (Exception e) {
			if (transactionGroup != null)
				TransactionUtil.cancelTransactions(transactionGroup, e);
			CorePlugin.logError(
					"Transaction: Specialized Package Assign Class failed", e);//$NON-NLS-1$
			// return true so that the wizard will
			// close
			return true;
		}
		if (transactionGroup != null)
			TransactionUtil.endTransactions(transactionGroup);
		if (m_viewer != null) {
			if (m_viewer instanceof StructuredViewer) {
				((StructuredViewer) m_viewer).refresh(v_iobj);
			} else {
				m_viewer.refresh();
			}
		}
		return true;
	}
}
