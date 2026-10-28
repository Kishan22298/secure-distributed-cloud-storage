
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
COPY common/pom.xml common/pom.xml
COPY metadata-server/pom.xml metadata-server/pom.xml
COPY storage-node/pom.xml storage-node/pom.xml

COPY common/src common/src
COPY metadata-server/src metadata-server/src
COPY storage-node/src storage-node/src

RUN mvn -B -pl metadata-server -am package -DskipTests

FROM eclipse-temurin:21-jre
RUN apt-get update \
    && apt-get install -y --no-install-recommends curl \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
RUN useradd --system --uid 10001 appuser

COPY --from=build \
    /workspace/metadata-server/target/metadata-server-0.1.0-SNAPSHOT.jar \
    /app/app.jar

USER 10001
EXPOSE 8080

ENTRYPOINT ["java", "-Duser.timezone=Asia/Kolkata", "-jar", "/app/app.jar"]
