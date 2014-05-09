package com.mentor.nucleus.bp.utilities.data;

import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.util.UIUtil;
import com.mentor.nucleus.bp.core.util.UIUtil.BPMessageTypes;

public class ListPackageContents implements IActionDelegate {

    private ISelection selection;

    @Override
    public void run(IAction action) {
        String msg = "";
        
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection ss = (IStructuredSelection) selection;
            for (Iterator<?> iterator = ss.iterator(); iterator.hasNext();) {
                Object selected = iterator.next();
                if (selected instanceof Package_c) {
                    Package_c pkg = (Package_c) selected;
                 
                    // TODO - Fill in functionality here
                }
            }
        }
        
        if (!msg.isEmpty()) {
            UIUtil.openScrollableTextDialog(PlatformUI.getWorkbench()
                    .getDisplay().getActiveShell(), false,
                    "Package Contents Report",
                    msg,
                    "The following package contents were found.", null, null,
                    false);
        } else {
            UIUtil.openMessageDialog(PlatformUI.getWorkbench().getDisplay()
                    .getActiveShell(), "Package Contents Report", null,
                    "Package is empty.",
                    BPMessageTypes.INFORMATION, new String[] { "OK" }, 0);
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        // cache the selection
        this.selection = selection;
    }

}
