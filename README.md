# korpo-app

Spring Cloud Kubernetes requires access to the Kubernetes API in order to be able to retrieve a list of addresses for pods running for a single service, executing following helps:
```
kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default
```

Go to /k8s directory and install necessary charts:

```
helm install korpo-app-nginx -f ingress-values.yml stable/nginx-ingress
```
```
helm install korpo-app-mongodb -f mongodb-values.yml stable/mongodb
```

Add (minikube ip) to hosts file:
```
IP_OF_MINIKUBE microservices.info
```
Go to main directory and install application with:
```
skaffold run
```

Swagger Gateway UI URI: 
http://microservices.info:30261/gateway/swagger-ui.html
, where port 30261 is: korpo-app-nginx-nginx-ingress-controller http port.