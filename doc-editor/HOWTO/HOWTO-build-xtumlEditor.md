HOWTO Build xtUML Editor (using xtUML Editor)
----------------------------------------------
Note: Prior to using this checklist you should already have an account
      on github.
	  
_- Download the latest released version of the xtUML Editor.  You will find all the releases here:
   https://www.xtuml.org/download/

_- Run the installer down-loaded in the previous step.  You can install
   wherever you like, but these instructions assume the default: c:/MentorGraphics/xtUML Editor
   
_- Launch the tool using the desktop shortcut that was created and open a new eclipse workspace that will become your development workspace.
      Example:  c:/workspace/xtuml_editor
	  
_- Install required add-ons:
  _- Open the Navigator view
  _- Right-click in white space
  _- Import... > Install > Install Software Items from File
  _- Select "git"/internal/doc-internal/process/templates/checklists/development-workspace-setup/xtUML_dev_eclipse_addons.p2f
  _- Select Finish
  _R Files are installed and you are prompted to restart. Do NOT restart
  	  
_- Select the option to clone and add to view:
   URI: https://github.com/xtuml/editor.git
  _- Enter your user name and password
  _- Select Next
  _- Select all the branches
  _- Select Next
  _- For the Local Destination select your github/repos folder.
     NOTE: DO NOT SELECT YOUR WORKSPACE!  This is the local RCS repository.
  _- Select Finish.
  
_- Import the projects into your workspace
  _- In the Git Repository Exploring perspective select "editor"
  _- Right Click > Import Projects...
  _- Select "Import Projects Into Existing Workspace" and then "Next"
  _- Select all projects (do not select any other options)
  _- Ensure "Search for nested projects" is UNchecked.
  _- Select Finish
   
_- Switch to the Java perspective

_- Select Project > Build Automatically

_R The build is successful

_- Prepare to run unit tests:
  _- Exit BridgePoint
    _- Configure Windows Vista or Windows 7 for unit test running
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
  _- Launch BridgePoint

_- Setup development environment to run MC3020 under a launch configuration
  _- Open Windows explorer and navigate to the BridgePoint plug-in 
     installation folder.  The default is:
     C:\MentorGraphics\BridgePoint\eclipse_extensions\BridgePoint\eclipse\plugins\com.mentor.nucleus.bp.mc.c.binary_"ver"\mc3020
  _- Select all files and folders in the above folder
  _- Select Copy
  _- Open the Model Explorer view in Eclipse and navigate to:
       /com.mentor.nucleus.bp.mc.c.binary/mc3020
  _- Paste the previous selection into this folder

_- Set the unit test history to assure the test summary tool capture all results
   _- Open the Junit view
   _- Select the drop-down arrow in the upper-right of the view
   _- Select the History... option
   _- Set "Maximum count of remembered test runs" to 30 
    
_R Your environment is now built and ready for unit testing.
