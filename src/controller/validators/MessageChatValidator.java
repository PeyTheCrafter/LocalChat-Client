package controller.validators;

public class MessageChatValidator implements Validator<String> {
	
	private String message;

	@Override
	public boolean validate(String message) {
		this.message = message;
		
		return isNotEmpty();
	}
	
	private boolean isNotEmpty() {
		return !this.message.isEmpty();
	}

}
