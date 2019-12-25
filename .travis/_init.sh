#!/usr/bin/env bash

set -ex

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 && pwd)"

# shellcheck disable=SC1090
source "${DIR}"/helpers/git.sh
# shellcheck disable=SC1090
source "${DIR}"/helpers/gradle.sh

# shellcheck disable=SC1090
source "${DIR}"/helpers/echo.sh "$1"
