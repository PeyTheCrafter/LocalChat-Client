package controller;

import controller.validators.ConnectionValidator;
import controller.validators.MessageChatValidator;
import model.ServerData;

public class ValidatorsController {
	
	private static ValidatorsController instance;
	
	private ValidatorsController() {
	}
	
	public boolean validateMessageChat(String messageChat) {
		return new MessageChatValidator().validate(messageChat);
	}
	
	public boolean validateConnection(ServerData serverData) {
		return new ConnectionValidator().validate(serverData);
	}
	
	public static ValidatorsController getInstance() {
		if(instance == null) {
			instance = new ValidatorsController();
		}
		
		return instance;
	}

}
