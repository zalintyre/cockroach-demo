#!/usr/bin/env sh

set +u

if [ -n "${DEBUG_ENABLED}" ]; then
    JVM_OPTS="$JVM_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9009"
fi

if [ -n "${PROFILER_ENABLED}" ]; then
    JVM_OPTS="$JVM_OPTS -agentpath:/opt/payara/agent/jprofiler11/bin/linux-x64/libjprofilerti.so=port=8849,nowait"
fi

set -u
