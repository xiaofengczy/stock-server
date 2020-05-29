FROM java:alpine
VOLUME /tmp
ADD stock-server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]