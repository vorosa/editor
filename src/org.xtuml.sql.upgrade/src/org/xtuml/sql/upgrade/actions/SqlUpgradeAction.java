package org.xtuml.sql.upgrade.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.CorePlugin;
import com.mentor.nucleus.bp.core.Domain_c;
import com.mentor.nucleus.bp.core.Ooaofooa;
import com.mentor.nucleus.bp.core.SystemModel_c;
import com.mentor.nucleus.bp.core.common.ClassQueryInterface_c;
import com.mentor.nucleus.bp.core.common.ComponentResourceListener;
import com.mentor.nucleus.bp.core.common.NonRootModelElement;
import com.mentor.nucleus.bp.core.common.PersistableModelComponent;
import com.mentor.nucleus.bp.core.common.UpgradeJob;
import com.mentor.nucleus.bp.core.ui.AbstractModelImportFactory;
import com.mentor.nucleus.bp.core.ui.AbstractStreamExportFactory;
import com.mentor.nucleus.bp.core.ui.AbstractStreamImportFactory;
import com.mentor.nucleus.bp.core.ui.IModelImport;
import com.mentor.nucleus.bp.io.mdl.upgrade.UpgradeUtil;
import com.mentor.nucleus.bp.utilities.ui.ProjectUtilities;

public class SqlUpgradeAction implements IViewActionDelegate {

	@Override
	public void run(IAction action) {
		ComponentResourceListener.setIgnoreResourceChangesMarker(true);
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getDisplay().getActiveShell());
		dialog.setFilterExtensions(new String[] { "*.sql" });
		String filePath = dialog.open();
		if (filePath == null || filePath.equals("")) {
			return;
		}
		File file = new File(filePath);
		if (!file.exists()) {
			MessageDialog.openError(PlatformUI.getWorkbench().getDisplay()
					.getActiveShell(), "File not found",
					"Could not locate file: " + filePath);
			return;
		}
		AbstractModelImportFactory sqlFactory = CorePlugin
				.getSqlImportFactory();
		final String systemName = readProjectNameFromModelFile(file);
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(systemName);
		if (project.exists()) {
			MessageDialog
					.openError(PlatformUI.getWorkbench().getDisplay()
							.getActiveShell(), "Project exists",
							"Project already exists, the SQL file will not be upgraded");
			return;
		}
		ProjectUtilities.createProject(ResourcesPlugin.getWorkspace().getRoot()
				.getProject(systemName));
		SystemModel_c system = SystemModel_c.SystemModelInstance(
				Ooaofooa.getDefaultInstance(), new ClassQueryInterface_c() {

					@Override
					public boolean evaluate(Object candidate) {
						return ((SystemModel_c) candidate).getName().equals(
								systemName);
					}
				});
		String rootId = Ooaofooa.createModelRootId(
				(IProject) system.getAdapter(IProject.class), systemName, true);
		Ooaofooa createdRoot = Ooaofooa.getInstance(rootId);
		try {
			IModelImport importer = sqlFactory.create(filePath, createdRoot,
					system, false, true, true);
			importer.run(new NullProgressMonitor());
			Domain_c domain = Domain_c.DomainInstance(createdRoot);
			domain.setName(systemName);
			// export the domain to a stream
			AbstractStreamExportFactory exportFactory = CorePlugin
					.getStreamExportFactory();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IRunnableWithProgress exporter = exportFactory.create(baos,
					new NonRootModelElement[] { domain }, true, false);
			exporter.run(new NullProgressMonitor());
			// clear the memory database
			domain.getPersistableComponent().deleteSelfAndChildren();
			// import the stream
			AbstractStreamImportFactory streamFactory = CorePlugin
					.getStreamImportFactory();
			IModelImport streamImporter = streamFactory.create(
					new ByteArrayInputStream(baos.toByteArray()), createdRoot,
					true, system.getFile().getFullPath());
			streamImporter.run(new NullProgressMonitor());
			// persist the memory database
			domain = Domain_c.DomainInstance(createdRoot);
			final PersistableModelComponent domainComponent = domain.getPersistableComponent();
			NonRootModelElement[] loadedInstances = streamImporter.getLoadedInstances();
			for(NonRootModelElement loaded : loadedInstances) {
				loaded.getPersistableComponent();
			}
			ComponentResourceListener.setIgnoreResourceChanges(true);
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					domainComponent.persistSelfAndChildren();
				}

			}, new NullProgressMonitor());
			// upgrade new domain to packages
			UpgradeUtil.allowAutomaticUpgradeForNextJob();
			UpgradeJob job = new UpgradeJob("Upgrade SQL File",
					domain.getPersistableComponent());
			job.setRule(ResourcesPlugin.getWorkspace().getRoot());
			job.schedule();
		} catch (FileNotFoundException e) {
			CorePlugin.logError("Could not find file to upgrade.", e);
		} catch (InvocationTargetException e) {
			CorePlugin.logError("Could not upgrade file.", e);
		} catch (InterruptedException e) {
			CorePlugin.logError("Could not upgrade file.", e);
		} catch (CoreException e) {
			CorePlugin.logError("Unable to persist newly created domain", e);
		} catch (IOException e) {
			CorePlugin.logError("Unable to create stream importer.", e);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// not interested
	}

	@Override
	public void init(IViewPart view) {
		// not interested
	}

	private String readProjectNameFromModelFile(File modelFile) {
		try {
			RandomAccessFile ra = new RandomAccessFile(modelFile, "rw");
			byte[] b = new byte[(int) modelFile.length()];
			try {
				ra.read(b);
			} catch (Exception e) {
				CorePlugin.logError("Unable to read model file.", e);
				ra.close();
				return "";
			}
			String result = new String(b);
			String[] split = result.split("\n");
			String domainNameLine = split[4];
			String[] domainSplit = domainNameLine.split("'");
			if (domainSplit.length == 1) {
				return modelFile.getName().replaceAll(".xtuml", "");
			}
			return domainSplit[1];
		} catch (IOException e) {
			CorePlugin.logError("Unable to read model file.", e);
		}
		return "";
	}

}
