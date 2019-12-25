#!/usr/bin/env bash

set -ex

# Arguments
SCRIPT_NAME=$1
SCRIPT_NAME=${SCRIPT_NAME##*/}

# Prefix echo output
if [ "$TRAVIS_PULL_REQUEST" != "false" ] && [ "$TRAVIS_PULL_REQUEST" != "" ]; then
  ECHO_PREFIX="[pr#${TRAVIS_PULL_REQUEST}]"
else
  ECHO_PREFIX="[${TRAVIS_BRANCH}]"
fi

exec > >(sed 's|^|'"${ECHO_PREFIX}"': |')
exec 2> >(sed 's|^|'"${ECHO_PREFIX}"': (stderr) |' >&2)
