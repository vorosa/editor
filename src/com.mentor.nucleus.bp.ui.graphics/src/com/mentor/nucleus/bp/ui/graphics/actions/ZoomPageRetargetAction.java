package com.mentor.nucleus.bp.ui.graphics.actions;
//=====================================================================
//
// File:      $RCSfile: ZoomPageRetargetAction.java,v $
// Version:   $Revision: 1.2.224.1 $
// Modified:  $Date: 2013/01/29 22:09:15 $
//
//
//=====================================================================
// © 2013 Mentor Graphics Corporation
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
//=====================================================================

import org.eclipse.ui.actions.RetargetAction;

import com.mentor.nucleus.bp.core.CorePlugin;

public class ZoomPageRetargetAction extends RetargetAction {

	public ZoomPageRetargetAction() {
		super(null, null);
		setText("Zoom Page");
		setId(GraphicalActionConstants.ZOOM_PAGE);
		setToolTipText("Click to zoom the entire contents");
		setImageDescriptor(CorePlugin.getImageDescriptor("zoomAll.gif")); // $NON-NLS-1$
	}

}
