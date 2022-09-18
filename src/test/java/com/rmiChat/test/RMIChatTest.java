package com.rmiChat.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.rmiChat.api.IChatServer;
import com.rmiChat.client.ChatClient;
import com.rmiChat.server.ChatServerDriver;


@RunWith(MockitoJUnitRunner.class)
public class RMIChatTest {

	
	@Test
	public void sendMessage_MultiplePIDMode_successfullCommunication()
			throws MalformedURLException, RemoteException, NotBoundException {
		System.out.println("test started...");
		IChatServer chatServer = initiateMultiplePIDServer();
		String[] usernames = { "initiator", "receiver" };
		
		List<ChatClient> clients = new ArrayList<ChatClient>();
		
		for (String user : usernames) {
			clients.add(new ChatClient(user, chatServer, 1));
		}
		
		for (ChatClient client : clients) {
			new Thread(client).start();			
		}
		
		
		chatServer.sendMessage("Hi", clients.get(0));
		
		System.out.println("test finished");
	}
	
	@Test(expected = NotBoundException.class)
	public void sendMessage_ServerNotBound_Exception()
			throws MalformedURLException, RemoteException, NotBoundException {
		System.out.println("test started...");
		IChatServer chatServer = initiateUnhealthyServer();
		String[] usernames = { "initiator", "receiver" };
		
		List<ChatClient> clients = new ArrayList<ChatClient>();
		
		for (String user : usernames) {
			clients.add(new ChatClient(user, chatServer, 1));
		}
		
		for (ChatClient client : clients) {
			new Thread(client).start();			
		}
		
		
		chatServer.sendMessage("Hi", clients.get(0));
		
		System.out.println("test finished");
	}
	
	private IChatServer initiateMultiplePIDServer() throws RemoteException, MalformedURLException, NotBoundException {
		ChatServerDriver.main(null);
		String chatServerURL = "rmi://localhost/RMIChatServer";
		IChatServer chatServer = (IChatServer)Naming.lookup(chatServerURL);	
		return chatServer;
	}
	
	private IChatServer initiateUnhealthyServer() throws RemoteException, MalformedURLException, NotBoundException {
		String chatServerURL = "rmi://localhost/RMIChatServer1";
		IChatServer chatServer = (IChatServer)Naming.lookup(chatServerURL);	
		return chatServer;
	}
}
