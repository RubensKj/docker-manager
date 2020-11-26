FROM node:latest as build
LABEL rubenskj client
WORKDIR /usr/src/app
COPY /client/package.json yarn.lock ./
RUN yarn
COPY /client/ ./
RUN yarn build