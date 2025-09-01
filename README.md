# api-docker-training

# Steps to build and Run the app
- 1.Create network group:
```cmd
docker network create myjava-pg
```
- 2.start postgres service
```cmd
docker-compose -f pg16-net-docker-compose.yml up
```
- 3.start redis service
```cmd
docker-compose -f redis-docker-compose.yml up
```
- 4.build docker image for api-docker-taring
```cmd
docker build -t api-docker-training .
```
- 5.run the docker image
```cmd
docker run --name api-docker-training --network myjava-pg -p 8080:8080 -e DB_HOST=postgres-db -e DB_PORT=5432 -e DB_NAME=db-docker-training -e DB_USER=admin -e DB_PASSWORD=admin -e SPRING_PROFILES_ACTIVE=pg -e REDIS_HOST=my-redis-instance -e REDIS_PORT=6379 -e REDIS_PASSWORD=admin -e REDIS_DB=4 --restart unless-stopped api-docker-training
```
- 6.app will be running on 8080 port
