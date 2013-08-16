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


## Integration of Generated with Realized Code
