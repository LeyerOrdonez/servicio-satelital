FROM openjdk:17
VOLUME tmp/
EXPOSE 8082:8092
ARG JAR_FILE=target/servicio-asignatura-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} asignaturapp.jar
ENTRYPOINT ["java","-jar","/asignaturapp.jar"]