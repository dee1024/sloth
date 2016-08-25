#启动端口
baseServiceUrl=http://localhost:8081
server.port=8081

#DB config
${packageName}.dbHost = ${sourceDbHost}
${packageName}.dbPort = ${sourceDbPort}
${packageName}.dbUser = ${sourceDbUsername}
${packageName}.dbPassword = ${sourceDbPassword}
${packageName}.dbName = ${sourceDbSchema}

#freemarker config
spring.freemarker.templateLoaderPath=classpath:/template/
spring.freemarker.templateEncoding=UTF-8
spring.freemarker.prefix=
spring.freemarker.suffix=.ftl
