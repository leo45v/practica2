# practica2

Can run docker-compose2.yml to get the images from docker hub.
``` 
docker compose -f docker-compose2.yml --build --force-recreate -d
```

In case of creating each image locally and not downloading from docker-hub:
```
docker compose up -d
```

Back-end
```
http://localhost:8080/swagger-ui.html
```
Connected with Postgress

front end
```
http://localhost/
```
just one angular app on one nginx server
