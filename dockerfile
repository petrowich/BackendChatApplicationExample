FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/ChatApplicationExample.jar ChatApplicationExample.jar
ENTRYPOINT ["java","-jar","/ChatApplicationExample.jar"]