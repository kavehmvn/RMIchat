package com.rmiChat.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmiChat.api.IChatServer;
import com.rmiChat.api.IHandler;
import com.rmiChat.server.ChatServerDriver;


/**
 * @author Kaveh
 * concrete strategy to run the application in single PID mode.
 */
public class SinglePIDHandler implements IHandler {

	// the method launch the application in single PID, launching server and clients on the same PID.
	@Override
	public void handle(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		// start the server on the same PID as clients.
		ChatServerDriver.start();
		
		String chatServerURL = "rmi://localhost/RMIChatServer";
		IChatServer chatServer = (IChatServer)Naming.lookup(chatServerURL);
		
		// for each given user start a client thread responsible for a user.
		for (int i = 1; i < args.length; i++) {
			new Thread(new ChatClient(args[i], chatServer, 10)).start();
		}
	}

}
