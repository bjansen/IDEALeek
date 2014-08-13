IDEALeek
==========

This plugin adds support for the LeekScript language in IntelliJ (see [http://leekwars.com](http://leekwars.com)).

[![Build Status](https://travis-ci.org/bjansen/IDEALeek.svg?branch=master)](https://travis-ci.org/bjansen/IDEALeek)

Installation
============

This plugin is available on JetBrains' [plugins website](http://plugins.jetbrains.com/plugin/7531?pr=idea).
To install it directly from your IDE, open `File > Settings > Plugins` and click the button named `Browse repositories`. Type `leekscript` in the search bar and click the big green button named `Install plugin`. Restart your IDE and you're ready to go!


Usage
=====

Once the plugin is installed and the IDE restarted:

* create a new `LeekScript` project under `File > New Project`
* in step 1, configure your login/password for leekwars.com
* optionally, if you are using a proxy to connect to Leek Wars, change the default URL and specify the proxy's authentication settings as needed
* in step 2, choose a project name and location and click finish
* Start developing with pleasure™

The plugin will automatically fetch all your existing scripts, as well as a file named `leekwars-api.lks` which contains every function and constant available in the API.

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
* Code formatting
* Create/rename/delete scripts on the server

Planned features
================
* Javadoc-like popup (very limited at the moment)

Current limitations
===================

* Most of the data exchanged with the LeekWars server was deduced by reverse engineering, no official API is exposed, so changes on the server may require a new version of this plugin.
