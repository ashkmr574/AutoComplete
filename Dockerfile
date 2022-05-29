FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} autocomplete.jar
ENTRYPOINT ["java","-jar","/autocomplete.jar"]
