#!/bin/bash

ROOT_PATH="/home/ec2-user/backend"
JAR="$ROOT_PATH/application.jar"
APP_LOG="$ROOT_PATH/application.log"
ERROR_LOG="$ROOT_PATH/error.log"
START_LOG="$ROOT_PATH/start.log"
NOW=$(date +%c)

echo "[$NOW] $JAR 복사" >> $START_LOG
cp "$ROOT_PATH/build/libs/backend.jar" "$JAR"

echo "[$NOW] > $JAR 실행" >> $START_LOG
nohup java -Duser.timezone=Asia/Seoul -jar $JAR > $APP_LOG 2> $ERROR_LOG &

SERVICE_PID=$(pgrep -f $JAR)
echo "[$NOW] > 서비스 PID: $SERVICE_PID" >> $START_LOG