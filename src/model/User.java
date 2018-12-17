package model;

import java.awt.Color;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class User implements Serializable {

	private static final long serialVersionUID = -4793933884850266824L;
	private Color colorChat;
	private String username;
	private String id;
	
	public User() {
		try {
			this.id = InetAddress.getLocalHost().getHostAddress() + InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			this.id = String.valueOf(random(8080, 65444));
		}
		this.username = System.getProperty("user.name");
		this.colorChat = createColor();
	}
	
	private Color createColor() {
		return new Color(random(80, 180), random(80, 180), random(80, 180));
	}
	
	private int random(int min, int max) {
		return (int) (Math.random() * (max - min)) + min;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Color getColorChat() {
		return colorChat;
	}
	
}
