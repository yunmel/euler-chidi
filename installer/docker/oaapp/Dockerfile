#
# Copyright (c) 2001-2016 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

FROM euler-registry.primeton.com/ajs:1.0.0

# MAINTAINER www.primeton.com, registry@primeton.com

# org.war ROOT.war seeyon.war seeyonreport.war yyoa.war
# ADD resources/org.war ${TOMCAT_HOME}/webapps/
# ADD resources/ROOT.war ${TOMCAT_HOME}/webapps/
# ADD resources/seeyon.war ${TOMCAT_HOME}/webapps/
# ADD resources/seeyonreport.war ${TOMCAT_HOME}/webapps/
# ADD resources/yyoa.war ${TOMCAT_HOME}/webapps/

# unzip in external (optimization of the docker image size)
ADD resources/org/ ${TOMCAT_HOME}/webapps/org/
ADD resources/ROOT/ ${TOMCAT_HOME}/webapps/ROOT/
ADD resources/seeyon/ ${TOMCAT_HOME}/webapps/seeyon/
ADD resources/seeyonreport/ ${TOMCAT_HOME}/webapps/seeyonreport
ADD resources/yyoa/ ${TOMCAT_HOME}/webapps/yyoa/

#
# install license
#
ADD resources/license/a8v5.seeyonkey ${A8_HOME}/base/license/a8v5.seeyonkey
ADD resources/license/m1.seeyonkey ${TOMCAT_HOME}/webapps/seeyon/WEB-INF/classes/license/m1.seeyonkey
ADD resources/entrypoint.sh ${TOMCAT_HOME}/bin/entrypoint.sh

#
# ifconfig
#
RUN chmod +x ${TOMCAT_HOME}/bin/entrypoint.sh && yum install -y net-tools

# application configuration added at package-stage
