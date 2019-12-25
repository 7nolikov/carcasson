#!/usr/bin/env bash

set -ex

# Set Travis git author name
export TRAVIS_COMMIT_AUTHOR_NAME="Travis CI"
git config user.name "$TRAVIS_COMMIT_AUTHOR_NAME"

# Set Travis git author email
export TRAVIS_COMMIT_AUTHOR_EMAIL="travis@travis-ci.org"
git config user.email "$TRAVIS_COMMIT_AUTHOR_EMAIL"

# Get last commit author name
TRAVIS_LAST_COMMIT_AUTHOR_NAME="$(git log -1 "$TRAVIS_COMMIT" --pretty="%aN" || echo  '')"
export TRAVIS_LAST_COMMIT_AUTHOR_NAME=$TRAVIS_LAST_COMMIT_AUTHOR_NAME

# Get last commit author email
TRAVIS_LAST_COMMIT_AUTHOR_EMAIL="$(git log -1 "$TRAVIS_COMMIT" --pretty="%cE" || echo '')"
export TRAVIS_LAST_COMMIT_AUTHOR_EMAIL=$TRAVIS_LAST_COMMIT_AUTHOR_EMAIL
