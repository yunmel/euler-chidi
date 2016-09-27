#!/bin/bash

#
# Copyright (c) 2001-2016 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

if [ -z ${TOMCAT_HOME} ]; then
	echo "Error, TOMCAT_HOME environment variable not found."
	exit 1
fi

#
# Java Remote Debug Enable
#
if [ -z "${USE_DEBUG_PORT}" ]; then
    USE_DEBUG_PORT=false
fi

#
# auto-config if exists environment 'P_APP_ENV'
# {"key1": "value1", ..., "keyn": "valuen"}
#
${TOMCAT_HOME}/bin/autoconfig.sh ${TOMCAT_HOME}/webapps

#
# chidi custom settings
#
ulimit -n 65535
export LANG=zh_CN.GBK
if [ -d ${TOMCAT_HOME}/work/Catalina ]; then
    rm -rf ${TOMCAT_HOME}/work/Catalina
fi

# Memory Limit
if [ -z "${MEM_MIN}" ]; then
    MEM_MIN=512
fi
if [ -z "${MEM_MAX}" ]; then
    MEM_MAX=2048
fi

JAVA_OPTS="${JAVA_OPTS} -Xms${MEM_MIN}m -Xmx${MEM_MAX}m"
JAVA_OPTS="${JAVA_OPTS} -Xss1m -XX:NewSize=384M -XX:MaxNewSize=384M -XX:MaxMetaspaceSize=512m -XX:SurvivorRatio=32"
JAVA_OPTS="${JAVA_OPTS} -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:TargetSurvivorRatio=50"
if [ -n "${LD_LIBRARY_PATH}" ] && [ -d ${LD_LIBRARY_PATH} ]; then
    JAVA_OPTS="${JAVA_OPTS} -Dcom.sun.management.jmxremote -Djava.library.path=${CATALINA_HOME}/bin:${LD_LIBRARY_PATH}"
else
    JAVA_OPTS="${JAVA_OPTS} -Dcom.sun.management.jmxremote -Djava.library.path=${CATALINA_HOME}/bin"
fi
JAVA_OPTS="${JAVA_OPTS} -DA8.datasource.properies.filepath=${A8_HOME}/base/conf/datasourceCtp.properties"
JAVA_OPTS="${JAVA_OPTS} -Dsun.rmi.dgc.client.gcInterval=21600000 -Dsun.rmi.dgc.server.gcInterval=21600000"
JAVA_OPTS="${JAVA_OPTS} -Djava.awt.headless=true -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=java_pid.hprof"
JAVA_OPTS="${JAVA_OPTS} -Djava.net.preferIPv4Stack=true -Dorg.apache.el.parser.COERCE_TO_ZERO=true"
JAVA_OPTS="${JAVA_OPTS} -Djgroups.bind_addr=0.0.0.0 -DDEE_HOME=${A8_HOME}/base/dee/ -Dfile.encoding=utf-8"

# Common JVM Settings
# JAVA_OPTS="${JAVA_OPTS} -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled"
# JAVA_OPTS="${JAVA_OPTS} -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8"
# JAVA_OPTS="${JAVA_OPTS} -XX:+DisableExplicitGC -XX:-OmitStackTraceInFastThrow -Djava.net.preferIPv4Stack=true"
# JAVA_OPTS="${JAVA_OPTS} -Dfile.encoding=utf-8"

# Java Remote Debug Enabled
if [ "true" == "${USE_DEBUG_PORT}" ]; then
    JAVA_OPTS="${JAVA_OPTS} -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888"
fi

echo "JAVA_HOME=${JAVA_HOME}"

# JAVA_OPTS="${JAVA_OPTS} -Djava.util.logging.config.file=${TOMCAT_HOME}/conf/logging.properties"
# JAVA_OPTS="${JAVA_OPTS} -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager"
# JAVA_OPTS="${JAVA_OPTS} -Djava.endorsed.dirs=${TOMCAT_HOME}/endorsed"
# JAVA_OPTS="${JAVA_OPTS} -Dcatalina.base=${TOMCAT_HOME}"
# JAVA_OPTS="${JAVA_OPTS} -Dcatalina.home=${TOMCAT_HOME}"
# JAVA_OPTS="${JAVA_OPTS} -Djava.io.tmpdir=${TOMCAT_HOME}/temp"
# JAVA_OPTS="${JAVA_OPTS} -classpath ${TOMCAT_HOME}/bin/bootstrap.jar:${TOMCAT_HOME}/bin/tomcat-juli.jar"

# ${JAVA_HOME}/bin/java -server ${JAVA_OPTS} org.apache.catalina.startup.Bootstrap start

export JAVA_OPTS
${TOMCAT_HOME}/bin/catalina.sh run "$@"