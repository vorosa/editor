package com.mentor.nucleus.bp.ui.graphics.policies;
//=====================================================================
//
// File:      $RCSfile: ConnectorEndpointEditPolicy.java,v $
// Version:   $Revision: 1.2.164.1 $
// Modified:  $Date: 2013/01/29 22:08:31 $
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.handles.ConnectionEndpointHandle;
import org.eclipse.gef.requests.ReconnectRequest;

import com.mentor.nucleus.bp.ui.graphics.anchors.WSAnchor;
import com.mentor.nucleus.bp.ui.graphics.handles.SnappingConnectionEndPointHandle;

public class ConnectorEndpointEditPolicy extends ConnectionEndpointEditPolicy {

	private int fPreviousLineWidth = 0;

	public ConnectorEndpointEditPolicy(int configuredLineWidth) {
		fPreviousLineWidth = configuredLineWidth;
	}

	@Override
	protected List<?> createSelectionHandles() {
		fPreviousLineWidth = ((PolylineConnection) getHostFigure())
				.getLineWidth();
		if (fPreviousLineWidth == 0) {
			((PolylineConnection) getConnection()).setLineWidth(2);
		} else {
			((PolylineConnection) getConnection())
					.setLineWidth(fPreviousLineWidth * 2);
		}
		List<ConnectionEndpointHandle> list = new ArrayList<ConnectionEndpointHandle>();
		list.add(new SnappingConnectionEndPointHandle(
				(ConnectionEditPart) getHost(), ConnectionLocator.SOURCE));
		list.add(new SnappingConnectionEndPointHandle(
				(ConnectionEditPart) getHost(), ConnectionLocator.TARGET));
		return list;
	}

	@Override
	protected void removeSelectionHandles() {
		super.removeSelectionHandles();
		((PolylineConnection) getConnection()).setLineWidth(fPreviousLineWidth);
	}

	@Override
	protected void showConnectionMoveFeedback(ReconnectRequest request) {
		super.showConnectionMoveFeedback(request);
		if (request.getTarget() == null) {
			// never use the host figure as that will cause
			// an infinite loop
			WSAnchor anchor = WSAnchor.getWSAnchorFor(request, getHostFigure()
					.getParent());
			getFeedbackHelper(request).update(anchor, null);
		}
	}

}
