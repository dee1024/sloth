![](https://raw.githubusercontent.com/coolcooldee/sloth/master/src/main/resources/static/images/logo.png)

SLOTH 1.0
=========
__Sloth__ 是一个生成脚手架代码的工具。你只需要设置好业务应用所需要用的 __Mysql__ 数据源即可。如果你用过 Ruby on Rails 的代码生成器的话，那么 Sloth 也同样适合， 它使用 Java 语言。旨在为开发者提供一系列健壮的工具、程序库和工作流，帮助他们快速构建出漂亮、引人注目的Web应用。
其它语言版本 : [English](/README.md)

特性
===
- __生成一个独立可运行的 SpringBoot 应用__　
- __生成完整的 Model–View–Controller 三层代码__
- __生成 API WEB 接口文档__
- __提供多种数据访问方式__　
    * [Spring Data](http://projects.spring.io/spring-data/)
    * [Mybatis](http://www.mybatis.org/mybatis-3/)
    * [JOOQ](http://www.jooq.org)
    * [Spring JDBC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html)
- __DRY 原则__
    * 绝不复制黏贴代码
- __其它__
    * 生成的目标代码整合: [Springboot](http://projects.spring.io/spring-boot/)、[Guava](https://github.com/google/guava)、[HikariCP](https://github.com/brettwooldridge/HikariCP)、[Apache Commons](http://commons.apache.org)、[fastjson](https://github.com/alibaba/fastjson)、[swagger2](http://swagger.io)、[Flywaydb](https://flywaydb.org)

快速开始
======
- __步骤一：准备好数据源__

host | port | username | password | dbname
------------ | ------------- | ------------- | ------------- | -------------
127.0.0.1 | 3306 | root | 123456 | test


- __步骤二：Clone Sloth__
```bash
git clone https://github.com/coolcooldee/sloth.git
```
- __步骤三：进入 Sloth 的根目录__
```bash
cd sloth
```
- __步骤四：使用 Maven 安装 Sloth__
```bash
mvn clean install
```
- __步骤五：使用 Sloth 生成__
```
mvn exec:java -Dexec.args="-path/workspaces/mySlothProject -packagecom.test -h127.0.0.1 -P3306 -uroot -p123456 -dtest -strategyssm"  -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.github.coolcooldee.sloth.Application"
```


生成使用的参数 | 例如         |参数说明
------------ | -------------|-------------
-path           | /workspaces/mySlothProject | 生成的目标项目的路径
-projectname  | mySlothProject | 生成的目标项目的包名
-package  | com.test| 目前项目的名字
-help  |    | 查看帮助
-strategy  | ssm|   生成策略:ssd=SpringBoot + SpringData,ssm=SpringMVC + Spring+MyBatis,sss=SpringBoot + SpringJDBC,ssj=SpringBoot + JOOQ
-h  | 127.0.0.1|数据库地址
-P  | 3306|数据库端口
-u  | root|数据库用户名
-p  | 123456|数据库用户密码
-d  | test|数据库库名

- __步骤六：进入新生成的目标项目的根目录__
```bash
cd /workspaces/mySlothProject
```

- __步骤七：启动新生成的目标项目__
```bash
mvn clean install
mvn exec:java -Dexec.mainClass=”com.test.Application” -Dexec.cleanupDaemonThreads=false
```
- __步骤八：完成__
<http://localhost:8081/apis-docs-by-sloth.html>

例子
===
- __我的数据源__

      TableName |
      --------- |
      game |
      gameRole |
      gameServer |
      
- __所生成的目标项目代码结构__
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
│   │   │   │   │   ├── controller
│   │   │   │   │   │   ├── restfulapi
│   │   │   │   │   │   │   ├── GameController.java
│   │   │   │   │   │   │   ├── GameRoleController.java
│   │   │   │   │   │   │   ├── GameServerController.java
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
- __目标项目的接口文档页面示意图__

![](https://raw.githubusercontent.com/coolcooldee/sloth/master/src/main/resources/static/images/demo1.png)

- __示例__
http://www.dee1024.cc/apis-docs-by-sloth.html

贡献
===
我们期待你的 pull requests !

作者
===
* __Dee Qiu__ <coolcooldee@gmail.com>

其它
===
* __QQ群__ 570997546

许可证
===
Sloth is licensed under the Apache License, Version 2.0 (the "License");




