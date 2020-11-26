FROM nginx:latest
LABEL rubenskj nginx
COPY /client/build /usr/share/nginx/html
COPY /client/.env /usr/share/nginx/html
COPY /docker/config/nginx.conf /etc/nginx/nginx.conf
RUN chmod 755 -R /usr/share/nginx/html
EXPOSE 80 443
ENTRYPOINT ["nginx"]
# Parametros extras para o entrypoint
CMD ["-g", "daemon off;"]