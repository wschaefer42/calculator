FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/calculator-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.jar"]