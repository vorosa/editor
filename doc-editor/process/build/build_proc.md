# Multi-Component Build Process

## Abstract

This document provides step-by-step instructions for creating a target
runnable build image from xtUML models and hand-craft realized C code.

## Prerequisites

### Tools

## Code Generation

1.  Using git or EGit (or other configuration management, import all
of the projects in the *models* folder into a workspace.
2.  Generate code for the component projects (all but _shared_ and _deployment_).
From the C/C++ perspective,
select all of the projects (shift-right-click) and then deselect _shared_
and _deployment_.  Then, right-click > Build Project.
Alternatively, generate the code by running the gen\_code.sh shell
script in the models folder.  Be sure to edit the BridgePoint\_CLI.bat
file and set the workspace to point to the proper place.

### The Models

Projects with tens of components split into tens of projects can be
translated using this technique.
Each of the larger modeled components resides in its own standalone project.
Components representing realized code kept separate from projects
containing xtUML modeled components.
"Library" modules are modeled as external entities and are copied
into the projects that need them.  Alternatively, these EEs can be
packaged into component shells at the cost of modeling their interfaces.

There are two special projects that serve to integrate the models into
a system.  _shared_ contains xtUML definitions of the interfaces and
data types shared by all components.  The elements in this project are
referenced from the other model projects.  This allows one fact to be 
modeled in one place.  Syntactic checking occurs between components
that are sharing in interface and data types.
The second special project is _deployment_.  This project contains a component
reference diagram with interfaces wired together.

### Large Model Considerations

The above organization of projects is good practice (even "best practice").
It allows each component to be carefully modeled and tested using unit test
components and "testbenching".  (Testbenching is documented in a testbenching
project on github and in videos on the xtUML Youtube Channel.)

For very large models, this prescribed project organization enables a 
work-around to scale code generation beyond exsting technology that exist
using the heritage gen_erate.exe application.  (Memory usage is limited
to 4GB in gen_erate.exe.)

Follow these steps:
- In all projects, add a mark to give your system a consistent name
in each component project and in the deployment project.  In system.mark,
add the following query:
```SQL
	.select many s_syss from instances of S_SYS
	.for each s_sys in s_syss
		.assign s_sys.Name = "SYS"
	.end for
```
- In each of the component projects, mark the wiring of the ports in
the "home component" to the ports in the "foreign components" to which
it communicates across interfaces.  For example, in domain.mark:
```
.invoke MarkPortWiring( "one" "Port1" "two" "Port1" )
```
(Note, a combined marking for the ports of the entire system can exist
in each of the component projects.  A superset of port markings
will not interfere the code generation for a single model.)
- Edit q.component.arc to enable the code generation scaling feature.
Search for "CDS".  Two sections of code will be marked with this comment.
In these two places, enable the _if_ statement by matching your project
name (or skipping the project name test).
- Generate code for each component project.  Note that the *MarkPortWiring*
mark will add #include statements that will render the component project
code uncompilable.  Use this mark only for the full integration generation.
- Edit xtumlmc_build.exe and omit the V_* and ACT_* instances from
the code generation.  Do this by changing the lines:
```
	if ( ! ( ( /^INSERT INTO ACT_/ ) ||
```
and this line
```
	( /^INSERT INTO V_/ ) ||
```
to
```
	if ( ! ( ( /^INSERT INTO xxxACT_/ ) ||
```
and
```
	( /^INSERT INTO xxxV_/ ) ||
```
- Add markings to the deployment project to keep the event queues
that your project needs.
```
	.invoke TagMaximumSelfDirectedEvents( 5 ) 
	.invoke TagMaximumNonSelfDirectedEvents( 5 )
```
- Generate code for the _deployment_ model.
- Copy the source code from each of the component projects into
the *src* folder of the _deployment_ project.  Copy all of the
"component" and "class" files.  In other words, copy the application
code but not the "sys_*" files.


## Integration of Generated with Realized Code


