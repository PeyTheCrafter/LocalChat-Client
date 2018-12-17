package controller;

import java.util.List;

import controller.client.Client;
import model.MessageChat;
import model.ServerData;
import model.User;

public class Logic {

	private ServerScanner serverScanner;
	private Client client;

	public Logic() {
		this.serverScanner = new ServerScanner();
		this.client = new Client();
	}

	public void searchServers() {
		Thread t = new Thread(serverScanner);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public List<String> getServers() {
		return this.serverScanner.getServerAddresses();
	}

	public boolean connect(ServerData serverData) {
		return this.client.connect(serverData);
	}

	public void sendMessage(MessageChat m) {
		this.client.sendMessage(m);
	}

	public User getUser() {
		return client.getUser();
	}

	public String getUserId() {
		return client.getUserId();
	}

}
