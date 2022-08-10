#!/bin/bash

while ! nc -z oracle-scl-db 1521 ; do
    echo "Waiting for upcoming Oracle DB"
    sleep 2
done

java -Djava.security.egd=file:/dev/./urandom -jar /app.jar