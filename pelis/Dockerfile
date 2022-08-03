FROM node as node-pelis

WORKDIR /pelis-app

#COPY package.json package-lock.json ./
COPY . ./

RUN npm i
RUN npm run build -- --prod 




FROM nginx:1.12-alpine

EXPOSE 80
#!/bin/sh
#COPY ./default.conf /etc/nginx/nginx.conf

RUN rm -rf /usr/share/nginx/html/*
#RUN rm -rf /usr/share/nginx/html/*

COPY --from=node-pelis /pelis-app/dist/pelis /usr/share/nginx/html
#COPY --from=node-pelis /pelis-app/default.conf /etc/nginx/conf.d/default.conf


# CMD ["nginx", "-g", "daemon off;"]


