# keycloak-helm-poc
Random stuff to get little knowledge about kubernetes keycloak with integration with spring boot.
## Launch neccessary stuff

Start minikube
```
minikube start
```
### Launch keycloak
```
helm install poc-keycloak --set keycloak.persistence.deployPostgres=true,keycloak.persistence.dbVendor='postgres',postgresql.persistence.enabled=true,keycloak.password='admin' codecentric/keycloak

kubectl port-forward svc/poc-key-http 8080:80
```

Go to:
http://127.0.0.1:8080/auth/

Login with the following credentials:
Username: keycloak

To retrieve the initial user password run:
```
kubectl get secret --namespace default poc-key-http -o jsonpath="{.data.password}" | base64 --decode; echo
```
### Launch app