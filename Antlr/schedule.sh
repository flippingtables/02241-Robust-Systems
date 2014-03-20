#!/bin/sh
java -jar /usr/local/lib/antlr-4.2-complete.jar Schedule.g4
javac Schedule*.java
java org.antlr.v4.runtime.misc.TestRig Schedule route -gui < schedule.txt