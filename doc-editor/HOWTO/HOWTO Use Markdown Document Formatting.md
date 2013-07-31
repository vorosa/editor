HOWTO Use Markdown Document Formatting
======================================

We have adopted Markdown as a markup language for xtUML.org documentation.
This document is itself an example of what you can do with Markdown.  It started
out as a copy of <http://jeromyanglim.blogspot.com/2010/11/getting-started-with-markdown-benefits.html>
and has been expanded a bit.  This document discusses  
(a) the benefits of Markdown, 
(b) installing a Markdown editor,
(c) learning Markdown, and
(d) converting between formats.

Note that GitHub uses its own flavor of markdown that is slightly different than
standard markdown.  See <http://github.github.com/github-flavored-markdown/> for more info.


1. Overview
------------

Great features of Markdown are:

* It's plain text (e.g., support for version control, create with code)  
* It's simple to learn and use
* The source is highly readable (much more so than HTML or LaTeX; and arguably more so than other markup languages)
* It's quicker to type than HTML 
* It's easy to convert to other formats
* GitHub automatically formats Markdown formatted documents on the website
* HTML code can be interspersed when features such as tables are not supported 

It's not for everything, but it's a good tool for certain tasks. It has lots of
options, but works well for text or pretty formatting.


2. Installation
----------------
Technically, you don't need anything to use markdown.  Any text editor will work.

If you create your file and commit it to github, you can then edit it online.  The online editor includes a preview
button that will show you the redered version of the file.


3. Quick Examples
------------------

Headings that start with a pound sign are supported with syntax highlighting and
the Outline view of the Winterwell plug-in.
# H1
## H2
### H3

You can also make H1 and H2 headings by underlining with (at least 4) equals and dashes respectively:

H1
====

H2
----

---
Using only 3 dashes creates a line break, like this.  Note that when adding a line
break after text, you have to give an extra newline.  Otherwise it will format
like an H2.

---

You can call out a code block using 4 spaces by indenting four spaces:

    select any md from MARKDOWN
    if ( not_empty md)
      LOG::Log_Info(message: "Markdown is nifty");
    end if;

or using 3 backticks (and optionally specify the language to get syntax highlighting):

```java
public AddToLayerAction(String layerName, Model_c model) {
    this.layerName = layerName;
    this.model = model;
}
```

You can hyperlink easily and also create emphasis:

*single asterisks*

_single underscores_

**double asterisks**

__double underscores__

Another useful feature is creating block quotes by starting lines with the greater
than symbol:

> Here is a block quote.
> It sets this text off
> into a nice sub-item.


4. Other Resources
-----------------------
1. [GitHub Flavored Markdown][gfm]
2. [Markdown syntax guide][msg]

[msg]: http://daringfireball.net/projects/markdown/syntax
[gfm]: http://github.github.com/github-flavored-markdown/

3. You may also want to check out the Markdown Editor plug-in for Eclipse developed by Daniel Winterstein.
 
Cool features include:

* Outline View
* Syntax highlighting
* Markdown HTML Preview (`Window > Show View > Other > Markdown > Markdown HTML Preview`)
* Integration with Eclipse

Installation instructions can be found on the [winterwell] website.

[winterwell]: http://www.winterwell.com/software/markdown-editor.php 

Note, however, that this viewer only handles Standard Markdown, not Github-Flavored Markdown.  There are a number of
key differences between the two flavors, so your mileage may vary.  Personally, I found it to be too inconsistent and
quit using it.


5. Conversion
--------------
#### Markdown to HTML
Using the Eclipse Markdown plugin, a HTML version of the Markdown file
can be obtained in several ways.

* Right click the Markdown HTML Preview and click "View Source"
* When in the Markdown editor, go to `File > Export HTML`. 
  This creates a HTML version of the file

#### Other options
[Pandoc] appears to be a good option for converting between document 
formats such as Markdown, LaTeX, RTF, PDF, OpenDocument, and more. 

[pandoc]: http://johnmacfarlane.net/pandoc/


