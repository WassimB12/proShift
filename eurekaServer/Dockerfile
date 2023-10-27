FROM openjdk:8
EXPOSE 8761
ADD target/eurekaServer-0.0.1-SNAPSHOT.jar eurekaServer-docker.jar
ENTRYPOINT ["java", "-jar", "eurekaServer-docker.jar"]
