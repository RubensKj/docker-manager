FROM node:latest
MAINTAINER RubensKj
COPY /client/build /var/www
WORKDIR /var/www
RUN npm install serve
ENTRYPOINT ["serve", "./build"]
EXPOSE 3000