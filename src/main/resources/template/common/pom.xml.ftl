<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>${packageName}</groupId>
    <artifactId>${projectName}</artifactId>
    <version>V1.0</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
        <!--flyway 数据库迁移所用的参数 -->
        <db.url>jdbc:mysql://${sourceDbHost}:${sourceDbPort}</db.url>
        <db.username>${sourceDbUsername}</db.username>
        <db.password>${sourceDbPassword}</db.password>
        <db.schema>${sourceDbSchema}</db.schema>
        <start-class>${packageName}.Application</start-class>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!--加入对Http支持-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- redis -->
        <#--<dependency>-->
            <#--<groupId>org.springframework.boot</groupId>-->
            <#--<artifactId>spring-boot-starter-redis</artifactId>-->
        <#--</dependency>-->

        <!-- 热部署工具 -->
        <#--<dependency>-->
            <#--<groupId>org.springframework.boot</groupId>-->
            <#--<artifactId>spring-boot-devtools</artifactId>-->
            <#--<optional>true</optional>-->
        <#--</dependency>-->

        <!--加入对Websocket支持-->
        <#--<dependency>-->
            <#--<groupId>org.springframework.boot</groupId>-->
            <#--<artifactId>spring-boot-starter-websocket</artifactId>-->
        <#--</dependency>-->

        <!--加入对于MQ支持-->
        <#--<dependency>-->
            <#--<groupId>org.springframework</groupId>-->
            <#--<artifactId>spring-messaging</artifactId>-->
        <#--</dependency>-->

        <!--加入单元测试支持-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--AOP支持-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <!--Freemarker支持-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>

        <!--DB连接支持-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.37</version>
        </dependency>

        <!-- mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.2.7</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.2</version>
        </dependency>
        <!--数据库连接池-->
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>2.4.2</version>
        </dependency>

        <!-- apache组件 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.3.2</version>
        </dependency>

        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.1</version>
        </dependency>

        <!-- json -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.0</version>
        </dependency>

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.2.4</version>
        </dependency>

        <!--其它-->
        <dependency>
            <groupId>org.codehaus.jackson</groupId>
            <artifactId>jackson-mapper-asl</artifactId>
            <version>1.9.13</version>
        </dependency>

        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
        </dependency>

        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpmime</artifactId>
        </dependency>

        <!-- guava -->
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>17.0</version>
        </dependency>

        <dependency>
            <groupId>commons-lang</groupId>
            <artifactId>commons-lang</artifactId>
            <version>2.5</version>
        </dependency>

        <dependency>
            <groupId>commons-codec</groupId>
            <artifactId>commons-codec</artifactId>
            <version>1.10</version>
        </dependency>
        <dependency>
            <groupId>org.apache.xmlrpc</groupId>
            <artifactId>xmlrpc-client</artifactId>
            <version>3.1.3</version>
        </dependency>
        <dependency>
            <groupId>dom4j</groupId>
            <artifactId>dom4j</artifactId>
            <version>1.6.1</version>
        </dependency>

        <!--对swagger2的支持-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.2.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.2.2</version>
        </dependency>

        <!--日志-->
        <#--<dependency>-->
            <#--<groupId>org.apache.logging.log4j</groupId>-->
            <#--<artifactId>log4j-api</artifactId>-->
            <#--<version>2.4.1</version>-->
        <#--</dependency>-->
        <#--<dependency>-->
            <#--<groupId>org.apache.logging.log4j</groupId>-->
            <#--<artifactId>log4j-core</artifactId>-->
            <#--<version>2.4.1</version>-->
        <#--</dependency>-->
        <#--<dependency>-->
            <#--<groupId>org.slf4j</groupId>-->
            <#--<artifactId>slf4j-api</artifactId>-->
            <#--<version>1.7.12</version>-->
        <#--</dependency>-->
        <#--<dependency>-->
            <#--<groupId>org.apache.logging.log4j</groupId>-->
            <#--<artifactId>log4j-slf4j-impl</artifactId>-->
            <#--<version>2.4.1</version>-->
        <#--</dependency>-->
    </dependencies>


    <build>
        <resources>
            <resource>
                <directory>${"$"}{basedir}/src/main/java</directory>
            </resource>
            <resource>
                <directory>${"$"}{basedir}/src/main/config</directory>
            </resource>
            <resource>
                <directory>${"$"}{basedir}/src/main/resources</directory>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>${"$"}{java.version}</source>
                    <target>${"$"}{java.version}</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>build-helper-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <id>timestamp-property</id>
                        <goals>
                            <goal>timestamp-property</goal>
                        </goals>
                        <configuration>
                            <name>current.time</name>
                            <pattern>yyyyMMddHHmmss</pattern>
                            <timeZone>GMT+8</timeZone>
                        </configuration>
                    </execution>
                </executions>
            </plugin>


            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <configuration>
                    <outputDirectory>${"$"}{project.build.directory}/lib</outputDirectory>
                    <excludeTransitive>false</excludeTransitive> <!-- 表示是否不包含间接依赖的包 -->
                    <stripVersion>false</stripVersion> <!-- 去除版本信息 -->
                </configuration>

                <executions>
                    <execution>
                        <id>copy-dependencies</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                            <!-- 拷贝项目依赖包到lib/目录下 -->
                            <outputDirectory>${"$"}{project.build.directory}/lib</outputDirectory>
                            <excludeTransitive>false</excludeTransitive>
                            <stripVersion>false</stripVersion>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.6</version>
                <executions>
                    <execution>
                        <id>copy-resources</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-resources</goal>
                        </goals>
                        <configuration>
                            <encoding>UTF-8</encoding>
                            <!-- 拷贝项目src/excut/resources/下，除.bat以外的所有文件到conf/目录下 -->
                            <outputDirectory>${"$"}{project.build.directory}/conf</outputDirectory>
                            <resources>
                                <resource>
                                    <directory>src/main/resources/</directory>
                                    <filtering>true</filtering>
                                </resource>
                            </resources>
                        </configuration>
                    </execution>
                    <execution>
                        <id>copy-command</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-resources</goal>
                        </goals>
                        <configuration>
                            <encoding>UTF-8</encoding>
                            <!-- 只拷贝项目src/excut/resources/目录下的.bat文件到输出目录下 -->
                            <outputDirectory>${"$"}{project.build.directory}</outputDirectory>
                            <resources>
                                <resource>
                                    <directory>src/main/resources/</directory>
                                    <filtering>true</filtering>
                                </resource>
                            </resources>
                        </configuration>
                    </execution>
                </executions>
            </plugin>


            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>2.4</version>
                <configuration>
                    <finalName>${"$"}{project.artifactId}-jar-without-dependencies</finalName>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>${"$"}{start-class}</mainClass>
                        </manifest>
                        <manifestEntries>
                            <Class-Path>. lib/ config/</Class-Path>
                        </manifestEntries>
                    </archive>

                    <includes>
                        <include>mybatis/**</include>
                        <include>com/**</include>
                        <include>META-INF/*</include>
                    </includes>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <#--<descriptors>-->
                        <#--<descriptor>src/excut/assembly/assembly.xml</descriptor>-->
                    <#--</descriptors>-->
                    <finalName>${"$"}{project.artifactId}</finalName>
                        <archive>
                            <manifest>
                                <mainClass>${"$"}{start-class}</mainClass>
                            </manifest>
                        </archive>
                        <descriptorRefs>
                            <descriptorRef>jar-with-dependencies</descriptorRef>
                        </descriptorRefs>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

        </plugins>
    </build>
</project>
