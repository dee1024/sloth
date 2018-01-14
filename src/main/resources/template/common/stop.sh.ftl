#!/bin/bash
PID=$(cat ./${projectName}.pid)
kill -9 $PID
