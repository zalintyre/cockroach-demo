COCKROACHDB_CLUSTER_NAME=cockroachdb
COCKROACHDB_STATEFULSET=cockroachdb
COCKROACHDB_DEPLOYMENT=cockroach
COCKROACHDB_RELEASE_NAME=cockroach-demo
COCKROACHDB_REPLICAS=3
IMAGE_NAME=cockroach-demo:latest
IMAGE_NAME_GKE=gcr.io/cnn-cloudnativepersistence-2/cockroach-demo:latest
GKE_MACHINE_TYPE=n1-standard-4
GKE_COMPUTE_ZONE=europe-west4
GKE_NODES=5
GKE_EMAIL=franz.wimmer@qaware.de
GKE_PROJECT=cnn-cloudnativepersistence-2
YAML_DIR=./src/main/kubernetes

.PHONY: connect-cluster
connect-cluster:
	gcloud config set project ${GKE_PROJECT}
	gcloud config set compute/zone ${GKE_COMPUTE_ZONE}

.PHONY: scale-up
scale-up:
	gcloud --quiet container clusters resize ${COCKROACHDB_CLUSTER_NAME} --num-nodes=${GKE_NODES}

.PHONY: scale-down
scale-down:
	helm delete ${COCKROACHDB_RELEASE_NAME}
	gcloud --quiet container clusters resize ${COCKROACHDB_CLUSTER_NAME} --num-nodes=0

.PHONY: create-cluster
create-cluster:
	# gcloud projects create ${GKE_PROJECT}
	gcloud config set project ${GKE_PROJECT}
	gcloud config set compute/zone ${GKE_COMPUTE_ZONE}
	gcloud container clusters create ${COCKROACHDB_CLUSTER_NAME} --num-nodes=${GKE_NODES} --machine-type ${GKE_MACHINE_TYPE} --node-locations ${GKE_COMPUTE_ZONE}-a
	kubectl create clusterrolebinding $USER-cluster-admin-binding --clusterrole=cluster-admin --user=${GKE_EMAIL}

.PHONY: destroy-cluster
destroy-cluster:
	gcloud --quiet projects delete ${GKE_PROJECT}

.PHONY: provision
provision:
	helm install --replace ${COCKROACHDB_RELEASE_NAME} --values ./src/main/kubernetes/my-values.yaml stable/cockroachdb
	@echo Verifying the cluster was started
	kubectl get pods
	@echo Verifying the persistent volumes were created
	kubectl get pv

.PHONY: helm-update
helm-update:
	helm repo add stable https://kubernetes-charts.storage.googleapis.com
	helm repo update

.PHONY: sql-client
sql-client:
	kubectl apply -f ${YAML_DIR}/client-secure.yaml
	kubectl exec -it cockroachdb-client-secure -- ./cockroach sql --certs-dir=/cockroach-certs --host=${COCKROACHDB_STATEFULSET}-public

.PHONY: app
app:
	@echo "Building app"
	./gradlew build

.PHONY: image
image: app
	@echo "Building docker image ${IMAGE_NAME}"
	docker build -t ${IMAGE_NAME} ./build/docker

.PHONY: tag-and-push
tag-and-push: image
	@echo "Pushing Docker image ... this may take some time."
	docker tag ${IMAGE_NAME} ${IMAGE_NAME_GKE}
	docker push ${IMAGE_NAME_GKE}

.PHONY: deploy
deploy: tag-and-push
	kubectl apply -f ${YAML_DIR}/deployment.yaml
	kubectl apply -f ${YAML_DIR}/service.yaml
	kubectl patch deployment ${COCKROACHDB_DEPLOYMENT} -p "{\"spec\": {\"template\": {\"metadata\": { \"labels\": {  \"redeploy\": \"$(shell date +%s)\"}}}}}"