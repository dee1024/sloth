![](https://raw.githubusercontent.com/coolcooldee/sloth/master/src/main/resources/static/images/logo.png)

SLOTH 1.0
=========
Sloth is A tool to generate scaffold code from SQL databases.
You just need to specify your application database may be used.

Features
========
1. __Create stand-alone SpringBoot applications__　
2. __Generate model–view–controller code__
3. __Provide many kinds of Data access with JDBC__　
    * Mybatis
    * JOOQ
    * Spring JDBC
4. __Generate API DOC__
5. __DRY ( don't repeat yourself principle )__
    * Never copy and paste boilerplate between projects again

Quick Start
===========
1.Clone Sloth
``git clone https://github.com/coolcooldee/sloth.git``
2.Into The Sloth Root Directory
``cd sloth``

3.Maven Install
``mvn install``

4.Prepare Your Database
``host:port, 127.0.0.1:3306``
``username, root``
``password, ``
``dbname, test``

5.Sloth Generating
``mvn exec:java`` 
``-Dexec.cleanupDaemonThreads=false``
``-Dexec.mainClass=”com.dee.Application”`` 
``-Dexec.args=``
``    ”-path/Users/sloth/generated-sources-by-sloth`` 
``    -h127.0.0.1`` 
``    -P3306`` 
``    -uroot`` 
``    -p`` 
``    -dgamesapi`` 
``    -strategyssm``
``    -packagecom.new``
``    ”``
``
6.Into Sloth Target Project Generated
``cd /Users/sloth/generated-sources-by-sloth``

7.Runngin Sloth Target Project
``mvn exec:java`` 
``-Dexec.cleanupDaemonThreads=false``
``-Dexec.mainClass=”com.new.Application”`` 

8.
``http://localhost:8080``
``http://localhost:8080/apis-docs-by-sloth.html``


Author
======

License
=======





