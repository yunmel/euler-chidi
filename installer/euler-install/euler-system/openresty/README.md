# OpenResty  
  
  
## Docker Images
  
需要准备如下3个Docker镜像：  
  
`sem-openresty:0.2.0`  
`sem-redis:0.2.0`  
`sem-redis-web-console:0.2.0`  
  
## Install  
  
在K8S集群中创建openresty及其相关服务，登陆 K8S master 结点上执行如下命令（把当前目录下的文件上传至 ~/euler-sem-openresty）
  
	cd ~/euler-sem-openresty
	kubectl create namespace euler-system
	
	kubectl --namespace=euler-system create configmap sem-redis-configmap --from-file redis/configmap
	kubectl --namespace=euler-system create -f redis/master-svc.yaml
	kubectl --namespace=euler-system create -f redis/master-deployment.yaml
	kubectl --namespace=euler-system create -f redis/slave-svc.yaml
	kubectl --namespace=euler-system create -f redis/slave-deployment.yaml
	
	kubectl --namespace=euler-system create configmap sem-openresty-configmap --from-file openresty/configmap
	kubectl --namespace=euler-system create -f openresty/ds.yaml
	
	kubectl --namespace=euler-system get ds
	kubectl --namespace=euler-system get deployment
	kubectl --namespace=euler-system get rs
	kubectl --namespace=euler-system get pod
	
查看openresty的nginx配置：  
  
	for pod in `kubectl --namespace=euler-system get pod -l name=sem-openresty | tail -n +2 | cut -d' ' -f1`; do \
		echo "------$pod------"; \
		kubectl --namespace=euler-system get pod $pod -o 'go-template={{.status.hostIP}}{{"\n"}}'; \
		kubectl --namespace=euler-system exec -it $pod -- cat /app/configmap/nginx.conf; \
	done
  
  
## phpRedisAdmin  
  
 获取redis-master的phpRedisAdmin的外部端口：  
  
	kubectl --namespace=euler-system get svc  sem-redis-master -o 'go-template={{(index .spec.ports 1).nodePort}}{{"\n"}}'
	http://work-node:masterSvcNodePort/phpRedisAdmin/
  
  
## OpenResty logs
  
在master结点上执行下面命令：  
  
	for pod in `kubectl --namespace=euler-system get pod -l name=sem-openresty | tail -n +2 | cut -d' ' -f1`; do \
		echo "------$pod------"; \
		kubectl --namespace=euler-system get pod $pod -o 'go-template={{.status.hostIP}}{{"\n"}}'; \
		kubectl --namespace=euler-system logs $pod; \
	done
  
  
## Others  
  
可选操作，删除k8s对象：  
  
	kubectl --namespace=euler-system delete configmap sem-openresty-configmap
	kubectl --namespace=euler-system delete -f openresty/ds.yaml
	kubectl --namespace=euler-system delete configmap sem-redis-configmap
	kubectl --namespace=euler-system delete -f redis/slave-deployment.yaml
	kubectl --namespace=euler-system delete -f redis/slave-svc.yaml
	kubectl --namespace=euler-system delete -f redis/master-deployment.yaml
	kubectl --namespace=euler-system delete -f redis/master-svc.yaml
	
或者：
	
	kubectl --namespace=euler-system delete configmap sem-openresty-configmap
	kubectl --namespace=euler-system delete ds sem-openresty-ds
	kubectl --namespace=euler-system delete configmap sem-redis-configmap
	kubectl --namespace=euler-system delete svc sem-redis-master
	kubectl --namespace=euler-system delete svc sem-redis-slave
	kubectl --namespace=euler-system delete deployment sem-redis-master-dp
	kubectl --namespace=euler-system delete deployment sem-redis-slave-dp
	