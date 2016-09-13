baseServiceUrl=http://localhost:8081
server.port=8081

#DB config
${packageName}.dbHost = ${sourceDbHost}
${packageName}.dbPort = ${sourceDbPort}
${packageName}.dbUser = ${sourceDbUsername}
${packageName}.dbPassword = ${sourceDbPassword}
${packageName}.dbName = ${sourceDbSchema}

#redis配置（请修改）
${packageName}.redis.host=
${packageName}.redis.port=
${packageName}.redis.database=
${packageName}.redis.password=
${packageName}.redis.timeout=
${packageName}.redis.maxPoolSize=
${packageName}.redis.poolName=
${packageName}.redis.expireTime=

#freemarker config
spring.freemarker.templateLoaderPath=classpath:/template/
spring.freemarker.templateEncoding=UTF-8
spring.freemarker.prefix=
spring.freemarker.suffix=.ftl
