package controller.validators;

import controller.ServerScanner;
import model.ServerData;

public class ConnectionValidator implements Validator<ServerData> {
	
	private ServerData serverData;
	private ServerScanner serverScanner;
	
	public ConnectionValidator() {
		this.serverScanner = new ServerScanner();
	}

	@Override
	public boolean validate(ServerData serverData) {
		this.serverData = serverData;

		return isServer() && isNotEmpty();
	}
	
	private boolean isServer() {
		return this.serverScanner.isServer(this.serverData.getIp(), this.serverData.getPort());
	}
	
	private boolean isNotEmpty() {
		return !(this.serverData.getIp().isEmpty() && this.serverData.getPort() == 0);
	}

}
