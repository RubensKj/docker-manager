FROM node:latest
LABEL rubenskj client
COPY /client/build /var/www
WORKDIR /var/www
RUN npm install serve
ENTRYPOINT ["serve", "./build"]
EXPOSE 3000