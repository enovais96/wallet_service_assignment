FROM openjdk:21-jdk
VOLUME /tmp
EXPOSE 8080
ADD target/transaction-service-1.0.0.jar transaction-service.jar
ENTRYPOINT ["java","-jar","/transaction-service.jar"]
