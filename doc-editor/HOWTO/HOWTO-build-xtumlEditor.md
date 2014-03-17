HOWTO Build xtUML Editor (using xtUML Editor)
----------------------------------------------
Note: Prior to using this checklist you should already have an account
      on github.  
	  
- Download the latest released version of the xtUML Editor.  You will find all the releases here: https://www.xtuml.org/download/

- Run the installer down-loaded in the previous step.  You can install wherever you like, but these instructions assume the default: c:/MentorGraphics/xtUML Editor
   
- Launch the tool using the desktop shortcut that was created and open a new eclipse workspace that will become your development workspace.  _Example:  c:/workspace/xtumlEditor_ 
	  
- Install required add-ons:
  - Open the Navigator view
  - Right-click in white space
  - Import... > Install > Install Software Items from File
  - Select ```"git"/internal/doc-internal/process/templates/checklists/development-workspace-setup/xtUML_dev_eclipse_addons.p2f```
  - Select Finish
  - Files are installed and you are prompted to restart. Restart.
  	  
- Select the option to clone and add to view:  ```URI: https://github.com/xtuml/editor.git```
  - Enter your user name and password
  - Select Next
  - Select all the branches
  - Select Next
  - For the Local Destination select your desired github/repos folder location. __NOTE: DO NOT SELECT YOUR WORKSPACE!  This is the local RCS repository.__
  - Select Finish
  
- Import the projects into your workspace
  - In the Git Repository Exploring perspective select "editor"
  - Right Click > Import Projects...
  - Select "Import Projects Into Existing Workspace" and then "Next"
  - Select all projects (do not select any other options)
  - Ensure "Search for nested projects" is UNchecked.
  - Select Finish
   
- Switch to the Java perspective

- Select Project > Build Automatically
  - __Result:__ The build is successful

- Prepare to run unit tests (on MS Windows):
  - Exit BridgePoint
  - Configure Windows Vista or Windows 7 for unit test running

```
      - Bring up the Windows Color and Appearance settings
        - Right click on the desktop background and select Personalize
        - In Vista select the Windows Color and Appearance hyperlink
        - In Windows 7 select the Windows Color hyperlink
        - In the window that appears, change the following attributes:
          - Active Title Bar    Size: 25 Font: Trebuchet 10
          - Border Padding      Size: 0
          - Caption Buttons     Size: 25
          - Icon                Size: 32 Font: Tahoma 8
          - Inactive Title Bar  Size: 25 Font: Trebuchet 10
          - Menu                Size: 19 Font: Tahoma 8
          - Message Box                  Font: Tahoma 8
          - Palette Title       Size: 17 Font: Tahoma 8
          - Selected Items      Size: 19 Font: Tahoma 8
          - Tooltip                      Font: Tahoma 8
        - If you have a smaller screen or resolution potential you may need to
          configure the start menu to not always be on top, or set it to auto-hide.
        - Note: Do NOT use the Windows setting that scaling text to make it easier to see. 
              This setting, in Windows 7, is found here:
              Personalize > Display > "Make it easier to read what is on your machine"
              That setting must be set to "smaller" 100%
              It is is adjusted your graphical compare restuls will not match,
```

  - Launch BridgePoint

- Set the unit test history to assure the test summary tool capture all results
  - Open the Junit view
  - Select the drop-down arrow in the upper-right of the view
  - Select the History... option
  - Set "Maximum count of remembered test runs" to 30 
    
- __Result:__ Your environment is now built and ready for unit testing.
