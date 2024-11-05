FROM openjdk:17
VOLUME tmp/
EXPOSE 8084:8092
ARG JAR_FILE=target/servicio-satelital-uceva-0.1.0-SNAPSHOT.jar
ADD ${JAR_FILE} datoapp.jar
ENTRYPOINT ["java","-jar","/datoapp.jar"]
