package com.rmiChat.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import com.rmiChat.api.IChatClient;
import com.rmiChat.api.IChatServer;

/**
 * @author Kaveh 
 * the concrete colleague class, every instance of this class will be a chat user.
 * 
 */

public class ChatClient extends UnicastRemoteObject implements IChatClient,
		Runnable {

	private static final long serialVersionUID = 1L;
	private IChatServer chatServer;
	private String name;
	private Integer cnt;
	private Integer stopCondition;

	public ChatClient(String name, IChatServer chatServer, Integer stopCondition)
			throws RemoteException {
		super();
		this.name = name;
		this.chatServer = chatServer;
		this.cnt = 0;
		this.stopCondition = stopCondition;
		chatServer.registerChatClient(this);
	}

	// this method is responsible to print the received message of a specific user.
	public void receiveMessage(String message) throws RemoteException {
		if (stopReceiving())
			return;
		System.out.println(this.getName() + " received: " + message);
		reply(message);
	}

	// this message is the entry point to start communicating with other users.
	public void run() {
		sendMessage();
	}	

	// the method is responsible to send the typed message to the server in order to be coordinated to other receivers.
	// the method will only send 10 messages according to the requirement of the task.
	public void sendMessage() {
		Scanner scan = new Scanner(System.in);
		String message;

		while (!stopSending()) {
				message = scan.nextLine();
				try {
					if(cnt == 0)
						cnt++;
					chatServer.sendMessage(message, this);
				} catch (Exception e) {
					e.printStackTrace();
					// scan.close();
				}
		}
		scan.close();
		
	}
	
	// the method is responsible to reply after a messaged a received, concatenating the received message with the send counter.
	private void reply(String message) throws RemoteException {
		if (stopSending())
			return;
		message += cnt;
		cnt++;
		chatServer.sendMessage(message, this);
	}

	private boolean stopSending() {		
		return cnt == stopCondition;
	}
	
	private boolean stopReceiving() {		
		return cnt > stopCondition;
	}
	
	@Override
	public String getName() throws RemoteException {
		return this.name;
	}
}
