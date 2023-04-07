FROM gradle:7-jdk17-focal as build
WORKDIR /app
COPY . .
RUN gradle :server:build --parallel

FROM eclipse-temurin:17-jdk-focal as run
WORKDIR /app
COPY --from=build /app/server/build/libs/server-*-SNAPSHOT.jar /app/server.jar
ENV JAVA_OPTS=""
CMD java -XX:+ExitOnOutOfMemoryError -jar server.jar
EXPOSE 9191
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:9191/actuator/health | grep UP || exit 1