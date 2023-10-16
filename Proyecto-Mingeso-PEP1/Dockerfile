FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Proyecto-Mingeso-1-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/Proyecto-Mingeso-1-0.0.1-SNAPSHOT.jar"]