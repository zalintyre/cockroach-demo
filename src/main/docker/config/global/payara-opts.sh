#!/usr/bin/env sh

PAYARA_OPTS="$PAYARA_OPTS --port 8080"
PAYARA_OPTS="$PAYARA_OPTS --sslPort 8081"
PAYARA_OPTS="$PAYARA_OPTS --disablephonehome"
PAYARA_OPTS="$PAYARA_OPTS --deployDir /opt/payara/deployments/"
PAYARA_OPTS="$PAYARA_OPTS --addLibs /opt/payara/libs/"
PAYARA_OPTS="$PAYARA_OPTS --unpackdir /opt/payara/unpacked"
PAYARA_OPTS="$PAYARA_OPTS --rootdir /opt/payara/unpacked"
