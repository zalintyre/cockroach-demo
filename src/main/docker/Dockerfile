FROM qaware/zulu-centos-payara-micro:8u232-5.194

ENV PAYARA_PATH /opt/payara

CMD ["--noCluster", "--prebootcommandfile", "/opt/payara/config/preboot.asadmin", "--postbootcommandfile", "/opt/payara/config/postboot.asadmin", "--deploymentDir", "/opt/payara/deployments", "--addlibs", "/opt/payara/libs"]

COPY config $PAYARA_PATH/config
COPY libs/payara/*.jar $PAYARA_PATH/libs/

COPY deployments/ $PAYARA_PATH/deployments
