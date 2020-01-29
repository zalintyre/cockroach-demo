#!/usr/bin/env sh

PAYARA_OPTS="$PAYARA_OPTS --prebootcommandfile /opt/payara/config/preboot.asadmin"
PAYARA_OPTS="$PAYARA_OPTS --postbootcommandfile /opt/payara/config/postboot.asadmin"
PAYARA_OPTS="$PAYARA_OPTS --nocluster"
