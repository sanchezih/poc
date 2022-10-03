# poc-ss-api-key-based-auth-01-restapi

An example of authenticating with a Spring Boot application using an API key.

## Prerequisites
This example requires that you have a running [PostgreSQL](https://www.postgresql.org/) database. You can start one as a Docker container using the following commands:

You can run Postgres this way (map a port):

    $ docker run --name motor-postgres-poc -e POSTGRES_PASSWORD=Mysecretpassword1234! -d -p 5432:5432 postgres:14

So now you have mapped the port 5432 of your container to port 5432 of your server. -p <host_port>:<container_port>. So now your postgres is accessible from your public-server-ip:5432

To test: Run the postgres database (command above)

    $ docker ps
        
    CONTAINER ID   IMAGE      COMMAND                  CREATED         STATUS         PORTS                                                   NAMES
    6dc74930df1c   postgres   "docker-entrypoint.s…"   4 minutes ago   Up 4 minutes   5432/tcp, 0.0.0.0:5432->54320/tcp, :::5432->54320/tcp   motor-postgres-poc

Go inside your container and create a database:

    $ docker exec -it <CONTAINER_ID> bash
    $ root@<CONTAINER_ID>:/# psql -U postgres
    $ postgres-# CREATE DATABASE pocssapikey;
    $ postgres-# \q

Go to your localhost (where you have some tool or the psql client).
Host: <DATABASE_HOST>
Port: 5432
Database: pocssapikey
Username: postgres
Password: Mysecretpassword1234!

## Running the Example
Follow the steps below to run the example:

1. Ensure you have a running PostgreSQL instance at `<DATABASE_IP>:5432`.

3. Run the following command to start the example application:

       $ mvn spring-boot:run

4. Run the following command to send a request to the non-secure endpoint:

       $ curl -v http://localhost:8080/api/v1/nonsecure

    If successful, you will receive an `HTTP 200 OK` response.
    
5. Run the following command to send a request to the secure endpoint:

       $ curl -v http://localhost:8080/api/v1/secure
        
    You will receive an `HTTP 403 Forbidden` response because you have not supplied a valid API key.
    
6. Run the following command to send a request to the secure endpoint with an API key:

       $ curl -v --header "api-key: aec093c2c98144f99a4a365ad1d2f05e" http://localhost:8080/api/v1/secure
        
    If successful, you will now receive an `HTTP 200 OK` response because you have supplied a valid API key.
