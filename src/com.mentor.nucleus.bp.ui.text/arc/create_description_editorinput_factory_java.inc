.//=====================================================================
.//
.// File:      $RCSfile: create_description_editorinput_factory_java.inc,v $
.// Version:   $Revision: 1.11 $
.// Modified:  $Date: 2013/01/10 23:20:52 $
.//
.// (c) Copyright 2005-2014 by Mentor Graphics Corp. All rights reserved.
.//
.//=====================================================================
.// Licensed under the Apache License, Version 2.0 (the "License"); you may not
.// use this file except in compliance with the License.  You may obtain a copy
.// of the License at
.//
.//      http://www.apache.org/licenses/LICENSE-2.0
.//
.// Unless required by applicable law or agreed to in writing, software
.// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
.// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the
.// License for the specific language governing permissions and limitations under
.// the License.
.//=====================================================================
.//
.// This archetype is responsible for creating the DescriptionEditorInput.java
.// file for com.mentor.nucleus.bp.ui.text.
.//
.//
.//
.// ------------------------------------------------------------
.// Main code
.// -------------------------------------------------------------
.//
.//
.assign package_name = "com.mentor.nucleus.bp.ui.text.description"
.assign input_class_name = "DescriptionEditorInputFactory"
//======================================================================
//
// File: ${package_name}/${input_class_name}.java
//
// WARNING:      Do not edit this generated file
// Generated by: ${info.arch_file_name}
// Version:      $$Revision: 1.11 $$
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================
//
// This class handles the input to the Description text editors.
//
package ${package_name};

import java.util.List;
import java.util.Vector;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.ui.text.AbstractModelElementEditorInputFactory;

public class ${input_class_name} extends AbstractModelElementEditorInputFactory{
	public static final String PLACEHOLDER_EXTENSION = "dsc"; //$$NON-NLS-1$$

	private static List supportedList = null;
	
	protected List getSupportedModelElementList() {
		if(supportedList == null){
			supportedList = new Vector();
			.for each model_class in dsc_object_set
	            .invoke result = get_class_name(model_class)
	            .assign classname = result.body
	        supportedList.add("com.mentor.nucleus.bp.core.${classname}"); //$$NON-NLS-1$$
	        .end for
		}
		return supportedList;
	}
	
	public String getType() {
		return PLACEHOLDER_EXTENSION;
	}
	
	public Class getEditorInputClass() {
		return DescriptionEditorInput.class;
	}

	public NonRootModelElement getEditableModelElement(NonRootModelElement modelElement) {
	   .invoke forward_nav = generate_forward_chains(dsc_source_set)
	   ${forward_nav.body}
		return null;
	}
	
	public NonRootModelElement getRequiredModelElement(NonRootModelElement modelElement){
	   .invoke backward_nav = generate_backward_chains(dsc_source_set)
	   ${backward_nav.body}
		return null;
	}
	
	static ${input_class_name} defaultInstance;
	public static ${input_class_name} getDefaultInstance(){
	    if(defaultInstance == null){
	        defaultInstance = new ${input_class_name}();
	    }
	    return defaultInstance;
	}
}
.//
.//
.emit to file "src/com/mentor/nucleus/bp/ui/text/description/${input_class_name}.java"
