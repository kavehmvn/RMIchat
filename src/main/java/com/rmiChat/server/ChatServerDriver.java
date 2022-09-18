package com.rmiChat.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Kaveh 
 * the main class to start the server and register the rmi services.
 * 
 */
public class ChatServerDriver {
	public static Registry registry;
	public static ChatServer chatserver;

	// luanch the server on a separate PID.
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		start();
	}

	// registering the rmi service on a specific port of the localhost.
	public static void start() throws RemoteException, MalformedURLException {
		System.out.println("Starting RMI server...");
		{
			try {
				chatserver = new ChatServer();
				registry = LocateRegistry.createRegistry(1099);
				registry.rebind("RMIChatServer", chatserver);
				System.out.println("RMI server running");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
