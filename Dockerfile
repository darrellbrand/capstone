# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:20
# copy the packaged jar file into our docker image
COPY target/demo-0.0.1-SNAPSHOT.jar /demo.jar
# set the startup command to execute the jar
EXPOSE 8080
CMD ["java", "-jar", "/demo.jar"]