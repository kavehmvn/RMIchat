package com.rmiChat.api;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author Kaveh
 * the colleague interface
 */
public interface IChatClient extends Remote {

	/**
	 * receive and print messages from other users.
	 * @param message
	 */
	void receiveMessage(String message) throws RemoteException;

	/**
	 * return the name of a specific chat user.
	 * @return userName
	 */
	String getName() throws RemoteException;
	
}
