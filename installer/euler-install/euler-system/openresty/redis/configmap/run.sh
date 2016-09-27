#!/bin/bash

if [ "${MASTER}" = "true" ]; then
  redis-server /app/configmap/redis.conf --protected-mode no
  exit 0
fi

if [ "${SLAVE}" = "true" ]; then
  redis-server /app/configmap/redis.conf --protected-mode no --slaveof ${SLAVE_OF_HOST} ${SLAVE_OF_PORT}
  exit 0
fi

