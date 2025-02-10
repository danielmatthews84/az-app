# az-service
API for the az-app

## how to build and run

`./mvnw clean test` (clean build and test)

`./mvnw compile jib:dockerBuild` (build an image to your local Docker daemon)

`docker run -p 8080:8080 az-service:latest`

or just use IntelliJ ;-)