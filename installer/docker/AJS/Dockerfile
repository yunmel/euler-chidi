#
# Copyright (c) 2001-2016 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

FROM euler-registry.primeton.com/seeyon:v560

# MAINTAINER www.primeton.com, registry@primeton.com

ENV TOMCAT_HOME=${AJS_HOME}
ENV EULER_CI_TOOL=/usr/lib/euler-ci-tool.jar
ENV SERVICE_PORT=8080
ENV DEBUG_PORT=8888
ENV A8_HOME=/home/v5
ENV JAVA_HOME=${A8_HOME}/jdk
ENV JRE_HOME=${JAVA_HOME}
ENV PATH=${PATH}:${JAVA_HOME}/bin

ADD resources/entrypoint.sh ${TOMCAT_HOME}/bin/
ADD resources/autoconfig.sh ${TOMCAT_HOME}/bin/
ADD resources/catalina_custom.sh ${TOMCAT_HOME}/bin/
ADD resources/startup.sh ${TOMCAT_HOME}/bin/
ADD resources/euler-ci-tool.jar ${EULER_CI_TOOL}

RUN chmod +x ${TOMCAT_HOME}/bin/*.sh


# If need debug, docker run with param "-p 8888:8888 -e JAVA_OPTS='-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888'"
# or "-p 8888:8888 -e USE_DEBUG_PORT=true"
# listen 8080, debug 8888
EXPOSE ${SERVICE_PORT} ${DEBUG_PORT}

ENTRYPOINT ["/bin/sh", "-c", "${TOMCAT_HOME}/bin/entrypoint.sh"]