FROM openjdk:10.0.2-jdk as builder

WORKDIR /app
ADD . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:10.0.2-jre
LABEL maintainer "orekyuu <orekyuu@gmail.com>, nokok <nokok.kz@gmail.com>"

COPY --from=builder /app/build/libs/tuzigiri.jar .
CMD ["java", "-jar", "tuzigiri.jar"]
