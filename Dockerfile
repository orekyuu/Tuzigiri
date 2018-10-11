FROM gradle:4.10.2-jdk11 as builder

WORKDIR /home/gradle/Tuzigiri
USER root
ADD . .
RUN gradle bootJar --no-daemon

FROM openjdk:10.0.2-jre
LABEL maintainer "orekyuu <orekyuu@gmail.com>, nokok <nokok.kz@gmail.com>"

COPY --from=builder /home/gradle/Tuzigiri/build/libs/tuzigiri.jar .
CMD ["java", "-jar", "tuzigiri.jar"]
