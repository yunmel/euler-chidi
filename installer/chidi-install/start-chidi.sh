#!/bin/bash

#docker run -d --name chidi -p 8089:8089 -v /mnt/chidi:/usr/src euler-registry.primeton.com/jdk8:1.0.0 java -jar /usr/src/bootstrap.jar -DDATA_DIR=/usr/src/

docker run -d --name euler-chidi -p 8089:8089 -v /mnt/euler-chidi:/app/lib -v /mnt/euler-chidi/user_script:/opt/user_script euler-registry.primeton.com/springboot:1.0.0
