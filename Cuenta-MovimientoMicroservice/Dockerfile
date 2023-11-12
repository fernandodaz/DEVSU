FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app

WORKDIR /usr/src/app

FROM openjdk:17-jdk-slim

ARG JAR_FILE=AccountModuleService-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","AccountModuleService-0.0.1-SNAPSHOT.jar"]