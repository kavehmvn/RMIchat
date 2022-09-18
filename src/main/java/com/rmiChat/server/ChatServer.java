package com.rmiChat.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.rmiChat.api.IChatClient;
import com.rmiChat.api.IChatServer;

/**
 * @author Kaveh the concrete mediator, responsible to make communications
 *         between clients available.
 */
public class ChatServer extends UnicastRemoteObject implements IChatServer {
	private static final long serialVersionUID = 1L;

	// knows about its user clients (plays the colleague role in mediator pattern).
	private ArrayList<IChatClient> chatClients;

	protected ChatServer() throws RemoteException {
		super();
		chatClients = new ArrayList<IChatClient>();
	}

	// register the clients to the server's list of clients collection
	public void registerChatClient(IChatClient chatClient) throws RemoteException {
		this.chatClients.add(chatClient);
	}

	// sending the input message the clients other than the actual sender.
	public void sendMessage(String message, IChatClient client) throws RemoteException {
		int i = 0;
		while (i < chatClients.size()) {
			IChatClient concreteClient = chatClients.get(i++);
			if (!concreteClient.getName().equals(client.getName())) {
				concreteClient.receiveMessage(message);
			}
		}

	}

}
