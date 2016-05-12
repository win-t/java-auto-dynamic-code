#!/bin/bash

set -euo pipefail
cd "$(dirname $0)"

echo "[build] compile all java source"
javac *.java

echo "[build] create jar file"
jar cvfe ../../HelloWorld.jar HelloWorld *.class
