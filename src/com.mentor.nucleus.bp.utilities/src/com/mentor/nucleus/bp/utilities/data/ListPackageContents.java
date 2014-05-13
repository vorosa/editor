//========================================================================
//
//File:      com.mentor.nucleus.bp.utilities/src/com/mentor/nucleus/bp/utilities/actions/CheckModelIntegrity.java
//
//Copyright 2005-2014 Mentor Graphics Corporation. All rights reserved.
//
//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
package com.mentor.nucleus.bp.utilities.data;

import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;

import com.mentor.nucleus.bp.core.ModelClass_c;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.PackageableElement_c;

public class ListPackageContents implements IActionDelegate {

	private ISelection selection;

	@Override
	public void run(IAction action) {

		System.out.println("asdasdasd");
		IStructuredSelection ss = (IStructuredSelection) selection;
		
		String result = "";
		
		for (Iterator<?> iterator = ss.iterator(); iterator.hasNext();) {
			Object selected = iterator.next();
			if (selected instanceof Package_c) {
				Package_c pkg = (Package_c) selected;

	
				for(PackageableElement_c pec : PackageableElement_c.getManyPE_PEsOnR8000(pkg))
				{
					result+="talalat!!: " + pec.getName() + "\n";
					
					if(ModelClass_c.getOneO_OBJOnR8001(pec) != null){
						result+="Oszcsinak uzenem, hogy nekem megy: " + ModelClass_c.getOneO_OBJOnR8001(pec).getName() + "\n";
					}
						
				
				}
				
				
			}

		}
		
		this.show(result);
	}
	
	public void show(String message) {
		  MessageDialog messageDialog = new MessageDialog(
		   null,
		   "Info",
		   null,
		   message,
		   MessageDialog.INFORMATION,
		   new String[]{"Ok"}, 0);
		  messageDialog.open();
		 }

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// cache the selection
		this.selection = selection;
	}

}
