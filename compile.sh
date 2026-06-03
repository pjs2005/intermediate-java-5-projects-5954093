#!/usr/bin/env bash
set -e

# Compile all Java source files and include the org.json jar on the classpath.
# Place json-20260522.jar in src/lib/ before running this script.

if [[ ! -f src/lib/json-20260522.jar ]]; then
  echo "Error: src/lib/json-20260522.jar not found. Place the jar in src/lib/ and run again."
  exit 1
fi

mkdir -p bin
find src -name '*.java' > /tmp/java_sources.txt
javac -cp "src/lib/json-20260522.jar" -d bin @/tmp/java_sources.txt
rm -f /tmp/java_sources.txt

echo "Compiled successfully."
