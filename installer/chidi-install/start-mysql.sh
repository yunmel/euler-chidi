#!/bin/bash

docker run -d --restart always --name chidi-mysql -p 33306:3306 \
        -v /mnt/euler-chidi/mysql/data:/var/lib/mysql -v /mnt/euler-chidi/mysql/config:/etc/mysql/conf.d \
        -e MYSQL_DATABASE="test" -e MYSQL_ROOT_PASSWORD="root" \
        -e MYSQL_USER="mysql" -e MYSQL_PASSWORD="mysql" \
        euler-registry.primeton.com/mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

