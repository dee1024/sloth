![](https://raw.githubusercontent.com/coolcooldee/sloth/master/src/main/resources/static/images/logo.png)

SLOTH 1.0
=========
Sloth is A tool to generate scaffold code from SQL databases.
You just need to specify your application database may be used.

Features
========
- __Generate Stand-Alone SpringBoot Applications__　
- __Generate Model–View–Controller Code__
- __Generate API DOC__
- __Provide Many Kinds Of Data Access With JDBC__　
    * Mybatis
    * JOOQ
    * Spring JDBC
- __DRY ( don't repeat yourself principle )__
    * Never copy and paste boilerplate between projects again

Quick Start
===========
- __Prepare Your Database__

      host      | port | username | password | dbname 
      --------- | ---- |:--------:| -------- |:------:
      127.0.0.1 | 3306 | root     |  123456  | test    


- __Clone Sloth__
```bash
git clone https://github.com/coolcooldee/sloth.git
```
- __Into The Sloth Root Directory__
```bash
cd sloth
```
- __Maven Install__
```bash
mvn install
```
- __Sloth Generating__
```
mvn exec:java -Dexec.args="-path/workspaces/mySlothProject -packagecom.test -h127.0.0.1 -P3306 -uroot -p123456 -dtest -strategyssm"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.sloth.Application"
```
      generate args             | e.g | description 
      :--------- | ---- | ---- 
      -path |/workspaces/mySlothProject | the path where code generate  
      -package | com.test | Tell Sloth to use the package name
      -strategy | ssm | generattion strategy. ssm=SpringMVC+Spring+Mybatis, ssj=SpringMVC+Spring+JOOQ, sss=SpringMVC+Spring+SpringJDBC
      -h | 127.0.0.1 | database host 
      -P | 3306 | database port 
      -u | root | database username 
      -p | 123456 | database password
      -d | test | database name

- __Into Sloth Target Project Generated__
```bash
cd /workspaces/mySlothProject
```

- __Runngin Sloth Target Project__
```bash
mvn install
mvn exec:java -Dexec.mainClass=”com.test.Application” -Dexec.cleanupDaemonThreads=false
```
- __OK__
```bash
<http://localhost:8081/apis-docs-by-sloth.html>
```


Author
======

License
=======





