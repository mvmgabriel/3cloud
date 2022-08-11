#!/bin/sh

while ! nc -z oracle-scl-db 1521 ; do
    echo "Waiting for upcoming Oracle DB"
    sleep 10
done

while ! nc -z eureka-server 8761 ; do
    echo "Waiting for upcoming Eureka Server"
    sleep 10
done

while ! nc -z config-server 8888 ; do
    echo "Waiting for upcoming Config Server"
    sleep 10
done

while ! nc -z rabbit-mq 15672 ; do
    echo "Waiting for upcoming Rabbit MQ 15672"
    sleep 10
done
while ! nc -z rabbit-mq 5672 ; do
    echo "Waiting for upcoming Rabbit MQ 5672"
    sleep 10
done

java -Djava.security.egd=file:/dev/./urandom -jar app.jar