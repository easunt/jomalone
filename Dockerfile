FROM adoptopenjdk:11-jdk-hotspot AS builder
# the latest OpenJDK 11 with HotSpot JDK image + 빌드용
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
CMD java $JAVA_OPTS -server -jar app.jar
