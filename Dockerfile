FROM openjdk:17
EXPOSE 8085
ADD target/gestionTacheMs-0.0.1-SNAPSHOT.jar gestionTacheMs-docker.jar
ENTRYPOINT ["java", "-jar", "gestionTacheMs-docker.jar"]
