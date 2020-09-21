FROM openjdk:11.0.8-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]