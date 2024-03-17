FROM ubuntu:3.19.1-alpine AS build

RUN apt-get update \
  && apt-get install -y openjdk-17-jdk maven \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean install -DskipTests=true

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/spider-0.0.1.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
