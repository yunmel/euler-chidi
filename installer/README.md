# Euler-Chidi  
  
成勘院PaaS云平台定制
  
  
## docker  
  
应用`Docker`镜像模板以及`OA`等应用自定义  
  
  
## OA  
  
`OA`试点应用属于`传统巨无霸J2EE应用`，为优化部署方式，使用自定义Dockerfile进行编译`Docker`镜像，
只要上传应用配置（或通过源码的方式提交配置）即可通过`DevOps PaaS云平台`完成应用的部署工作。源码方式请参考：
[https://github.com/Primeton-Euler/Euler-Chidi/tree/master/OA](https://github.com/Primeton-Euler/Euler-Chidi/tree/master/OA)  
  
`# # OA Configuration`  
`# autoconf.war`  
`# |- Dockerfile`  
`# |- docker`  
`# | 	|- datasourceCtp.properties (-)(generate)`  
`# | 	|- extension.sh (-)(to do some work)`  
`# | 	|- ...`  
`# |- META`  
`# | 	|- autoconf`  
`# | 	| 	|- auto-config.xml`  
`# | 	| 	|- ...`  
`# | 	|- ...`  
  
`entrypoint.sh`  
	
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
	
## euler-install  
  
普元DevOps云平台安装脚本及配置文件，包括部署DevOps领域系统、第三方服务（mysql,sonatype/nexus,gitlab,etc）、Google Kubernetes。    
  
  