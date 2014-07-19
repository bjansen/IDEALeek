IntelleekJ
==========

This plugin adds support for the LeekScript language in IntelliJ (see [http://leekwars.com](http://leekwars.com)).

Usage
=====

* Configure access to the LeekWars server in `Preferences -> LeekScript` (username & password, optional proxy configuration...)
* Retrieve the list of available functions/constants using `Tools -> Update LeekWars API`
* Retrieve your existing scripts using `Tools -> Download LeekWars scripts`
* Start developing with pleasure™

Features
========

* New file type (*.lks)
* Basic lexer/parser (error recovery can be enhanced though)
* Syntax highlighting, find usages, brace matching, code folding, structure view, code commenting
* Retrieve functions, weapons and chips from LeekWars and aggregate them in a special script named `leekwars-api.lks`
* Retrieve existing scripts from the LeekWars server
* Code completion
* Refactoring : rename variable/function
* Import/save **existing** scripts from/to leekwars.com

Planned features
================
* Create new scripts (on the server)
* Rename existing scripts (on the server)
* "Include" a file into another (for example to share code between team members)
* Javadoc-like popup (very limited at the moment)
* Code formatting

Current limitations
===================

* Most of the data exchanged with the LeekWars server was deduced by reverse engineering, no official API is exposed, so changes on the server may require a new version of this plugin.