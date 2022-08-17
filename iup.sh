#!/bin/bash

initFunction()
{
   echo ""
   echo "Initializing PoC Infrastructure"
   echo ""
}

finishFunction()
{
   echo ""
   echo "Initializing PoC Infrastructure: [Ok]"
   echo ""
}

initFunction

cd /home/focanowork/workspaces/3fmes/arquitetura.poc.ja

./dup.sh -s start -c oracle-scl-db
sleep 30

./dup.sh -s start -c zipkin-mysql
sleep 15

./dup.sh -s start -c rabbit-mq
sleep 30

./dup.sh -s start -c zipkin
sleep 15

./dup.sh -s start -c config-server
sleep 15

./dup.sh -s start -c gateway
sleep 15

./dup.sh -s start -c eureka-server

finishFunction
