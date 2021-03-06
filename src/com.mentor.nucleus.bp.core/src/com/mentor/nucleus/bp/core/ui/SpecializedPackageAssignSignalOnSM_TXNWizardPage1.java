package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    SpecializedPackageAssignSignalOnSM_TXNWizardPage1.java
//
// WARNING: Do not edit this generated file
// Generated by arc/page.inc
//
// (c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.
//
//====================================================================
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.ClassQueryInterface_c;

import java.util.ArrayList;
import java.util.List;

public class SpecializedPackageAssignSignalOnSM_TXNWizardPage1
		extends
			PtWizardPage implements Listener {
	public static final String copyright = "(c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.";

	IWorkbench workbench;
	IStructuredSelection selection;

	// widgets on this page (public for unit tests)
	public Combo InterfaceCombo;
	public Label InterfaceLabel;

	// cache for user choices
	InterfaceReference_c Interface = null;
	InterfaceReference_c[] InterfaceInstances;

	/**
	 * Constructors for SpecializedPackageAssignSignalOnSM_TXNWizardPage1.
	 */
	public SpecializedPackageAssignSignalOnSM_TXNWizardPage1() {
		super("");
		init();
	}

	public SpecializedPackageAssignSignalOnSM_TXNWizardPage1(String name) {
		super(name);
		init();
	}

	private void init() {
		setTitle("Assign Signal");
		setDescription("Select signal to assign to transition");
	}

	public void onPageEntry() {
		Ooaofooa modelRoot = Selection
				.getModelRoot((StructuredSelection) ((SpecializedPackageAssignSignalOnSM_TXNWizard) getWizard())
						.getSelection());

		// cache for previous user selections
		InterfaceSignal_c v_signal = ((SpecializedPackageAssignSignalOnSM_TXNWizard) getWizard()).v_signal;

		// cache for context
		Transition_c v_txn = ((SpecializedPackageAssignSignalOnSM_TXNWizard) getWizard()).v_txn;

		java.util.UUID v_Trans_ID = v_txn.getTrans_id();

		StateMachine_c v_stateMachine = StateMachine_c.getOneSM_SMOnR505(v_txn);

		ClassStateMachine_c v_classStateMachine = ClassStateMachine_c
				.getOneSM_ASMOnR517(v_stateMachine);

		// select related by where USER::selectOne
		InterfaceReference_c[] v_interfaceInstances = InterfaceReference_c
				.getManyC_IRsOnR4016(Port_c.getManyC_POsOnR4010(Component_c.getManyC_CsOnR4204(DomainAsComponent_c.getManyCN_DCsOnR4204(Domain_c.getManyS_DOMsOnR1(Subsystem_c
						.getManyS_SSsOnR2(ModelClass_c
								.getManyO_OBJsOnR519(v_classStateMachine)))))));
		InterfaceReference_c v_interface = null;
		int interfaceInstCount;
		int interfaceResultCount = 0;
		for (interfaceInstCount = 0; interfaceInstCount < v_interfaceInstances.length; interfaceInstCount++) {
			InterfaceReference_c selected = v_interfaceInstances[interfaceInstCount];
			if (User_c.Selectone(selected.getId())
					&& v_stateMachine.Hasvalidsignals(selected.getId(),
							v_Trans_ID)) {
				interfaceResultCount++;
			}
		}
		this.InterfaceInstances = new InterfaceReference_c[interfaceResultCount];
		interfaceResultCount = 0;
		for (interfaceInstCount = 0; interfaceInstCount < v_interfaceInstances.length; interfaceInstCount++) {
			InterfaceReference_c selected = v_interfaceInstances[interfaceInstCount];
			if (User_c.Selectone(selected.getId())
					&& v_stateMachine.Hasvalidsignals(selected.getId(),
							v_Trans_ID)) {
				this.InterfaceInstances[interfaceResultCount] = selected;
				interfaceResultCount++;
			}
		}
		InterfaceCombo.removeAll();
		for (interfaceInstCount = 0; interfaceInstCount < interfaceResultCount; interfaceInstCount++)
			InterfaceCombo
					.add(((InterfaceReference_c) this.InterfaceInstances[interfaceInstCount])
							.Get_name());
		if (interfaceResultCount == 1) {
			InterfaceCombo.select(0);
			updateSelectedInterface();
		}

		if ((v_interface != null)) {

		}

	}

	public void createControl(Composite parent) {
		// create the composite to hold the widgets   
		GridData gd = null;
		Composite composite = new Composite(parent, SWT.NULL);

		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		int ncol = 5;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		InterfaceLabel = new Label(composite, SWT.NONE);
		InterfaceLabel.setText("Interface");
		InterfaceCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		InterfaceCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// set the composite as the control for this page
		setControl(composite);
		onPageEntry(); // Initialize the ui widget contents
		addListeners();
	}

	private void addListeners() {
		InterfaceCombo.addListener(SWT.Selection, this);
	}

	// public for unit tests
	public void updateSelectedInterface() {
		this.Interface = InterfaceInstances[InterfaceCombo.getSelectionIndex()];
		((SpecializedPackageAssignSignalOnSM_TXNWizard) getWizard()).v_interface = this.Interface;
	}

	/**
	 * @see Listener#handleEvent(Event)
	 */
	public void handleEvent(Event event) {
		if (event.widget == InterfaceCombo) {
			updateSelectedInterface();
		}
		getWizard().getContainer().updateButtons();
	}

	public boolean isPageComplete() {
		boolean isPageComplete = true;
		if (Interface == null)
			isPageComplete = false;
		return isPageComplete;
	}

	public IWizardPage getNextPage() {
		((SpecializedPackageAssignSignalOnSM_TXNWizard) getWizard()).v_interface = Interface;
		PtWizardPage page = (PtWizardPage) getWizard().getNextPage(this);
		page.onPageEntry();
		return page;
	}

	/**
	 * @see IWizardPage#canFlipToNextPage()
	 */
	public boolean canFlipToNextPage() {
		if ((PtWizardPage) getWizard().getNextPage(this) == null)
			return false;
		if (Interface == null)
			return false;
		return true;
	}

}
