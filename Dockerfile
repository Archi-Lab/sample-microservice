#Basis Image
FROM openjdk:12-jdk-alpine

#Port Freigeben für Docker
EXPOSE 8080

#Kopieren des Artefakts auf den Container
COPY target/sample-microservice-0.0.1-SNAPSHOT.jar app.jar

#Startpunkt für den Service festlegen
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]
