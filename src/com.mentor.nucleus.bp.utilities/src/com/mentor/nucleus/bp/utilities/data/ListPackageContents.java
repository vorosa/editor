package com.mentor.nucleus.bp.utilities.data;

import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.Component_c;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.PackageableElement_c;
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
                    Package_c parentPkg = (Package_c) selected;
                 
                    // select many pkgs related by parentPkg->PE_PE[R8000]->EP_PKG[R8001]
                    Package_c[] pkgs = Package_c.getManyEP_PKGsOnR8001(PackageableElement_c.getManyPE_PEsOnR8000(parentPkg));
                    
                    if ( pkgs.length != 0 ) {
                        msg += "Packages:\n";
                    }
                    for (Package_c pkg: pkgs) {
                        msg += "    " + pkg.getName() + "\n";
                    }
                    
                    // select many comps related by parentPkg->PE_PE[R8000]->C_C[R8001]
                    Component_c[] comps = Component_c.getManyC_CsOnR8001(PackageableElement_c.getManyPE_PEsOnR8000(parentPkg));
                    
                    if ( comps.length != 0 ) {
                        if (pkgs.length != 0) { 
                            msg += "\n";
                        }
                        msg += "Components:\n";
                    }
                    for (Component_c comp: comps) {
                        msg += "    " + comp.getName() + "\n";
                    }
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
