package com.rmiChat.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * @author Kaveh
 * the main class to start the clients.
 */

public class ChatClientDriver {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Communicator communicator;
		
		// initializing the strategy of the startup according to the input('S' stands for single PID launch)
		if(args[0].equals("S")){
			System.out.println("Running in Single Thread mode.");
			communicator = new Communicator(new SinglePIDHandler());
		} 
		else{
			System.out.println("Running in Multithreading mode.");
			communicator = new Communicator(new MultiPIDHandler());
		}
		
		//start the chat between users.
		communicator.communicate(args);
	}
}
