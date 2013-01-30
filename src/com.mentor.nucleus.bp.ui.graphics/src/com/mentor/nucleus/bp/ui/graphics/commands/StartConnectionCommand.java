//========================================================================
//
//File:      $RCSfile: StartConnectionCommand.java,v $
//Version:   $Revision: 1.5.12.2 $
//Modified:  $Date: 2013/01/29 22:08:46 $
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
package com.mentor.nucleus.bp.ui.graphics.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public class StartConnectionCommand extends Command {

	private Point fPoint;

	public StartConnectionCommand(Point startPoint) {
		super();
		fPoint = startPoint;
	}
	
	public Point getStartPoint() {
		return fPoint;
	}

}
