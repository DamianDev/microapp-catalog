FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/microapp-catalog-1.0.0.jar
COPY ${JAR_FILE} microapp-catalog.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","microapp-catalog.jar"]