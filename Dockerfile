FROM openjdk:11
WORKDIR "/app"
COPY ./build/libs/family-0.0.1-SNAPSHOT.jar family-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","family-0.0.1-SNAPSHOT.jar"]