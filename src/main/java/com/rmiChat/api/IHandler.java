package com.rmiChat.api;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * @author Kaveh
 * the strategy interface.
 */
public interface IHandler{
	
	/**
	 * launch the application acording to the strategy chosen on runtime either single PID or multiPID.
	 * @param args (index0 is the indicator of the strategy, index>0 is the clients usernames)
	 */
	void handle(String[] args) throws MalformedURLException, RemoteException, NotBoundException;
}