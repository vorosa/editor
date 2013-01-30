//========================================================================
//
//File:      $RCSfile: GraphicsFreeformLayeredPane.java,v $
//Version:   $Revision: 1.4.12.2 $
//Modified:  $Date: 2013/01/29 22:10:04 $
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
package com.mentor.nucleus.bp.ui.graphics.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public class GraphicsFreeformLayeredPane extends
		FreeformLayeredPane {

	@Override
	protected void paintChildren(Graphics graphics) {
		IFigure child;

		Rectangle clip = Rectangle.SINGLETON;
		
		List<IFigure> connectionLayers = new ArrayList<IFigure>();
		for (int i = 0; i < getChildren().size(); i++) {
			child = (IFigure)getChildren().get(i);
			// skip all user defined connection layers, and draw after
			if(child instanceof ConnectionLayer) {
				connectionLayers.add(child);
				continue;
			}
			if (child.isVisible() && child.intersects(graphics.getClip(clip))) {
				graphics.clipRect(child.getBounds());
				child.paint(graphics);
				graphics.restoreState();
			}
		}
		for(IFigure conLayer : connectionLayers) {
			if(conLayer.isVisible() && conLayer.intersects(graphics.getClip(clip))) {
				graphics.clipRect(conLayer.getBounds());
				conLayer.paint(graphics);
				graphics.restoreState();
			}
		}
	}

}
