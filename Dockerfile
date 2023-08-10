FROM openjdk:11-jre
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

RUN mkdir -p /logs

ENV	PROFILE default
ENV TZ=Asia/Seoul
EXPOSE 8090

ARG JAVA_OPTS

ARG RELEASE_VERSION
ENV DD_VERSION=${RELEASE_VERSION}

ARG JAR_FILE="build/libs/*.jar"
COPY ./build/libs/*.jar app.jar

ENTRYPOINT java -XX:MaxGCPauseMillis=100 -XX:InitialRAMPercentage=50.0 -XX:MaxRAMPercentage=80.0 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9000 $JAVA_OPTS -jar app.jar
