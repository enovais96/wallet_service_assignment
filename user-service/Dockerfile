FROM openjdk:21-jdk
VOLUME /tmp
EXPOSE 8080
ADD target/user-service-1.0.0.jar user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]
