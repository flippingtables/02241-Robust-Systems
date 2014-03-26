#!/bin/sh
java -jar /usr/local/lib/antlr-4.2-complete.jar ScheduleExt.g4
javac ScheduleExt*.java
java org.antlr.v4.runtime.misc.TestRig ScheduleExt route -gui < ScheduleExt.txt