HOWTO Build xtUML Editor (using xtUML Editor)
----------------------------------------------

### Setup
- Create an account on github (https://github.com)
	  
- Download the latest released version of the xtUML Editor from https://www.xtuml.org/download/

- Run the xtUML Editor installer
   
- Navigate to https://github.com/xtuml/editor/blob/master/doc-editor/development/workspace-config/xtUML_dev_eclipse_addons.p2f
  - Select "Raw" to open the file
  - Right-click on the file ```xtuml_dev_eclipse_addons.p2f``` and save it to disk.
    - Make sure that the file name extension is ".p2f"


### Configuration
- Launch xtuml Editor.  Enter the name of a new eclipse workspace that will become your development workspace. (_Example:  c:/workspaces/xtumlEditor_)

- Install required add-ons:
  - Open the Navigator view
  - Right-click in white space
  - Import... > Install > Install Software Items from File
  - Select ```xtUML_dev_eclipse_addons.p2f``` you saved to disk earlier
  - Select Finish
  - Files are installed and you are prompted to restart. Restart.
  	  
- Open Git Repository Exploring perspective.  Select the option to _Clone a Git repository_
  - URI: ```https://github.com/xtuml/editor.git```
  - Enter your user name and password
  - Select Next
  - Select all the branches
  - Select Next
  - For the Local Destination select your desired github/repos folder location. __NOTE: DO NOT SELECT YOUR WORKSPACE!  Store this local git repository outside your workspace.__   (_Example:  c:/git/xtuml/editor_)
  - Select Finish
  
- Import the projects into your workspace
  - In the Git Repository Exploring perspective select "editor"
  - Right Click > Import Projects...
  - Select "Import Projects Into Existing Workspace" and then "Next"
  - Select all projects (do not select any other options)
  - Ensure "Search for nested projects" is UNchecked.
  - Select Finish
   
- Open Git Repository Exploring perspective.  Select the button to _Clone a Git Repository and add the clone to this view_
  - Using the wizard as performed previously, clone ```https://github.com/xtuml/models.git``` to a local repository ( _Example:  c:/git/xtuml/models_)

- Open ```c:/MentorGraphics/xtUMLEditor/eclipse/Launcher.bat``` in a text editor
  - After the ```set BP_JVM=...``` line add the following (adjusted for your previously chosen repository locations)

```
set XTUML_TEST_MODEL_REPOSITORY=C:/git/xtuml/models/test/
set XTUML_DEVELOPMENT_REPOSITORY=C:/git/xtum/editor
```

- Prepare to run unit tests (on MS Windows):
  - Exit xtUML Editor
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
              
        It is recommended to save this modified theme to make it easier to switch back to 
        at a later time.
```

  - Launch xtUML Editor

- Set the unit test history to assure the test summary tool capture all results
  - Open the Junit view
  - Select the drop-down arrow in the upper-right of the view
  - Select the History... option
  - Set "Maximum count of remembered test runs" to 30 


### Build
- Switch to the Java perspective

- Select Project > Build Automatically
  - __Result:__ The build is successful.  The Problems view does not display any errors.
  - Note that the eclipse build will occasionally indicate problems with ```org.eclipse*``` imports not being found.  If this happens you can restart xtUML Editor and try building again and/or touch a file in bp.core by adding a space, removing it, and saving.


Congratulations.  Your environment is now built and ready for unit testing.
