FROM eclipse-temurin:21-jdk-alpine
COPY homework6/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

