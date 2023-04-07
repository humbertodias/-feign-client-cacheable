FROM gradle:7-jdk17-focal as build
WORKDIR /app
COPY . .
RUN gradle :client:build --parallel

FROM eclipse-temurin:17-jdk-focal as run
WORKDIR /app
COPY --from=build /app/client/build/libs/client-*-SNAPSHOT.jar /app/client.jar
ENV XMS=50m
ENV XMX=256m
CMD java \
-Xms$XMS -Xmx$XMX \
-XX:+ExitOnOutOfMemoryError \
-XX:+UseZGC \
-XX:+PrintFlagsFinal \
-Djava.rmi.server.hostname=0.0.0.0 \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=5050 \
-Dcom.sun.management.jmxremote.rmi.port=5050 \
-Dcom.sun.management.jmxremote.local.only=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-jar client.jar
EXPOSE 5050
EXPOSE 9090
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:9090/actuator/health | grep UP || exit 1