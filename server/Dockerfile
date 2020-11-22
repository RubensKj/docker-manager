FROM openjdk:latest
MAINTAINER rubenskj/server
COPY ./src/main/resources/application.properties /var/www/application.yml
COPY ./target/*.jar /var/www/application.jar
WORKDIR /var/www/
EXPOSE 8080
ENTRYPOINT java -jar application.jar