FROM maven:3.8.3-openjdk-17 as build

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17

VOLUME /tmp

ARG JAR_FILE=/usr/src/app/target/*.jar

COPY --from=build ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]