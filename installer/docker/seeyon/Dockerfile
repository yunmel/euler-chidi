FROM euler-registry.primeton.com/centos

RUN localedef -c -i zh_CN -f UTF-8 zh_CN.UTF-8

RUN echo '' >> /etc/bashrc \
    && echo 'export LANGUAGE="zh_CN.UTF-8"' >> /etc/bashrc \
    && echo 'export LANG="zh_CN.UTF-8"' >> /etc/bashrc

RUN echo 'LANG="zh_CN.UTF-8"' >> /etc/sysconfig/i18n \
	&& cp -f /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
	&& unalias -a cp \
	&& yum -y install unzip

# TOMCAT_HOME
ENV AJS_HOME=/home/v5/ApacheJetspeed

# WORKDIR /home

# ARG baseZipFileName
# if use this way too large
# ADD ${baseZipFileName} /home/zip/

# RUN unzip -q -n /home/zip/${baseZipFileName} -d /home/v5 \
#	&& rm -f /home/zip/${baseZipFileName} \
ADD ApacheJetspeed/ ${AJS_HOME}/
ADD jdk /home/v5/jdk/

RUN mkdir -p ${AJS_HOME}/files \
	&& chmod +x /home/v5/jdk/bin/* \
	&& chmod +x /home/v5/jdk/jre/bin/* \
	&& chmod +x ${AJS_HOME}/bin/*.sh \
	&& rm -rf ${AJS_HOME}/webapps/* \
	&& cp -f ${AJS_HOME}/bin/libRY3Java-64.so ${AJS_HOME}/bin/libRY3Java.so \
	&& sed -i 's/exec "\$PRGDIR"\/"\$EXECUTABLE" start "\$@"/exec "$PRGDIR"\/"$EXECUTABLE" run "$@"/' /home/v5/ApacheJetspeed/bin/startup.sh

WORKDIR ${AJS_HOME}/bin
