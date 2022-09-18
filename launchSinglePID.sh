#!/bin/sh
java -cp RMIchat-0.0.1-SNAPSHOT.jar com.rmiChat.client.ChatClientDriver $"S" $"initiator" $"receiver"
trap 'sleep infinity' EXIT