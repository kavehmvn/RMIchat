package com.rmiChat.api;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author Kaveh
 *	the mediator to communicate with clients
 */

public interface IChatServer extends Remote {
	
	/**
	 * register each user to the user collection of the server.
	 * @param chatClient specific chat user
	 */	
	void registerChatClient(IChatClient chatClient) throws RemoteException;

	/**
	 * send message to other chat clients except the one that is the original sender.
	 * @param message, chat user
	 */	
	void sendMessage(String message, IChatClient client) throws RemoteException;

}
