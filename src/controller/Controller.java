package controller;

import java.awt.Color;

import model.Message;
import model.MessageChat;
import model.ServerData;
import model.User;
import view.View;
import view.component.Notifier;

public class Controller {

	private static Controller instance;
	private View view;
	private Logic logic;

	private Controller() {
		this.view = new View();
		this.logic = new Logic();
		//loadServers();
	}

	public void loadServers() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				logic.searchServers();
				view.loadServers(logic.getServers());
			}
		});
		t.start();
	}

	public boolean connect(ServerData serverData) {
		if (ValidatorsController.getInstance().validateConnection(serverData)) {
			if (logic.connect(serverData)) {
				view.showChat(serverData.getIp());
				return true;
			}
			return false;
		}

		return false;
	}
	
	public void showError(String error, Color backgroundNotification) {
		this.view.notify(error, backgroundNotification);
	}

	public void sendMessage(MessageChat m) {
		if (ValidatorsController.getInstance().validateMessageChat(m.getMessage())) {
			this.logic.sendMessage(m);
		}
	}
	
	public void notify(String message, Color backgroundNotification) {
		this.view.notify(message, backgroundNotification);
	}

	public void showMessage(MessageChat message) {
		this.view.showMessage(message);
	}

	public void showInfo(Message message) {
		this.view.showInfo(message);
	}

	public void showInfo(Message message, Color background) {
		this.view.showInfo(message, background);
	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}

		return instance;
	}

	public User getUser() {
		return logic.getUser();
	}

	public String getUserId() {
		return logic.getUserId();
	}

	public void changeStateChat() {
		this.view.chageStateChat();
	}

}
