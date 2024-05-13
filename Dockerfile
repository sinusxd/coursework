# Используйте официальный образ Gradle для сборки проекта
FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon

# Используйте официальный образ OpenJDK для запуска приложения
FROM openjdk:21
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
