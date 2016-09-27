#
# Copyright (c) 2001-2016 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

FROM euler-registry.primeton.com/oaapp:1.0.0

#
# extension.sh for you to do some work
# 
ADD docker/extension.sh ${TOMCAT_HOME}/bin/extension.sh

RUN chmod +x ${TOMCAT_HOME}/bin/extension.sh

#
# install license
#
# ADD resources/license/a8v5.seeyonkey ${A8_HOME}/base/license/a8v5.seeyonkey
# ADD resources/license/m1.seeyonkey ${TOMCAT_HOME}/webapps/seeyon/WEB-INF/classes/license/m1.seeyonkey

# or use extension.sh copy configuration file to destination
ADD docker/datasourceCtp.properties ${A8_HOME}/base/conf/datasourceCtp.properties

# TODO ...
# ADD other resources