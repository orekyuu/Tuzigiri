FROM gradle:jdk11-slim as builder
LABEL maintainer "orekyuu <orekyuu@gmail.com>, nokok <nokok.kz@gmail.com>"

USER root

WORKDIR /app
ADD build.gradle build.gradle
ADD settings.gradle settings.gradle
RUN gradle resolveDependencies --no-daemon

ADD src src

RUN gradle bootJar --no-daemon


FROM adoptopenjdk/openjdk11:jdk-11.28

COPY --from=builder /app/build/libs/tuzigiri.jar .

CMD ["java", "-jar", "tuzigiri.jar"]

