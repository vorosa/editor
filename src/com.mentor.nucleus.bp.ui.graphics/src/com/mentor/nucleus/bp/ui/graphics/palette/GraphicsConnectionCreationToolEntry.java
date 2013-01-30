//========================================================================
//
//File:      $RCSfile: GraphicsConnectionCreationToolEntry.java,v $
//Version:   $Revision: 1.6.12.2 $
//Modified:  $Date: 2013/01/29 22:08:51 $
//
//
//========================================================================
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
//======================================================================== 
//
package com.mentor.nucleus.bp.ui.graphics.palette;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.jface.resource.ImageDescriptor;

import com.mentor.nucleus.bp.ui.graphics.tools.GraphicsConnectionCreationTool;

public class GraphicsConnectionCreationToolEntry extends
		ConnectionCreationToolEntry {

	private int type;

	public GraphicsConnectionCreationToolEntry(String label, String shortDesc,
			CreationFactory factory, ImageDescriptor iconSmall,
			ImageDescriptor iconLarge, int ooaType) {
		super(label, shortDesc, factory, iconSmall, iconLarge);
		type = ooaType;
	}

	@Override
	public Tool createTool() {
		return new GraphicsConnectionCreationTool(
				(CreationFactory) getToolProperty(CreationTool.PROPERTY_CREATION_FACTORY),
				type);
	}
}
