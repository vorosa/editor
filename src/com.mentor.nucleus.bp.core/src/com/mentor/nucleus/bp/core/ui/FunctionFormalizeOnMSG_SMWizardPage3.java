package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    FunctionFormalizeOnMSG_SMWizardPage3.java
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

public class FunctionFormalizeOnMSG_SMWizardPage3 extends PtWizardPage
		implements
			Listener {
	public static final String copyright = "(c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.";

	IWorkbench workbench;
	IStructuredSelection selection;

	// widgets on this page (public for unit tests)
	public Combo MessageCombo;
	public Label MessageLabel;

	// cache for user choices
	Function_c Message = null;
	Function_c[] MessageInstances;

	/**
	 * Constructors for FunctionFormalizeOnMSG_SMWizardPage3.
	 */
	public FunctionFormalizeOnMSG_SMWizardPage3() {
		super("");
		init();
	}

	public FunctionFormalizeOnMSG_SMWizardPage3(String name) {
		super(name);
		init();
	}

	private void init() {
		setTitle("Formalize");
		setDescription("Choose the message to send");
	}

	public void onPageEntry() {
		Ooaofooa modelRoot = Selection
				.getModelRoot((StructuredSelection) ((FunctionFormalizeOnMSG_SMWizard) getWizard())
						.getSelection());

		// cache for context
		SynchronousMessage_c v_syncMessage = ((FunctionFormalizeOnMSG_SMWizard) getWizard()).v_syncMessage;

		Message_c v_message = Message_c.getOneMSG_MOnR1018(v_syncMessage);

		InteractionParticipant_c v_participant = InteractionParticipant_c
				.getOneSQ_POnR1007(v_message);

		Function_c v_function = Function_c
				.getOneS_SYNCOnR1010(FunctionMessage_c
						.getOneMSG_FOnR1020(v_syncMessage));

		java.util.UUID v_existingId = Gd_c.Null_unique_id();

		if (((v_function != null))) {

			v_existingId = v_function.getSync_id();

		}

		FunctionPackageParticipant_c v_fpp = FunctionPackageParticipant_c
				.getOneSQ_FPPOnR930(v_participant);

		if (((v_fpp == null))) {

			v_fpp = FunctionPackageParticipant_c
					.getOneSQ_FPPOnR930(InteractionParticipant_c
							.getOneSQ_POnR940(Lifespan_c
									.getOneSQ_LSOnR930(v_participant)));

		}

		if (((v_fpp != null))) {

			FunctionPackage_c v_fpk = FunctionPackage_c
					.getOneS_FPKOnR932(v_fpp);

			if (((v_fpk != null))) {

				// select related by where USER::selectOne
				Function_c[] v_MessageInstances = Function_c
						.getManyS_SYNCsOnR31(FunctionInPackage_c
								.getManyS_FIPsOnR31(v_fpk));
				Function_c v_Message = null;
				int MessageInstCount;
				int MessageResultCount = 0;
				for (MessageInstCount = 0; MessageInstCount < v_MessageInstances.length; MessageInstCount++) {
					Function_c selected = v_MessageInstances[MessageInstCount];
					if (User_c.Selectone(selected.getSync_id())
							&& !selected.getSync_id().equals(v_existingId)) {
						MessageResultCount++;
					}
				}
				this.MessageInstances = new Function_c[MessageResultCount];
				MessageResultCount = 0;
				for (MessageInstCount = 0; MessageInstCount < v_MessageInstances.length; MessageInstCount++) {
					Function_c selected = v_MessageInstances[MessageInstCount];
					if (User_c.Selectone(selected.getSync_id())
							&& !selected.getSync_id().equals(v_existingId)) {
						this.MessageInstances[MessageResultCount] = selected;
						MessageResultCount++;
					}
				}
				MessageCombo.removeAll();
				for (MessageInstCount = 0; MessageInstCount < MessageResultCount; MessageInstCount++)
					MessageCombo
							.add(((Function_c) this.MessageInstances[MessageInstCount])
									.getName());
				if (MessageResultCount == 1) {
					MessageCombo.select(0);
					updateSelectedMessage();
				}

				if (((v_Message != null))) {

				}

			}

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

		MessageLabel = new Label(composite, SWT.NONE);
		MessageLabel.setText("Message");
		MessageCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		MessageCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// set the composite as the control for this page
		setControl(composite);
		onPageEntry(); // Initialize the ui widget contents
		addListeners();
	}

	private void addListeners() {
		MessageCombo.addListener(SWT.Selection, this);
	}

	// public for unit tests
	public void updateSelectedMessage() {
		this.Message = MessageInstances[MessageCombo.getSelectionIndex()];
		((FunctionFormalizeOnMSG_SMWizard) getWizard()).v_Message = this.Message;
	}

	/**
	 * @see Listener#handleEvent(Event)
	 */
	public void handleEvent(Event event) {
		if (event.widget == MessageCombo) {
			updateSelectedMessage();
		}
		getWizard().getContainer().updateButtons();
	}

	public boolean isPageComplete() {
		boolean isPageComplete = true;
		if (Message == null)
			isPageComplete = false;
		return isPageComplete;
	}

	public IWizardPage getNextPage() {
		((FunctionFormalizeOnMSG_SMWizard) getWizard()).v_Message = Message;
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
		if (Message == null)
			return false;
		return true;
	}

}
