FROM openjdk:11.0.4-jre-slim
EXPOSE 8081
COPY build/libs/multiplier-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java", "-jar", "multiplier-0.0.1-SNAPSHOT.jar"]