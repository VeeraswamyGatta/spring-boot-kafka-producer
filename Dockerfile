FROM openjdk:8
ADD target/spring-boot-kafka-producer-example.jar spring-boot-kafka-producer-example.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-boot-kafka-producer-example.jar"]