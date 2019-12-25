#!/usr/bin/env bash

set -ex

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 && pwd)"
# shellcheck disable=SC1090
source "${DIR}"/_init.sh "${BASH_SOURCE[0]}"

echo "Build phase started"

./gradlew assemble
