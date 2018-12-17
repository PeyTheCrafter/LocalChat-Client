package model;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageChat extends Message {

	private static final long serialVersionUID = 2287092805945386560L;
	private int id;
	private String time;
	private User transmitter;
	private String receiver;

	public MessageChat(String message, User user) {
		super(message);
		this.transmitter = user;
		setTimeNow();
	}

	private void setTimeNow() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		this.time = sdf.format(cal.getTime());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTransmitter() {
		return transmitter.getUsername();
	}
	
	public String getTransmitterId() {
		return transmitter.getId();
	}

	public Color getColorChat() {
		return transmitter.getColorChat();
	}
	
}
