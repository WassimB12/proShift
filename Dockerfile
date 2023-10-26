FROM openjdk:8
EXPOSE 8800
ADD /target/Freelancer-MS-1.0.1-SNAPSHOT.jar Freelancer-MS-1.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "Freelancer-MS-1.0.1-SNAPSHOT.jar" ]