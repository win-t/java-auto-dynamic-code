#!/bin/bash

set -euo pipefail
cd "$(dirname $0)"

echo "[build] main"
./src/main/build.bash

echo "[build] lala"
./src/lala/build.bash
