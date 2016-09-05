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
mvn clean install
```
- __Sloth Generating__
```
mvn exec:java -Dexec.args="-path/workspaces/mySlothProject -packagecom.test -h127.0.0.1 -P3306 -uroot -p123456 -dtest -strategyssm"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.coolcooldee.sloth.Application"
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
mvn clean install
mvn exec:java -Dexec.mainClass=”com.test.Application” -Dexec.cleanupDaemonThreads=false
```
- __DONE__
<http://localhost:8081/apis-docs-by-sloth.html>

Example
=======
- __Database Tables Source__

      TableName |
      --------- |
      game |
      gameRole |
      gameServer |
      
- __Target Project Code__
```bash
├── deploy.sh
├── mvn.sh
├── pom.xml
├── src
│   ├── main
│   │   ├── assembly
│   │   │   ├── assembly.xml
│   │   ├── java
│   │   │   ├── com
│   │   │   │   ├── sloth
│   │   │   │   │   ├── aop
│   │   │   │   │   │   ├── LogAspect.java
│   │   │   │   │   ├── Application.java
│   │   │   │   │   ├── common
│   │   │   │   │   │   ├── Page.java
│   │   │   │   │   ├── config
│   │   │   │   │   │   ├── database
│   │   │   │   │   │   │   ├── DB.java
│   │   │   │   │   │   │   ├── DBConfig.java
│   │   │   │   │   │   ├── redis
│   │   │   │   │   │   │   ├── RedisConfig.java
│   │   │   │   │   │   ├── swagger
│   │   │   │   │   │   │   ├── SwaggerConfig.java
│   │   │   │   │   ├── controller
│   │   │   │   │   │   ├── IndexController.java
│   │   │   │   │   │   ├── restfulapi
│   │   │   │   │   │   │   ├── GameController.java
│   │   │   │   │   │   │   ├── GameRoleController.java
│   │   │   │   │   │   │   ├── GameServerController.java
│   │   │   │   │   │   ├── webpage
│   │   │   │   │   │   │   ├── GamePageController.java
│   │   │   │   │   │   │   ├── GameRolePageController.java
│   │   │   │   │   │   │   ├── GameServerPageController.java
│   │   │   │   │   ├── mapper
│   │   │   │   │   │   ├── GameMapper.java
│   │   │   │   │   │   ├── GameRoleMapper.java
│   │   │   │   │   │   ├── GameServerMapper.java
│   │   │   │   │   ├── model
│   │   │   │   │   │   ├── Game.java
│   │   │   │   │   │   ├── GameRole.java
│   │   │   │   │   │   ├── GameServer.java
│   │   │   │   │   ├── service
│   │   │   │   │   │   ├── GameRoleService.java
│   │   │   │   │   │   ├── GameServerService.java
│   │   │   │   │   │   ├── GameService.java
│   │   │   │   │   │   ├── impl
│   │   │   │   │   │   │   ├── GameRoleServiceImpl.java
│   │   │   │   │   │   │   ├── GameServerServiceImpl.java
│   │   │   │   │   │   │   ├── GameServiceImpl.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   ├── static
│   │   │   │   ├── apis-docs-by-sloth.html
│   │   │   │   ├── css
│   │   │   │   ├── fonts
│   │   │   │   ├── html
│   │   │   │   ├── js
│   │   │   ├── template
├── start.sh
├── stop.sh
```
- __Target Project Api Webpage__

![](https://raw.githubusercontent.com/coolcooldee/sloth/master/src/main/resources/static/images/demo1.png)

Contributing
============
If you want to contribute code, we are waiting for your pull requests !

Author
======
* __Dee Qiu__ <coolcooldee@gmail.com>

License
=======
Sloth is licensed under the Apache License, Version 2.0 (the "License");




