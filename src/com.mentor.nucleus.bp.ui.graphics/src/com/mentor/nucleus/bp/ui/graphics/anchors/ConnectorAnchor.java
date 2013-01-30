//========================================================================
//
//File:      $RCSfile: ConnectorAnchor.java,v $
//Version:   $Revision: 1.8.12.2 $
//Modified:  $Date: 2013/01/29 22:08:48 $
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

import java.util.List;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OrthogonalConnectionAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;

import com.mentor.nucleus.bp.core.End_c;

public class ConnectorAnchor extends AbstractConnectionAnchor implements
		IAdjustableReferencePointAnchor, OrthogonalConnectionAnchor {

	private int end;
	private PrecisionPoint referencePoint;
	private boolean isForRequest;

	public ConnectorAnchor(IFigure owner, int end, boolean source,
			PrecisionPoint referencePoint, boolean isForRequest) {
		super(owner);
		this.end = end;
		this.referencePoint = referencePoint;
		this.isForRequest = isForRequest;
	}

	Figure figure = new Figure() {

		private Rectangle rectangleBounds = new Rectangle();

		@Override
		public Rectangle getBounds() {
			Point point = null;
			PointList points = ((Connection) ConnectorAnchor.super.getOwner())
					.getPoints();
			if (end == End_c.End) {
				point = points.getLastPoint().getCopy();
			} else if(end == End_c.Start){
				point = points.getFirstPoint().getCopy();
			} else {
				// return the bounds of the nearest segment
				long distance = Integer.MAX_VALUE;
				LineSeg segOver = null;
				List<?> lineSegments = PointListUtilities.getLineSegments(points);
				for(Object seg : lineSegments) {
					LineSeg lineSeg = (LineSeg) seg;
					if(lineSeg.containsPoint(referencePoint, 1)) {
						segOver = lineSeg;
						break;
					}
				}
				if(segOver == null) {
					for(Object seg : lineSegments) {
						LineSeg lineSeg = (LineSeg) seg;
						long thisDistance = lineSeg.distanceToPoint(referencePoint.x, referencePoint.y);
						if(thisDistance < distance) {
							distance = thisDistance;
							segOver = lineSeg;
						}
					}
				}
				PointList segmentPoints = new PointList();
				segmentPoints.addPoint(segOver.getOrigin());
				segmentPoints.addPoint(segOver.getTerminus());
				return segmentPoints.getBounds();
			}
			rectangleBounds.setLocation(point);
			rectangleBounds.setSize(1, 1);
			return rectangleBounds;
		}

		@Override
		public void paint(Graphics graphics) {
			// do not paint
		}
		
	};
	
	@Override
	public IFigure getOwner() {
		// return an invisible figure, that is the point of the end or start
		// of the attached to connector. Unless this is anchoring to the middle.
		if(figure.getParent() == null) {
			figure.setParent(super.getOwner());
		}
		return figure;
	}

	@Override
	public Point getLocation(Point reference) {
		Point referenceCopy = reference.getCopy();
		getOwner().translateToRelative(referenceCopy);
		PrecisionPoint point = null;
		PointList points = ((Connection) super.getOwner()).getPoints();
		if (end == End_c.End) {
			// use end anchor point
			point = new PrecisionPoint(points.getLastPoint());
		} else if (end == End_c.Start) {
			// use start anchor point
			point = new PrecisionPoint(points.getFirstPoint());
		} else {
			point = getIntersectionPointWithPoints(referencePoint,
					referenceCopy, points);
		}
		getOwner().translateToAbsolute(point);
		return point;
	}

	public static PrecisionPoint getIntersectionPointWithPoints(
			Point referencePoint, Point reference, PointList points) {
		LineSeg segment = new LineSeg(referencePoint, reference);
		PointList intersections = segment
				.getLineIntersectionsWithLineSegs(points);
		Point point = null;
		if (intersections != null && intersections.size() > 0) {
			point = PointListUtilities.pickClosestPoint(intersections,
					reference);
		} else {
			// no intersection found, locate the nearest point
			// to the the connection's end
			double distance = Integer.MAX_VALUE;
			for (int i = 0; i < points.size(); i++) {
				Point temp = points.getPoint(i).getCopy();
				double tempDistance = temp.getDistance(referencePoint);
				if (tempDistance < distance) {
					point = temp;
					distance = tempDistance;
				}
			}
		}
		return new PrecisionPoint(point);
	}

	@Override
	public Point getReferencePoint() {
		PrecisionPoint translated = (PrecisionPoint) referencePoint.getCopy();
		getOwner().translateToAbsolute(translated);
		return translated;
	}

	@Override
	public PrecisionPoint getRawReferencePoint() {
		return referencePoint;
	}

	public Connection getConnection() {
		return (Connection) super.getOwner();
	}

	public int connectsAt() {
		return end;
	}

	@Override
	public Point getOrthogonalLocation(Point orthoReference) {
		if(connectsAt() == End_c.End) {
			return getLocation(orthoReference);
		}
		if(connectsAt() == End_c.Start) {
			return getLocation(orthoReference);
		}
		// if from a request do not move the point
		if(isForRequest) {
			return getReferencePoint();
		}
		// adjust the x or y depending on the direction of the
		// line
		PrecisionPoint preciseOrthoRef = new PrecisionPoint(orthoReference);
		getOwner().translateToRelative(preciseOrthoRef);
		PrecisionPoint copy = new PrecisionPoint(referencePoint.getCopy());
		PrecisionRectangle bounds = new PrecisionRectangle(FigureUtilities
				.getAnchorableFigureBounds(getOwner()));
		bounds.expand(0.000001, 0.000001);
		if (preciseOrthoRef.preciseX >= bounds.preciseX
				&& preciseOrthoRef.preciseX <= bounds.preciseX
						+ bounds.preciseWidth) {
			copy.preciseX = preciseOrthoRef.x;
			copy.updateInts();
		} else if (preciseOrthoRef.preciseY >= bounds.preciseY
				&& preciseOrthoRef.preciseY <= bounds.preciseY
						+ bounds.preciseHeight) {
			copy.preciseY = preciseOrthoRef.y;
			copy.updateInts();
		}
		PrecisionPoint intersectionPoint = getIntersectionPointWithPoints(copy,
				preciseOrthoRef, ((Connection) super.getOwner()).getPoints());
		getOwner().translateToAbsolute(intersectionPoint);
		return intersectionPoint;
	}

}
