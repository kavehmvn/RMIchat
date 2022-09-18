package com.rmiChat.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.rmiChat.api.IHandler;


/**
 * @author Kaveh
 * the context class of the strategy pattern, responsible to start the client in single or multithread mode.
 */

public class Communicator {
	private IHandler handler;

	public Communicator(IHandler handler) {
		super();
		this.handler = handler;
	}

	// the method is responsible to call the given strategy to launch the app.
	public void communicate(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		System.out.println("please type your message...");
		handler.handle(args);
	}
}
