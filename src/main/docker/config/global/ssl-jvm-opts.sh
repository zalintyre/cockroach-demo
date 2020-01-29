#!/usr/bin/env sh

JVM_OPTS="$JVM_OPTS -Djavax.net.ssl.keyStore=$KEYSTORE_PATH"
JVM_OPTS="$JVM_OPTS -Djavax.net.ssl.keyStorePassword=$KEYSTORE_PASSWORD"
JVM_OPTS="$JVM_OPTS -Djavax.net.ssl.keyStoreType=PKCS12"

JVM_OPTS="$JVM_OPTS -Djavax.net.ssl.trustStore=$TRUSTSTORE_PATH"
JVM_OPTS="$JVM_OPTS -Djavax.net.ssl.trustStorePassword=$TRUSTSTORE_PASSWORD"
JVM_OPTS="$JVM_OPTS -Djavax.net.ssl.trustStoreType=JKS"
