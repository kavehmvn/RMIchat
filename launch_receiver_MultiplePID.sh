#!/bin/sh
java -cp RMIchat-0.0.1-SNAPSHOT.jar com.rmiChat.client.ChatClientDriver $"M" $"receiver"
trap 'sleep infinity' EXIT