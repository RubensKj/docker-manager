FROM openjdk:latest
LABEL rubenskj server
COPY /docker/config/application.yml /var/www/application.yml
COPY /server/target/*.jar /var/www/application.jar
WORKDIR /var/www/
EXPOSE 8080
ENTRYPOINT java -jar application.jar