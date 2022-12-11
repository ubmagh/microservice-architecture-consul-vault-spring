#!/bin/bash

# this container was used during development, later i'll use docker-compose or K8s to automate this

docker pull consul:1.13.3

string=$( docker ps -a | grep 'consul-node' )
len=`expr length "$string"`

if [[ $len -gt 0 ]]
then
  echo "👉 deleting existing consul   container & volume"
  docker stop consul-node
  docker rm -v consul-node
fi

docker run -d --name consul-node --network bridge -p 8300:8300 -p 8301:8301  -p 8500:8500 -p 8600:8600 -p 8600:8600/udp -v consul-persistence-volume:/consul/data consul:1.13.3 agent -server -ui -node=server-1 -bootstrap-expect=1 -client=0.0.0.0
echo "🚀 Started consul-node container on : http://localhost:8500/"


