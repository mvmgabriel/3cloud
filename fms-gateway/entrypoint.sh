#!/bin/sh

while ! nc -z eureka-server 8761 ; do
    echo "Waiting for upcoming Eureka Server"
    sleep 10
done

while ! nc -z rabbit-mq 15672 ; do
    echo "Waiting for upcoming Rabbit MQ"
    sleep 10
done

java -Djava.security.egd=file:/dev/./urandom -jar /app.jar