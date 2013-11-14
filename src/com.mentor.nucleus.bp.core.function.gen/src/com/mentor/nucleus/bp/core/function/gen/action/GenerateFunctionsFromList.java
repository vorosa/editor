package com.mentor.nucleus.bp.core.function.gen.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.CorePlugin;
import com.mentor.nucleus.bp.core.DataType_c;
import com.mentor.nucleus.bp.core.FunctionParameter_c;
import com.mentor.nucleus.bp.core.Function_c;
import com.mentor.nucleus.bp.core.Ooaofooa;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.PackageableElement_c;
import com.mentor.nucleus.bp.core.common.ModelElement;
import com.mentor.nucleus.bp.core.common.NonRootModelElement;
import com.mentor.nucleus.bp.core.common.Transaction;
import com.mentor.nucleus.bp.core.common.TransactionManager;

public class GenerateFunctionsFromList implements IActionDelegate {

	private ISelection selection;

	private static final int FUNCTION = 0;
	private static final int PARAMETER = 1;
	private Package_c parentPackage;

	class ElementData {

		private String name;
		private int type;
		private ElementData[] children;
		private String dataType;
		private Function_c parentFunction;
		private NonRootModelElement createdElement;
		private String actionLanguage;

		public ElementData(String name, int type, ElementData[] children,
				String dataType) {
			this.name = name;
			this.type = type;
			this.children = children;
			this.dataType = dataType;
		}

		public void setActionLanguage(String actionLanguage) {
			this.actionLanguage = actionLanguage;
		}
		
		public void create() {
			switch (type) {
			case FUNCTION:
				parentPackage.Newfunction();
				Function_c[] functions = Function_c
						.getManyS_SYNCsOnR8001(PackageableElement_c
								.getManyPE_PEsOnR8000(parentPackage));
				createdElement = functions[functions.length - 1];
				createdElement.setName(name);
				((Function_c) createdElement)
						.setAction_semantics_internal(actionLanguage);
				DataType_c returnType = getDataTypeByName();
				((Function_c) createdElement).relateAcrossR25To(returnType);
				createChildren(children);
				break;
			case PARAMETER:
				parentFunction.Newparameter();
				FunctionParameter_c[] params = FunctionParameter_c
						.getManyS_SPARMsOnR24(parentFunction);
				createdElement = params[params.length - 1];
				createdElement.setName(name);
				DataType_c paramType = getDataTypeByName();
				((FunctionParameter_c) createdElement)
						.relateAcrossR26To(paramType);
				break;
			default:
				break;
			}
		}

		private DataType_c getDataTypeByName() {
			PackageableElement_c pe = null;
			String defaultType = "void";
			switch (type) {
			case FUNCTION:
				pe = PackageableElement_c
						.getOnePE_PEOnR8001((Function_c) createdElement);
				break;
			case PARAMETER:
				defaultType = "integer";
				pe = PackageableElement_c.getOnePE_PEOnR8001(parentFunction);
				break;
			default:
				break;
			}
			UUID dtId = pe.Resolvedatatyperelativetoself(defaultType, dataType);
			DataType_c dt = (DataType_c) pe.getModelRoot().getInstanceList(
					DataType_c.class).getGlobal(dtId);
			return dt;
		}

		public void createChildren(ElementData[] children) {
			for (ElementData data : children) {
				data.parentFunction = (Function_c) createdElement;
				data.create();
			}
		}
	}

	@Override
	public void run(IAction action) {
		IStructuredSelection ss = (IStructuredSelection) selection;
		for (Iterator<?> i = ss.iterator(); i.hasNext();) {
			parentPackage = (Package_c) i.next();
			String functionListFile = getFunctionListFile();
			File functionFile = new File(functionListFile);
			if (functionFile.exists()) {
				Transaction transaction = null;
				try {
					transaction = TransactionManager.getSingleton()
							.startTransaction(
									"Create functions from list",
									new ModelElement[] { Ooaofooa
											.getDefaultInstance() });
					ElementData[] functions = getElementData(getFileContents(functionFile));
					for (ElementData function : functions) {
						function.create();
					}
					TransactionManager.getSingleton().endTransaction(
							transaction);
				} catch (Exception e) {
					if (transaction != null) {
						TransactionManager.getSingleton().cancelTransaction(
								transaction, e);
					}
					CorePlugin
							.logError(
									"Unable to start transaction for function creation.",
									e);
				}
			}
		}
	}
	
	/**
	 * This function will scan the text lines from a chosen file.  It will
	 * locate function signatures and the OAL that belongs to them.  The format
	 * is as follows:
	 * 
	 * function_name@type@@function_param@type@@function_param@type@@@
	 * 
	 * oal here
	 *
	 * @@@
	 * 
	 * @param lines
	 * @return
	 */
	private ElementData[] getElementData(String[] lines) {
		List<ElementData> functions = new ArrayList<ElementData>();
		ElementData lastFunction = null;
		boolean collectingOAL = false;
		String oal = "";
		for (String line : lines) {
			if(collectingOAL) {
				if(line.contains("@@@")) {
					collectingOAL = false;
					lastFunction.setActionLanguage(oal);
					oal = "";
					continue;
				}
				oal = oal + line + "\n";
			} else {
				String[] data = line.split("@@");
				// if there is a remaining @ symbol then we
				// must start OAL collection
				if(data[data.length - 1].equals("@")) {
					collectingOAL = true;
				}
				String functionName = "";
				List<ElementData> children = new ArrayList<ElementData>();
				String dataType = "";
				for (int i = 0; i < data.length; i++) {
					String[] split = data[i].split("@");
					if(split.length == 0) {
						// hit oal insertion point
						continue;
					}
					if (i == 0) {
						// function
						functionName = split[0];
						dataType = split[1];
					} else {
						ElementData parameter = new ElementData(split[0],
								PARAMETER, new ElementData[0], split[1]);
						children.add(parameter);
					}
				}
				lastFunction = new ElementData(functionName, FUNCTION,
						children.toArray(new ElementData[children.size()]),
						dataType);
				functions.add(lastFunction);
			}
		}
		return functions.toArray(new ElementData[functions.size()]);
	}

	private String[] getFileContents(File functionFile) {
		List<String> contents = new ArrayList<String>();
		try {
			Scanner in = new Scanner(new FileReader(functionFile));
			while (in.hasNextLine()) {
				contents.add(in.nextLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			CorePlugin.logError("Unable to read function file.", e);
		}
		return contents.toArray(new String[contents.size()]);
	}

	private String getFunctionListFile() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		return dialog.open();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// cache selection
		this.selection = selection;
	}

}
