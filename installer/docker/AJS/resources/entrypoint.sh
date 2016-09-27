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

# Memory Limit
if [ -z "${MEM_MIN}" ]; then
    MEM_MIN=1024
fi
if [ -z "${MEM_MAX}" ]; then
    MEM_MAX=2048
fi

# Java Remote Debug Enabled
if [ "true" == "${USE_DEBUG_PORT}" ]; then
    JAVA_OPTS="${JAVA_OPTS} -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888"
fi

# extension script
if [ -x ${TOMCAT_HOME}/bin/extension.sh ]; then
    ${TOMCAT_HOME}/bin/extension.sh
fi

export MEM_MIN
export MEM_MAX
export JAVA_OPTS

${TOMCAT_HOME}/bin/startup.sh