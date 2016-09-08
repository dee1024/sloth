#!/bin/bash
mvn clean install
mvn exec:java -Dexec.args="-path/Users/dee/Downloads/abcd/Projectdee -packagecom.test -h127.0.0.1 -P3306 -uroot -p -dtest -strategyssm"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.coolcooldee.sloth.Application"