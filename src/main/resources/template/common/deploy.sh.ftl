#!/bin/bash
mvn clean install
cd `dirname $0`
for filename in `find .  -type f  -name '*-jar-without-dependencies.jar' | sort `;do
echo $filename
done
java -jar $filename
echo '[success!]'
open  http://localhost:8080/
