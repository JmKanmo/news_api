#!/bin/bash

java -jar -Dwhatap.oname=news_api -javaagent:/home/ec2-user/whatap/whatap_agent/news_api_whatap/whatap.agent-2.2.24.jar news_api-1.0.war &