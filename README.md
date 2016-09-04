![](https://raw.githubusercontent.com/coolcooldee/sloth/master/src/main/resources/static/images/logo.png)

SLOTH 1.0
=========
Sloth is A tool to generate scaffold code from SQL databases.
You just need to specify your application database may be used.

Features
========
1. __Generate Stand-Alone SpringBoot Applications__　
2. __Generate Model–View–Controller Code__
3. __Generate API DOC__
4. __Provide Many Kinds Of Data Access With JDBC__　
    * Mybatis
    * JOOQ
    * Spring JDBC
5. __DRY ( don't repeat yourself principle )__
    * Never copy and paste boilerplate between projects again

Quick Start
===========
1. __Clone Sloth__
    ```bash
    git clone https://github.com/coolcooldee/sloth.git
    ```
2. __Into The Sloth Root Directory__
    ```bash
    cd sloth
    ```
3. __Maven Install__
    ```bash
    mvn install
    ```
4. __Prepare Your Database__
    ```
     host      | port | username | password | dbname 
     --------- | ---- | -------- | -------- | ------ 
     127.0.0.1 | 3306 | root     |          |         
    ```

5. __Sloth Generating__
    ```bash
    mvn exec:java
        -Dexec.cleanupDaemonThreads=false
        -Dexec.mainClass=”com.dee.Application”
        -Dexec.args=
            ”-path**/Users/sloth/generated-sources-by-sloth**
            -h**127.0.0.1**
            -P**3306**
            -u**root**
            -p
            -d**gamesapi**
            -strategy**ssm**
            -package**com.new**
            ”
    ```

6. __Into Sloth Target Project Generated__
    ```bash
    cd /Users/sloth/generated-sources-by-sloth
    ```

7. __Runngin Sloth Target Project__
    ```bash
    mvn exec:java
        -Dexec.cleanupDaemonThreads=false
        -Dexec.mainClass=”com.new.Application”
    ```
8. __OK__
    ```bash
    http://localhost:8080
    http://localhost:8080/apis-docs-by-sloth.html
    ```


Author
======

License
=======





