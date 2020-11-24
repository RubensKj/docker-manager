FROM node:latest
MAINTAINER RubensKj
ENV REACT_APP_API_URL=http://localhost:8080/api
COPY /client /var/www
WORKDIR /var/www
# RUN npm install
ENTRYPOINT ["npm", "start"]
EXPOSE 3000