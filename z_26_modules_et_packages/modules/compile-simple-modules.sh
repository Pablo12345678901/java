#!/usr/bin/env bash
javac -d outDir --module-source-path simple-modules $(find simple-modules -name "*.java")
# -d signifie que les fichiers crées seront placés dans le répertoire qui suit (ici outDir)