#!/bin/sh
java -jar /usr/local/lib/antlr-4.2-complete.jar Train.g4
javac Train*.java
java org.antlr.v4.runtime.misc.TestRig Train railsys -gui