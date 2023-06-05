#!/usr/bin/env bash
javac -d outDir --module-source-path simple-modules $(find simple-modules -name "*.java")
# -d signifie que les fichiers crées seront placés dans le répertoire qui suit (ici outDir)
# Attention : avant d'utiliser le module, il faut le compiler. Pour ce faire :
# il faut compiler à la fois le module ET les class utilisées dans celui-ci sinon cela bug.
# Par exemple, pour un module ne contenant qu'une seule class, il faut faire :
# javac path/module-info.java path/classacompiler.java