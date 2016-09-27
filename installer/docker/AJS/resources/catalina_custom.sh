#!/bin/bash

# Memory Limit
if [ -z "${MEM_MIN}" ]; then
    MEM_MIN=1024
fi
if [ -z "${MEM_MAX}" ]; then
    MEM_MAX=2048
fi

JAVA_OPTS="${JAVA_OPTS} -Xms${MEM_MIN}m -Xmx${MEM_MAX}m -Xss1m -XX:NewSize=384M -XX:MaxNewSize=384M -XX:MaxMetaspaceSize=512m -XX:SurvivorRatio=32 -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:TargetSurvivorRatio=50 -Dcom.sun.management.jmxremote -DA8.datasource.properies.filepath=""$A8_HOME""/base/conf/datasourceCtp.properties -Dsun.rmi.dgc.client.gcInterval=21600000 -Dsun.rmi.dgc.server.gcInterval=21600000 -Djava.awt.headless=true -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=java_pid.hprof -Djava.net.preferIPv4Stack=true -Dorg.apache.el.parser.COERCE_TO_ZERO=true -Djgroups.bind_addr=0.0.0.0 -DDEE_HOME=""$A8_HOME""/base/dee/"
JAVA_OPTS="${JAVA_OPTS} -Dfile.encoding=utf-8"
if [ -n "${LD_LIBRARY_PATH}" ]; then
    JAVA_OPTS="${JAVA_OPTS} -Djava.library.path=""$CATALINA_HOME""/bin:$LD_LIBRARY_PATH"
fi