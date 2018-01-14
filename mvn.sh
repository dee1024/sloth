#!/bin/bash

mvn clean install
mvn exec:java -Dexec.args="-path/Users/dee/Documents/dev/github -projectnamebest-practices-springboot-mybatis -packagecom.github.dee1024.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategyssm"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.dee1024.sloth.Application"
#mvn exec:java -Dexec.args="-path/Users/dee/Documents/dev/github -projectnamebest-practices-springboot-springjdbc -packagecom.github.dee1024.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategysss"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.dee1024.sloth.Application"
#mvn exec:java -Dexec.args="-path/Users/dee/Documents/dev/github -projectnamebest-practices-springboot-jooq -packagecom.github.dee1024.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategyssj"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.dee1024.sloth.Application"
#mvn exec:java -Dexec.args="-path/Users/dee/Documents/dev/github -projectnamebest-practices-springboot-springdata -packagecom.github.dee1024.sloth -h127.0.0.1 -P3306 -uroot -p -dtest -strategyssd"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.dee1024.sloth.Application"