package controller.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import controller.Controller;
import model.Message;
import model.MessageChat;
import view.component.Notifier;
import view.component.chat.elements.VisualInfo;

public class ClientThread implements Runnable {

	private ObjectInputStream objectInput;
	private ObjectOutputStream objectOutput;
	private Socket socket;

	public ClientThread(Socket socket) {
		this.socket = socket;
		try {
			this.objectOutput = new ObjectOutputStream(socket.getOutputStream());
			this.objectOutput.flush();
			this.objectInput = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try {
			reportConnection();
			while (true) {
				showMessages();
			}
		} catch (Exception e) {
			reportLostConnection();
			close();
		}
	}
	
	private void close() {
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(MessageChat messageChat) {
		try {
			this.objectOutput.writeObject(messageChat);
		} catch (IOException e) {
			Controller.getInstance().notify("You are not connected to any chat", Notifier.WARNING);
		}
	}

	private void showMessages() throws ClassNotFoundException, IOException {
		Object m = this.objectInput.readObject();

		if (m instanceof MessageChat) {
			Controller.getInstance().showMessage((MessageChat) m);
		} else {
			Controller.getInstance().showInfo((Message) m);
		}
	}

	private void reportLostConnection() {
		Controller.getInstance().showInfo(new Message("The connection to the server has been lost"), VisualInfo.ERROR);
		Controller.getInstance().changeStateChat();
	}

	private void reportConnection() throws IOException {
		this.objectOutput.writeObject(new Message(Controller.getInstance().getUser().getUsername() + " joined"));
	}
}
