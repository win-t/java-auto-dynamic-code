#!/bin/bash

set -euo pipefail
cd "$(dirname $0)"

echo "[build] compile all java source"
javac -cp ../../HelloWorld.jar HelloImpl.java

echo "[build] create jar file"
jar cvf ../../lala.jar *.class
