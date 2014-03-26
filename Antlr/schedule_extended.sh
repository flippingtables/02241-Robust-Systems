#!/bin/sh
java -jar /usr/local/lib/antlr-4.2-complete.jar Schedule_ext.g4
javac Schedule_ext*.java
java org.antlr.v4.runtime.misc.TestRig Schedule_Ext route -gui < schedule_ext.txt