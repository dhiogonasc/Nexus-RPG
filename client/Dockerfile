FROM nginx:stable-alpine
COPY ./dist /usr/share/nginx/html
RUN sed -i 's/listen       80;/listen       4200;/g' /etc/nginx/conf.d/default.conf
EXPOSE 4200
CMD ["nginx", "-g", "daemon off;"]