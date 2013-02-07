---

Copyright 2012-2013 xtUML.org

---

xtUML Project Implementation Note
Share ui.graphics plug-in


1. Abstract
-----------
This note describes the work that was done to share the 
com.mentor.nucleus.bp.ui.graphics plug-in in the github xtuml/editor repository
as open source software.

2. History
----------
None.

3. Document References
----------------------
[1] Issues 1 <http://github.com/xtuml/editor/issues/1>  

4. Background
-------------
Mentor Graphics is taking steps to release the BridgePoint Model Editor source
code as Open Source Software.  The ui.graphics plug-in is a good first candidate
to release as it has few dependencies and the code base is not huge.

5. Requirements
---------------
5.1  Apply the following "Apache license blurb" to the files (both source and
  support files) in the plug-in:
  
    © 2013 Mentor Graphics Corporation
    Licensed under the Apache License, Version 2.0 (the "License"); you may not
    use this file except in compliance with the License.  You may obtain a copy 
    of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
    License for the specific language governing permissions and limitations under
    the License.  
  
5.2  Remove the existing copyright line from files in the plug-in that have it.
  The Apache blurb from 5.1 asserts the desired copyright.  Existing copyright
  lines that exert "All rights reserved" for Mentor Graphics or Project 
  Technology are no longer correct.  
  
5.3  Add the updated plug-in source code to the github xtuml/editor repository.  

6. Work Required
----------------
6.1. Create tool to automatically apply the license and copyright changes.  
6.1.1  The tool is committed to the CVS HEAD version of the plug-in
  com.mentor.nucleus.bp.internal.tools.  It is named 
  "convert_to_apache_license.xml".  
6.1.2  The tool contains a README section in the comments at the beginning of 
  the file.  The comments describe how to run the tool and the limitations of
  its functionality.  
6.1.3  The tool is capable of finding and removing the existing copyright line.  
6.1.4  The tool is also able to apply the Apache license blurb to source code.  
    
6.2. After the changes were made to the branch version of the plug-in in CVS, 
  the updated code was copied into a workspace tied to the github repository and
  the software was uploaded to github.  The CVS branch is not going to be
  promoted to HEAD at this time.  
  

7. Implementation Comments
--------------------------
None.

8. Unit Test
------------
8.1  The non-case-sensitive string "all rights reserved" does not exist in the 
  plug-in code that is put on github.
  
9. Code Changes
---------------
Branch name: CVS R3_6_3-SKB-943313
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics/
    Activator.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics/
    IGraphicalHelpContextIds.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/AddToLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/CanvasCopyAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/CanvasCutAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/CanvasPasteAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/DeleteLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/DynamicLayersContributionItem.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/EditHiddenLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/GraphicalActionConstants.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/GraphicsActionBarContributor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/
    GraphicsZoomComboContributionItem.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/HideLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/NewLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/OpenGraphicsEditor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/RemoveFromLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/RenameLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/RestoreDefaultFillColorAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/RestoreDefaultLineColorAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/SetCustomFillColorAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/SetCustomLineColorAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/SetFontAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/SetObliqueRoutingAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/SetRectilinearRoutingAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/SetSystemColorAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/ShowLayerAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/ToggleGridSnapAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/ToggleGridViewAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/ZoomPageRetargetAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.actions/ZoomSelectionRetargetAction.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.anchors/ConnectorAnchor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.anchors/
    IAdjustableReferencePointAnchor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.anchors/ShapeAnchor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.anchors/ShapeSlidableAnchor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.anchors/WSAnchor.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/
    ConnectorBendpointCreateCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/
    ConnectorBendpointDeleteCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/
    ConnectorBendpointMoveCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/ConnectorMoveCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/CreateConnectionCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/GraphicalCloneCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/IExecutionValidationCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/IValidateDeltaCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/ShapeCreationCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/ShapeSetConstraintCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/StartConnectionCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.commands/
    UpdateEndPointLocationCommand.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.decorations/
    ConnectorEllipseDecoration.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.decorations/
    ConnectorPolygonDecoration.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.decorations/
    ConnectorPolylineDecoration.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.decorations/
    ConnectorSemiCircleDecoration.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.decorations/TooltipDecoration.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.draw/
    GraphicsGCDelegate.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.draw/
    PrecisionBendpoint.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    CanvasDummyIFile.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    GraphicalCommandStack.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    GraphicalEditDomain.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    GraphicalEditor.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    GraphicalEditorFactory.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    GraphicalEditorInput.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    IEditorTabFactory.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    ModelEditor.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.editor/
    SimpleGraphicalEditorInput.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.factories/AdapterFactory.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.factories/ConnectorCreationFactory.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.factories/ShapeCreationFactory.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.figures/DecoratedPolylineConnection.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.figures/GraphicsFreeformLayeredPane.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.figures/GraphicsViewport.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.figures/OffsetImageFigure.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.figures/ShapeImageFigure.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.handles/
    SnappingBendpointCreationHandle.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.handles/SnappingBendpointMoveHandle.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.handles/
    SnappingConnectionEndPointHandle.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layers/
    DefaultLayer.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layers/
    LayerUtils.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layers/
    UserDefinedConnectionLayer.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layers/
    UserDefinedLayer.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layout/
    ContainerXYLayout.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layout/
    FixedTextLocator.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layout/
    FloatingTextLocator.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layout/
    ShapeTextLayout.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.layout/
    XYDelegatingLayout.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.listeners/GraphicalPasteListener.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.listeners/GraphicsEditorListener.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.listeners/
    GraphicsModelTransactionListener.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.outline/GraphicalOutlinePage.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.palette/
    GraphicsConnectionCreationToolEntry.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.palette/GraphicsCreationToolEntry.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.palette/ZoomToolEntry.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    ConnectorEditPart.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    DiagramEditPart.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    GraphicalEditPartFilter.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    GraphicalZoomManager.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    GraphicsEditPartFactory.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    GraphicsScalableFreeformEditPart.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    ShapeEditPart.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.parts/
    TextEditPart.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/ConnectionPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/ConnectorBendPointEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/ConnectorEndpointEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/
    ConnectorGraphicalNodeEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/ConnectorMoveEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/ContainerXYLayoutPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/
    FreeFloatingGraphicalNodeEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/
    GraphicsConnectionLineSegPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/GraphicsXYLayoutPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/ShapeGraphicalNodeEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.policies/TextResizableEditPolicy.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.preferences/
    GraphicalEditorPreferences.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.print/
    PrintDiagramOperation.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.properties/
    GraphicsPropertySourceProvider.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.providers/
    CanvasEditorContextMenuProvider.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.requests/
    ConnectorEditPartChangeBoundsRequest.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.requests/
    GraphicsConnectionCreateRequest.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.requests/GraphicsCreateRequest.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.requests/
    TextEditPartChangeBoundsRequest.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.router/
    BendpointConnectionRouter.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.router/
    RectilinearRouter.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.router/
    Routing.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.selection/GraphicalSelectionManager.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.tools/
    GraphicalPanningSelectionTool.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.tools/
    GraphicalZoomTool.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.tools/
    GraphicsConnectionCreationTool.java
com.mentor.nucleus.bp.ui.graphics/src/com.mentor.nucleus.bp.ui.graphics.tools/
    GraphicsCreationTool.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.trackers/ConnectorEditPartDragTracker.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.trackers/GraphicalMarqueeDragTracker.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.trackers/SnappingBendpointTracker.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.trackers/
    SnappingConnectionEndpointTracker.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.trackers/TextDragEditPartsTracker.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.trackers/TextResizeTracker.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.utilities/ClientUtil.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.utilities/ElementMap.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.utilities/GraphicsUtil.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.utilities/PointUtilities.java
com.mentor.nucleus.bp.ui.graphics/src/
    com.mentor.nucleus.bp.ui.graphics.utilities/TextUtilities.java
com.mentor.nucleus.bp.ui.graphics/Settings/org.eclipse.jdt.core.prefs
com.mentor.nucleus.bp.ui.graphics/contexts/contexts.xml
com.mentor.nucleus.bp.ui.graphics/.classpath
com.mentor.nucleus.bp.ui.graphics/.project
com.mentor.nucleus.bp.ui.graphics/about.html
com.mentor.nucleus.bp.ui.graphics/generate.xml
com.mentor.nucleus.bp.ui.graphics/plugin.xml

Branch: CVS HEAD
com.mentor.nucleus.bp.internal.tools/convert_to_apache_license.xml

End
---

