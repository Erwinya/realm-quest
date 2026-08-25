#!/bin/bash
set -euo pipefail

rm -rf bin
mkdir -p bin

echo "Compiling..."
find src -name "*.java" ! -name "*Test.java" > sources.txt
javac -d bin @sources.txt
rm sources.txt

echo "Running..."
java -cp bin com.halukkilincer.adventure.launcher.Main
