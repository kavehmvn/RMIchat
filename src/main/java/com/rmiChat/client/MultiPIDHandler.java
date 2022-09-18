package com.rmiChat.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmiChat.api.IChatServer;
import com.rmiChat.api.IHandler;


/**
 * @author Kaveh
 * concrete strategy to run the application in multiple PID mode.
 * 
 */
public class MultiPIDHandler implements IHandler {
	
	// the method launch the application in multiple PIDs, launching server and clients on different PIDs.
	public void handle(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		
		String chatServerURL = "rmi://localhost/RMIChatServer";
		IChatServer chatServer = (IChatServer)Naming.lookup(chatServerURL);
		
		// for each given user start a client thread responsible for a user.
		for (int i = 1; i < args.length; i++) {
			new Thread(new ChatClient(args[i], chatServer, 10)).start();
		}
	}

}
