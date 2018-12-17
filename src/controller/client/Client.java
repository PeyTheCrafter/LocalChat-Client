package controller.client;

import java.io.IOException;
import java.net.Socket;

import model.MessageChat;
import model.ServerData;
import model.User;

public class Client {

	private Socket socket;
	private ClientThread clientThread;
	private User user;

	public Client() {
		this.user = new User();
	}

	public boolean connect(ServerData serverData) {
		try {
			if (this.socket == null || this.socket.isClosed()) {
				this.socket = new Socket(serverData.getIp(), serverData.getPort());
				this.clientThread = new ClientThread(this.socket);
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void sendMessage(MessageChat message) {
		try {
			this.clientThread.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	public String getUserId() {
		return user.getId();
	}

}
