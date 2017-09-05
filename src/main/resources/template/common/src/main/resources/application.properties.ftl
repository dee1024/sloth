baseServiceUrl=http://localhost:8081
server.port=8081

#DB config
${packageName}.dbHost = ${sourceDbHost}
${packageName}.dbPort = ${sourceDbPort}
${packageName}.dbUser = ${sourceDbUsername}
${packageName}.dbPassword = ${sourceDbPassword}
${packageName}.dbName = ${sourceDbSchema}

#redis config
#${packageName}.redis.host=127.0.0.1
#${packageName}.redis.port=6379
#${packageName}.redis.database=0
#${packageName}.redis.password=
#${packageName}.redis.timeout=
#${packageName}.redis.maxPoolSize=
#${packageName}.redis.poolName=
#${packageName}.redis.expireTime=

#freemarker config
spring.freemarker.templateLoaderPath=classpath:/template/
spring.freemarker.templateEncoding=UTF-8
spring.freemarker.prefix=
spring.freemarker.suffix=.ftl
