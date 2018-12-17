package view.component.chat.elements;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextArea;

import model.MessageChat;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VisualMessage extends JPanel {

	private static final long serialVersionUID = -510381019551584456L;
	private final Color MY_MESSAGE = new Color(37, 58, 80);
	private final Color OTHER_MESSAGE = new Color(24, 37, 51);
	private JTextArea contentMessage;
	private JLabel transmitter;
	private JLabel time;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;

	public VisualMessage(MessageChat message) {
		create(message);
	}

	public void addMessage(String message) {
		this.contentMessage.setText(message);
	}

	public void addTransmitter(String transmitter) {
		this.transmitter.setText(transmitter);
	}

	private void create(MessageChat messageChat) {
		setOpaque(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));

		this.time = new JLabel(messageChat.getTime());
		time.setVerticalAlignment(SwingConstants.BOTTOM);
		time.setVerticalTextPosition(SwingConstants.BOTTOM);
		time.setOpaque(true);
		time.setBorder(new EmptyBorder(0, 0, 10, 15));
		add(time, BorderLayout.EAST);
		time.setFont(new Font("Arial", Font.PLAIN, 15));
		time.setForeground(new Color(147, 190, 191));
		time.setHorizontalAlignment(SwingConstants.RIGHT);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(0, 0, 0, 5));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(extractCapital(messageChat.getTransmitter()));
		panel.add(lblNewLabel, BorderLayout.SOUTH);
		lblNewLabel.setForeground(SystemColor.control);
		lblNewLabel.setBackground(messageChat.getColorChat());
		lblNewLabel.setOpaque(true);
		lblNewLabel.setPreferredSize(new Dimension(40, 40));
		lblNewLabel.setBorder(null);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		transmitter = new JLabel(String.valueOf(messageChat.getTransmitter()));
		panel_1.add(transmitter, BorderLayout.NORTH);
		transmitter.setOpaque(true);
		transmitter.setBorder(new EmptyBorder(10, 10, 0, 0));
		transmitter.setForeground(messageChat.getColorChat());
		transmitter.setFont(new Font("Arial", Font.BOLD, 15));

		contentMessage = new JTextArea();
		panel_1.add(contentMessage);
		contentMessage.setWrapStyleWord(true);
		contentMessage.setEnabled(false);
		contentMessage.setDisabledTextColor(Color.WHITE);
		contentMessage.setMaximumSize(new Dimension(600, 2147483647));
		contentMessage.setLineWrap(true);
		contentMessage.setFont(new Font("Arial", Font.PLAIN, 17));
		contentMessage.setBorder(new EmptyBorder(10, 10, 10, 20));
		contentMessage.setText(messageChat.getMessage());

		setBackgroundDynamic(messageChat.getTransmitterId());
	}

	private void setBackgroundDynamic(String id) {
		if (id.equals(Controller.getInstance().getUserId())) {
			this.contentMessage.setBackground(MY_MESSAGE);
			this.transmitter.setBackground(MY_MESSAGE);
			this.time.setBackground(MY_MESSAGE);
		} else {
			this.contentMessage.setBackground(OTHER_MESSAGE);
			this.transmitter.setBackground(OTHER_MESSAGE);
			this.time.setBackground(OTHER_MESSAGE);
		}
	}

	private String extractCapital(String username) {
		return username.substring(0, 1).toUpperCase();
	}

}
