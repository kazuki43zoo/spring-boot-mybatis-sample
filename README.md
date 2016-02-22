# spring-boot-mybatis-sample

The verifying application for https://github.com/mybatis/mybatis-3/issues/325.

## How to build a projects

```bash
mvn clean package
```

## How to run an application

```bash
java -jar spring-boot-app/target/spring-boot-app-1.0-SNAPSHOT.jar
```

## How to access a sample processing

* Access URL: `GET http://localhost:8080/todos/001`
* Result : `createdAt` is null. -> not apply custom type handler.

## Workaround for this issue

* Please checkout `workaround` branch.
* build a projects
* run an application
* access a sample processing

`createdAt` is not null. -> apply custom type handler.

## Using MyBatis Spring Boot 1.0.1-SNAPSHOT

* Please checkout `mybatis-spring-boot` branch.
* build a projects
* run an application
* access a sample processing

`createdAt` is not null. -> apply custom type handler.
