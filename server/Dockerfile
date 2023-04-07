FROM gradle:7-jdk17-focal as build
WORKDIR /app
COPY . .
RUN gradle :server:build --parallel

FROM eclipse-temurin:17-jdk-focal as run
WORKDIR /app
COPY --from=build /app/server/build/libs/server-*-SNAPSHOT.jar /app/server.jar
ENV JAVA_OPTS=""
ENV XMS=50M
ENV XMX=1G
CMD java \
-Xms$XMS -Xmx$XMX \
-XX:+ExitOnOutOfMemoryError \
-Djava.rmi.server.hostname=0.0.0.0 \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=5151 \
-Dcom.sun.management.jmxremote.rmi.port=5151 \
-Dcom.sun.management.jmxremote.local.only=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-jar server.jar
EXPOSE 5151
EXPOSE 9191
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:9191/actuator/health | grep UP || exit 1