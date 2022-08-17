#!/bin/bash

helpFunction()
{
   echo ""
   echo "Usage: $0 -s [start/stop] -c [containerName]"
   echo -e "\t-s [S]tart or [S]top command"
   echo -e "\t-c Container name"
   exit 1 # Exit script after printing help
}

while getopts "s:c:" opt
do
   case "$opt" in
      s) parameterS="$OPTARG" ;;
      c) parameterC="$OPTARG" ;;
      ?) helpFunction ;; # Print helpFunction in case parameter is non-existent
   esac
done

# Print helpFunction in case parameters are empty
if [ -z "$parameterS" ] || [ -z "$parameterC" ]
then
   echo "Some or all of the parameters are empty";
   helpFunction
fi

if [ $parameterS = "start" ]
then
   echo "Starting [$parameterC] container";
   docker rm --force $parameterC
   if [ $parameterC = "oracle-scl-db" ]
   then
      docker run -d -p 1521:1521 -v /home/focanowork/3FMeS-Cdc-Oracle/ora-db:/opt/oracle/oradata --network cdc_cdc --name oracle-scl-db gvenzl/oracle-xe
   fi

   if [ $parameterC = "rabbit-mq" ]
   then
      docker run -d -p 5672:5672 -p 15672:15672 --network cdc_cdc --name rabbit-mq rabbitmq:3.8.14-management
   fi

   if [ $parameterC = "zipkin-mysql" ]
   then
      docker run -d -p 3306:3306 --network cdc_cdc --name zipkin-mysql openzipkin/zipkin-mysql
   fi

   if [ $parameterC = "zipkin" ]
   then
      docker run -d -p 9411:9411 --network cdc_cdc --name zipkin -e STORAGE_TYPE=mysql -e MYSQL_HOST=zipkin-mysql -e MYSQL_USER=zipkin -e MYSQL_PASS=zipkin -e RABBIT_URI=amqp://guest:guest@rabbit-mq:5672 --restart always openzipkin/zipkin
   fi

   if [ $parameterC = "zipkin-dependencies" ]
   then
      docker run -d --network cdc_cdc --name zipkin-dependencies -e STORAGE_TYPE=mysql -e MYSQL_HOST=zipkin-mysql -e MYSQL_USER=zipkin -e MYSQL_PASS=zipkin openzipkin/zipkin-dependencies zipkin-dependencies-entrypoint.sh
   fi

   if [ $parameterC = "eureka-server" ]
   then
      docker run -d -p 8761:8761 --network cdc_cdc --name eureka-server 3fmes/eureka-server
   fi

   if [ $parameterC = "config-server" ]
   then
      docker run -d -p 8888:8888 -e GIT3CON_USER=mgabriel -e GIT3CON_PASS=Foc@nowork1 --network cdc_cdc --name config-server 3fmes/config-server
   fi
   
   if [ $parameterC = "gateway" ]
   then
      docker run -d -p 8765:8765 -e RABBIT_URI=amqp://guest:guest@rabbit-mq:5672 -e SPRING_RABBITMQ_HOST=rabbit-mq -e SPRING_ZIPKIN_SENDER_TYPE=rabbit --network cdc_cdc --name gateway 3fmes/fms-gateway
   fi

   if [ $parameterC = "instruments" ]
   then
      docker run -d -p 7001:8080 --network cdc_cdc --name instruments 3fmes/fms-instruments
   fi

   if [ $parameterC = "partaccts" ]
   then
      random=$$
      nr=$(($(($random%5000))+1))
      docker run -d -v /home/focanowork/volumes/log/partaccts:/opt/log -e LOG_LEVEL=info -e RABBIT_URI=amqp://guest:guest@rabbit-mq:5672 -e SPRING_RABBITMQ_HOST=rabbit-mq -e SPRING_ZIPKIN_SENDER_TYPE=rabbit --network cdc_cdc --name partaccts-$nr 3fmes/fms-partaccts
   fi

   if [ $parameterC = "accsync" ]
   then
      random=$$
      nr=$(($(($random%5000))+1))
      docker run -d -e RABBIT_URI=amqp://guest:guest@rabbit-mq:5672 -e SPRING_RABBITMQ_HOST=rabbit-mq -e SPRING_ZIPKIN_SENDER_TYPE=rabbit --network cdc_cdc --name accsync-$nr 3fmes/fms-accsync
   fi

   if [ $parameterC = "positions" ]
   then
      random=$$
      nr=$(($(($random%5000))+1))
      docker run -d -e RABBIT_URI=amqp://guest:guest@rabbit-mq:5672 -e SPRING_RABBITMQ_HOST=rabbit-mq -e SPRING_ZIPKIN_SENDER_TYPE=rabbit --network cdc_cdc --name positions-$nr 3fmes/fms-positions
   fi

   if [ $parameterC = "users" ]
   then
      random=$$
      nr=$(($(($random%5000))+1))
      docker run -d -e RABBIT_URI=amqp://guest:guest@rabbit-mq:5672 -e SPRING_RABBITMQ_HOST=rabbit-mq -e SPRING_ZIPKIN_SENDER_TYPE=rabbit --network cdc_cdc --name users-$nr 3fmes/fms-users
   fi

fi

if [ $parameterS = "stop" ]
then
   echo "Stoping [$parameterC] container";
   docker stop $parameterC
fi

