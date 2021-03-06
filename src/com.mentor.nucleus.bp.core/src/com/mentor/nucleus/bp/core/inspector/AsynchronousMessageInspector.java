package com.mentor.nucleus.bp.core.inspector;
//======================================================================
//
// File: com/mentor/nucleus/bp/core/inspector/AsynchronousMessageInspector.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/create_object_inspector.inc
// Version:      $Revision: 1.23 $
//
// (c) Copyright 2004-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================
//
// This class is responsible for decoupling the client model entity
// class AsynchronousMessage_c from the traversal mechanisms that it provides to
// model diff.
//
import com.mentor.nucleus.bp.core.*;

import org.eclipse.swt.graphics.Image;

import com.mentor.nucleus.bp.core.sorter.MetadataSortingManager;
import java.util.*;

/**
 * This file adapts the meta-model entity; 'AsynchronousMessage_c' to provide 
 * support of traversing to its children and parents.
 * <p>
 * Do not edit this class, it was created using the Mentor Graphics
 * MC-Java code generator product.
 * </p>
 */
public class AsynchronousMessageInspector extends BaseModelClassInspector {

  private String parentAssoc;
  
  public AsynchronousMessageInspector(MetadataSortingManager sortingManager){
    super(sortingManager);
  }

  /**
   * @see IModelClassInspector#getParent(Object)
   * Returns the parent(s) of this node
   */
  public Object getParent(Object arg) {
    ClassInstanceParticipant_c result1 = ClassInstanceParticipant_c.getOneSQ_CIPOnR930(InteractionParticipant_c.getOneSQ_POnR1007(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result1 != null) {
        return result1;
    }               
    PackageParticipant_c result2 = PackageParticipant_c.getOneSQ_PPOnR930(InteractionParticipant_c.getOneSQ_POnR1007(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result2 != null) {
        return result2;
    }               
    ClassParticipant_c result3 = ClassParticipant_c.getOneSQ_CPOnR930(InteractionParticipant_c.getOneSQ_POnR1007(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result3 != null) {
        return result3;
    }               
    Lifespan_c result4 = Lifespan_c.getOneSQ_LSOnR930(InteractionParticipant_c.getOneSQ_POnR1007(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result4 != null) {
        return result4;
    }               
    ComponentParticipant_c result5 = ComponentParticipant_c.getOneSQ_COPOnR930(InteractionParticipant_c.getOneSQ_POnR1007(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result5 != null) {
        return result5;
    }               
    Communication_c result6 = Communication_c.getOneCOMM_COMMOnR1135(MessageInCommunication_c.getOneCOMM_MICOnR1135(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result6 != null) {
        return result6;
    }               
    Package_c result7 = Package_c.getOneEP_PKGOnR8000(PackageableElement_c.getOnePE_PEOnR8001(Message_c.getOneMSG_MOnR1018((AsynchronousMessage_c)arg)));
     if (result7 != null) {
        return result7;
    }               
        return null;    //No parent found           
  }
  	  
  /**
   * @see IModelClassInspector#getChildRelations(Object)
   * Returns the children of this node
   */
  public ObjectElement[] getChildRelations(Object arg) {
    int resultSize = 0;
    MessageArgument_c [] v_informalmessagearguments = 
MessageArgument_c.getManyMSG_AsOnR1013(
InformalArgument_c.getManyMSG_IAsOnR1013(
MessageArgument_c.getManyMSG_AsOnR1000(
Message_c.getManyMSG_MsOnR1018(
(AsynchronousMessage_c)arg)
)
)
)
;



    sort(v_informalmessagearguments);
    MessageArgument_c [] v_messagearguments = 
MessageArgument_c.getManyMSG_AsOnR1001(
Message_c.getManyMSG_MsOnR1018(
(AsynchronousMessage_c)arg)
)
;



    sort(v_messagearguments);
    List<ObjectElement> result = new ArrayList<ObjectElement> ();
    for (int i = 0 ; i < v_informalmessagearguments.length ; i++) {   
        result.add(new ObjectElement("v_informalmessagearguments", ObjectElement.RELATION_ROLE_ELEMENT, v_informalmessagearguments[i], arg, false));
    }
    for (int i = 0 ; i < v_messagearguments.length ; i++) {   
        result.add(new ObjectElement("v_messagearguments", ObjectElement.RELATION_ROLE_ELEMENT, v_messagearguments[i], arg, false));
    }
    return result.toArray(new ObjectElement[result.size()]);
  }
  /**
   * @see IModelClassInspector#hasChildren(Object)
   * Returns true if this node has any children
   */
  public boolean hasChildRelations(Object arg) {
    MessageArgument_c [] v_informalmessagearguments = 
MessageArgument_c.getManyMSG_AsOnR1013(
InformalArgument_c.getManyMSG_IAsOnR1013(
MessageArgument_c.getManyMSG_AsOnR1000(
Message_c.getManyMSG_MsOnR1018(
(AsynchronousMessage_c)arg)
)
)
)
;



    if (v_informalmessagearguments.length > 0) return true;
    MessageArgument_c [] v_messagearguments = 
MessageArgument_c.getManyMSG_AsOnR1001(
Message_c.getManyMSG_MsOnR1018(
(AsynchronousMessage_c)arg)
)
;



    if (v_messagearguments.length > 0) return true;
    return false;
  }
  
  public Object[] getReferentialDetails(Class<?> referentialClass, Object arg) {
  	Object[] details = new Object[4];
	if(details[0] == null && referentialClass == InformalAsynchronousMessage_c.class) {
		details[0] = InformalAsynchronousMessage_c.getOneMSG_IAMOnR1019(
(AsynchronousMessage_c)arg)
;



;
		details[1] = arg;
		details[2] = "1019";
		details[3] = "";
	}
	if(details[0] == null && referentialClass == EventMessage_c.class) {
		details[0] = EventMessage_c.getOneMSG_EOnR1019(
(AsynchronousMessage_c)arg)
;



;
		details[1] = arg;
		details[2] = "1019";
		details[3] = "";
	}
	if(details[0] == null && referentialClass == SignalMessage_c.class) {
		details[0] = SignalMessage_c.getOneMSG_SIGOnR1019(
(AsynchronousMessage_c)arg)
;



;
		details[1] = arg;
		details[2] = "1019";
		details[3] = "";
	}
	return details;
  }
  
  /**
  * @seee IModelClassInspector#getReferentials(Object)
  * Returns the an array of Role Objects specifying the referenctial attibutes of
  * this model element
  * Role Name: <T_TPS.NameOnly>
  * Role Value: <Chain_result>
  * Role Type: "Referential"
  */
  public ObjectElement[] getReferentials(Object arg) {
     List<ObjectElement> referentials = new ArrayList<ObjectElement>();
        Object referential = InformalAsynchronousMessage_c.getOneMSG_IAMOnR1019(
(AsynchronousMessage_c)arg)

;
    if(!(referential == null)) {
     referentials.add(new ObjectElement ("referential_Informal_Message", ObjectElement.REFERENTIAL_ATTRIBUTE_ELEMENT, referential, arg, false));
    }
        referential = EventMessage_c.getOneMSG_EOnR1019(
(AsynchronousMessage_c)arg)

;
    if(!(referential == null)) {
     referentials.add(new ObjectElement ("referential_Formal_Event", ObjectElement.REFERENTIAL_ATTRIBUTE_ELEMENT, referential, arg, false));
    }
        referential = SignalMessage_c.getOneMSG_SIGOnR1019(
(AsynchronousMessage_c)arg)

;
    if(!(referential == null)) {
     referentials.add(new ObjectElement ("referential_Formal_Signal_Event", ObjectElement.REFERENTIAL_ATTRIBUTE_ELEMENT, referential, arg, false));
    }
    return referentials.toArray(new ObjectElement [referentials.size()]);        
  }

  /**
  * @seee IModelClassInspector#getAttributes(Object)
  * Returns the an array of Role objects that give the attibutes of the model 
  * element it self e.g.
  * Role Name: "Name"
  * Role Value: metaModelElement.getName()
  * Role Type: "Primitive"
  */
  public ObjectElement[] getAttributes(Object arg) {
    ObjectElement attrSet[] = new ObjectElement[9];
      attrSet[0] = new ObjectElement("InformalName", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getInformalname"), arg, "getInformalname", true);
      attrSet[1] = new ObjectElement("Descrip", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getDescrip"), arg, "getDescrip", true);
      attrSet[2] = new ObjectElement("GuardCondition", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getGuardcondition"), arg, "getGuardcondition", true);
      attrSet[3] = new ObjectElement("DurationObservation", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getDurationobservation"), arg, "getDurationobservation", true);
      attrSet[4] = new ObjectElement("DurationConstraint", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getDurationconstraint"), arg, "getDurationconstraint", true);
      attrSet[5] = new ObjectElement("isFormal", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getIsformal"), arg, "getIsformal", true);
      attrSet[5].setDerived();
      attrSet[6] = new ObjectElement("SequenceNumb", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getSequencenumb"), arg, "getSequencenumb", true);
    ObjectElement compAttrSet[] = new ObjectElement[7];    
    for (int i = 0; i < 7 ; i++) {
        compAttrSet[i] = attrSet[i];
    }
    return compAttrSet;
  }

    /**
     * Return configured image if none exists for the element type
     */
    public Image getImage(Object element) {
		Image image = CorePlugin.getImageFor(element, false);
		if(image != null) {
			return image;
		}
		return CorePlugin.getImageFor("AsynchronousMessage.gif");
	}
    }       

