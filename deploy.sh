#!/bin/zsh
gradle build
docker build -t wschaefer42/calculator .
docker rm --force calculator
docker run --rm -d -p 8090:8089 --name calculator wschaefer42/calculator