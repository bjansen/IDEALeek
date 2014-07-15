IntelleekJ
==========

This plugin adds support for the LeekScript language in IntelliJ (see [http://leekwars.com](http://leekwars.com)).

Features
========

* New file type (*.lks)
* Basic lexer/parser (error recovery can be enhanced though)
* Syntax highlighting, find usages, brace matching, code folding, structure view, code commenting
* Retrieve functions, weapons and chips from LeekWars and aggregate them in a special script named `leekwars-api.lks`
* Code completion

Planned features
================
* Import/save scripts from/to leekwars.com
* "Include" a file into another (for example to share code between team members)
* Javadoc-like popup (very limited at the moment)
* Save `leekwars-api.lks` into a `gen` source root, so that user scripts can have arbitrary hierarchies

Current limitations
===================

* All scripts should be placed in the same directory, otherwise declarations from `leekwars-api.lks` won't be found.
* Most of the data exchanged with the LeekWars server was deduced by reverse engineering, no official API is exposed, so changes on the server may require a new version of this plugin.