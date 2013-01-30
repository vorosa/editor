package com.mentor.nucleus.bp.ui.graphics.router;
//=====================================================================
//
// File:      $RCSfile: BendpointConnectionRouter.java,v $
// Version:   $Revision: 1.5.98.1 $
// Modified:  $Date: 2013/01/29 22:10:00 $
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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;

import com.mentor.nucleus.bp.ui.graphics.editor.GraphicalEditor;
import com.mentor.nucleus.bp.ui.graphics.utilities.GraphicsUtil;

public class BendpointConnectionRouter extends
		org.eclipse.draw2d.BendpointConnectionRouter {

	protected static final PrecisionPoint A_POINT = new PrecisionPoint();

	@Override
	public void route(Connection conn) {
		PointList points = conn.getPoints().getCopy();
		points.removeAllPoints();

		List<?> bendpoints = (List<?>) getConstraint(conn);
		if (bendpoints == null)
			bendpoints = Collections.EMPTY_LIST;

		Point ref1, ref2;

		if (bendpoints.isEmpty()) {
			ref1 = conn.getTargetAnchor().getReferencePoint();
			ref2 = conn.getSourceAnchor().getReferencePoint();
		} else {
			ref1 = new Point(((Bendpoint) bendpoints.get(0)).getLocation());
			conn.translateToAbsolute(ref1);
			ref2 = new Point(
					((Bendpoint) bendpoints.get(bendpoints.size() - 1))
							.getLocation());
			conn.translateToAbsolute(ref2);
		}
		
		A_POINT.setLocation(conn.getSourceAnchor().getLocation(ref1));
		conn.translateToRelative(A_POINT);
		points.addPoint(A_POINT);

		for (int i = 0; i < bendpoints.size(); i++) {
			Bendpoint bp = (Bendpoint) bendpoints.get(i);
			points.addPoint(bp.getLocation());
		}

		A_POINT.setLocation(conn.getTargetAnchor().getLocation(ref2));
		conn.translateToRelative(A_POINT);
		points.addPoint(A_POINT);
		straightenPoints(points);
		conn.setPoints(points);
	}

	public static void straightenPoints(PointList points) {
		for (int i = 0; i < points.size(); i++) {
			if (i == points.size() - 1) {
				continue;
			}
			Point first = points.getPoint(i);
			Point next = points.getPoint(i + 1);
			GraphicsUtil.synchronizePoints(first, next, GraphicalEditor
					.getGridSpacing() / 2);
			points.setPoint(first, i);
		}
	}

}
