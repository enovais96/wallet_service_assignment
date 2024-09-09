FROM openjdk:21-jdk
VOLUME /tmp
EXPOSE 8080
ADD target/wallet-service-1.0.0.jar wallet-service.jar
ENTRYPOINT ["java","-jar","/wallet-service.jar"]
