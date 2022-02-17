FROM openjdk:8
WORKDIR /user-management
COPY target/user-management-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]