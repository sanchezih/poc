# springboot-apikey-example
![Build](https://github.com/gregwhitaker/springboot-apikey-example/workflows/Build/badge.svg)

An example of authenticating with a Spring Boot application using an API key.

If you are looking for an example using WebFlux, please check out [springboot-webflux-apikey-example](https://github.com/gregwhitaker/springboot-webflux-apikey-example).

## Prerequisites
This example requires that you have a running [PostgreSQL](https://www.postgresql.org/) database. You can start one as a Docker container using the following commands:

    $ docker pull postgres
    $ docker run -p 5432:5432 postgres

## Running the Example
Follow the steps below to run the example:

1. Ensure you have a running PostgreSQL instance at `localhost:5432`.

2. Run the following command to start the example application:

        ./gradlew bootRun
        
3. Run the following command to send a request to the non-secure endpoint:

        curl -v http://localhost:8080/api/v1/nonsecure
        
    If successful, you will receive an `HTTP 200 OK` response.
    
4. Run the following command to send a request to the secure endpoint:

        curl -v http://localhost:8080/api/v1/secure
        
    You will receive an `HTTP 403 Forbidden` response because you have not supplied a valid API key.
    
5. Run the following command to send a request to the secure endpoint with an API key:

        curl -v --header "API_KEY: aec093c2c98144f99a4a365ad1d2f05e" http://localhost:8080/api/v1/secure
        
    If successful, you will now receive an `HTTP 200 OK` response because you have supplied a valid API key.

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/springboot-apikey-example/issues).

## License
Copyright 2019 Greg Whitaker

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.



577

You can run Postgres this way (map a port):

docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
So now you have mapped the port 5432 of your container to port 5432 of your server. -p <host_port>:<container_port> .So now your postgres is accessible from your public-server-ip:5432

To test: Run the postgres database (command above)

docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                     NAMES
05b3a3471f6f        postgres            "/docker-entrypoint.s"   1 seconds ago       Up 1 seconds        0.0.0.0:5432->5432/tcp    some-postgres
Go inside your container and create a database:

docker exec -it 05b3a3471f6f bash
root@05b3a3471f6f:/# psql -U postgres
postgres-# CREATE DATABASE mytest;
postgres-# \q
Go to your localhost (where you have some tool or the psql client).

psql -h public-ip-server -p 5432 -U postgres