#!/bin/bash

mvn clean install
mvn exec:java -Dexec.args="-path/Users/dee/Downloads/sloth -projectnamessmproject -packagecom.github.coolcooldee.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategyssm"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.coolcooldee.sloth.Application"
#mvn exec:java -Dexec.args="-path/Users/dee/Downloads/sloth -projectnamesssproject -packagecom.github.coolcooldee.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategysss"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.coolcooldee.sloth.Application"
#mvn exec:java -Dexec.args="-path/Users/dee/Downloads/sloth -projectnamessjproject -packagecom.github.coolcooldee.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategyssj"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.coolcooldee.sloth.Application"