#!/bin/bash

SERVER=567233e54423f8a8ca001d3c@sun-dubu.cloudsc.kr
SSH_KEY=~/.ssh/id_open
WEB_HOME=/var/lib/openshift/567233e54423f8a8ca001d3c/egovframework

git pull
mvn clean package -Dmaven.test.skip=true
scp -i $SSH_KEY target/springboot-shop.war $SERVER:$WEB_HOME

SSH="ssh -o StrictHostKeyChecking=no"
$SSH -i $SSH_KEY $SERVER unzip -o $WEB_HOME/springboot-shop.war -d $WEB_HOME/webapps/ROOT
$SSH -i $SSH_KEY $SERVER gear stop tomcat
$SSH -i $SSH_KEY $SERVER gear start tomcat

