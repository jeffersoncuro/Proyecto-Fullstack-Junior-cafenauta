# Etapa de construcción
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/the_coffe_palace-0.0.1-SNAPSHOT.jar java-app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-Xmx256m", "-Xms128m", "-jar", "java-app.jar"]
