FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8199
ARG JAR_FILE=/target/creditRating-0.0.1-SNAPSHOT.jar
COPY /target/creditRating-0.0.1-SNAPSHOT.jar credit-rating.jar
# java -jar /target/creditRating-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djdk.tls.client.protocols=TLSv1.2","-jar","credit-rating.jar"]