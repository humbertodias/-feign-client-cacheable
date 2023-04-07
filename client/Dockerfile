FROM gradle:7-jdk17-focal as build
WORKDIR /app
COPY . .
RUN gradle :client:build --parallel

FROM eclipse-temurin:17-jdk-focal as run
WORKDIR /app
COPY --from=build /app/client/build/libs/client-*-SNAPSHOT.jar /app/client.jar
ENV JAVA_OPTS=""
CMD java -XX:+ExitOnOutOfMemoryError -jar client.jar
EXPOSE 9090
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:9090/actuator/health | grep UP || exit 1