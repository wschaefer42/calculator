#!/bin/zsh
test $(curl localhost:8089/add"?a=1&b=2") -eq 3