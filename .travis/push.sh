#!/usr/bin/env bash

set -ex

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 && pwd)"
# shellcheck disable=SC1090
source "${DIR}"/_init.sh "${BASH_SOURCE[0]}"

if [ "$TRAVIS_BRANCH" != "master" ]; then
  echo "Skipping push phase bacause of it is available only for the master branch"
  exit 0;
fi

echo "Push phase started"

./gradlew release -Prelease.useAutomaticVersion=true

git push origin master
