#!/bin/sh
java -cp RMIchat-0.0.1-SNAPSHOT.jar com.rmiChat.server.ChatServerDriver 
trap 'sleep infinity' EXIT