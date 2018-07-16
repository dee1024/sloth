baseServiceUrl=http://localhost:8081
server.port=8081

#DB config
spring.datasource.url = jdbc:mysql://${sourceDbHost}:${sourceDbPort}/${sourceDbSchema}?useUnicode=true&characterEncoding=UTF-8
spring.datasource.username = ${sourceDbUsername}
spring.datasource.password = ${sourceDbPassword}
spring.datasource.driverClassName = com.mysql.jdbc.Driver

spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

spring.view.prefix: /WEB-INF/jsp/
spring.view.suffix: .jsp
