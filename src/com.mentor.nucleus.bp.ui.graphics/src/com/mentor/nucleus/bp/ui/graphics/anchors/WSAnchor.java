//========================================================================
//
//File:      $RCSfile: WSAnchor.java,v $
//Version:   $Revision: 1.7.12.2 $
//Modified:  $Date: 2013/01/29 22:08:49 $
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
package com.mentor.nucleus.bp.ui.graphics.anchors;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OrthogonalConnectionAnchor;

import com.mentor.nucleus.bp.ui.graphics.parts.ConnectorEditPart;

public class WSAnchor extends AbstractConnectionAnchor implements
		IAdjustableReferencePointAnchor, OrthogonalConnectionAnchor {

	private PrecisionPoint currentPoint;
	public boolean isForRequest = false;

	public WSAnchor(IFigure figure) {
		super(figure);
	}

	Figure figure = new Figure() {

		private Rectangle figureBounds = new Rectangle(0, 0, 1, 1);

		@Override
		public Rectangle getBounds() {
			// create a rectangle the size of the reference point
			figureBounds .setLocation(getRawReferencePoint());
			return figureBounds;
		}

		@Override
		public void paint(Graphics graphics) {
			// do not paint
		}
		
	};
	
	@Override
	public IFigure getOwner() {
		if(figure.getParent() == null) {
			figure.setParent(super.getOwner());
		}
		// we need to use an invisible figure, that has the
		// set point on the edge
		return figure;
	}

	public void setLocation(PrecisionPoint point) {
		currentPoint = point;
	}

	@Override
	public Point getLocation(Point reference) {
		return getAdjustedReferencePoint();
	}

	private Point getAdjustedReferencePoint() {
		PrecisionPoint referencePoint = (PrecisionPoint) currentPoint.getCopy();
		getOwner().translateToAbsolute(referencePoint);
		return referencePoint;
	}

	@Override
	public Point getReferencePoint() {
		return getAdjustedReferencePoint();
	}

	public static WSAnchor getWSAnchorFor(Request request, IFigure figure) {
		WSAnchor anchor = new WSAnchor(figure);
		if (request instanceof LocationRequest) {
			Point location = ((LocationRequest) request).getLocation()
					.getCopy();
			PrecisionPoint point = new PrecisionPoint(location);
			figure.translateToRelative(point);
			anchor.setLocation(point);
		} else if (request instanceof CreateRequest) {
			Point location = ((CreateRequest) request).getLocation().getCopy();
			PrecisionPoint point = new PrecisionPoint(location);
			figure.translateToRelative(point);
			anchor.setLocation(point);
		}
		anchor.isForRequest = true;
		return anchor;
	}

	public static WSAnchor getWSAnchorFor(ConnectionEditPart connection,
			IFigure figure, boolean source) {
		WSAnchor anchor = new WSAnchor(figure);
		Point point = ((ConnectorEditPart) connection).getStartPoint();
		if (!source) {
			point = ((ConnectorEditPart) connection).getEndPoint();
		}
		PrecisionPoint pPoint = new PrecisionPoint(point);
		anchor.setLocation(pPoint);
		return anchor;
	}

	@Override
	public PrecisionPoint getRawReferencePoint() {
		return currentPoint;
	}

	@Override
	public Point getOrthogonalLocation(Point orthoReference) {
		if (isForRequest) {
			// do not update if for a request
			//return getAdjustedReferencePoint();
		}
		// adjust the x or y depending on the direction of the
		// line
		PrecisionPoint preciseOrthoRef = new PrecisionPoint(orthoReference);
		getOwner().translateToRelative(preciseOrthoRef);
		PrecisionPoint copy = new PrecisionPoint(currentPoint.getCopy());
		PrecisionRectangle bounds = new PrecisionRectangle(FigureUtilities
				.getAnchorableFigureBounds(getOwner()));
		bounds.expand(0.000001, 0.000001);
		if (preciseOrthoRef.preciseX >= bounds.preciseX
				&& preciseOrthoRef.preciseX <= bounds.preciseX
						+ bounds.preciseWidth) {
			// vertical
			copy.preciseX = preciseOrthoRef.x;
			copy.updateInts();
		} else if (preciseOrthoRef.preciseY >= bounds.preciseY
				&& preciseOrthoRef.preciseY <= bounds.preciseY
						+ bounds.preciseHeight) {
			// horizontal
			copy.preciseY = preciseOrthoRef.y;
			copy.updateInts();
		}
		getOwner().translateToAbsolute(copy);
		return copy;
	}
}
