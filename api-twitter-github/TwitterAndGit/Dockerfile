FROM openjdk:8-jdk-alpine
MAINTAINER Eloisa Paz
EXPOSE 8080
VOLUME /tmp
COPY ./build/libs/com.eloisapaz.cloud.microservice-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
