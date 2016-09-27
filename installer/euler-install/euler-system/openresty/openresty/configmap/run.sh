#!/bin/bash

#eval "_HOST=\${$REDIS_HOST}"
#eval "_PORT=\${$REDIS_PORT}"

RESOLVER=`grep 'nameserver' /etc/resolv.conf | cut -d' ' -f2`
REDIS_HOST_SUFFIX=`grep 'search' /etc/resolv.conf | cut -d' ' -f2`

sed -i 's/%resolver%/'${RESOLVER}'/g' /app/configmap/nginx.conf
sed -i 's/%redis_slave_svc_host%/'${REDIS_HOST}'.'${REDIS_HOST_SUFFIX}'/g' /app/configmap/nginx.conf
sed -i 's/%redis_slave_svc_port%/'${REDIS_PORT}'/g' /app/configmap/nginx.conf

nginx  -c /app/configmap/nginx.conf -g "daemon off;"

