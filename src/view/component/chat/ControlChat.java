package view.component.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import controller.ValidatorsController;
import model.MessageChat;
import view.elements.TextPrompt;

public class ControlChat extends JPanel {

	private static final long serialVersionUID = 5639456707009462279L;
	private Chat chat;
	private JTextField message;
	private JButton send;
	private JButton trash;

	public ControlChat(Chat chat) {
		this.chat = chat;

		setPreferredSize(new Dimension(10, 55));
		setMaximumSize(new Dimension(32767, 200));
		setBackground(new Color(23, 33, 43));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(15, 0));

		message = new JTextField();
		message.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				toggleSendIcon();
			}
		});
		message.addActionListener(e -> send());
		message.setCaretColor(Color.WHITE);
		message.setBorder(new EmptyBorder(5, 10, 5, 5));
		message.setForeground(Color.WHITE);
		message.setOpaque(false);
		message.setFont(new Font("Arial", Font.PLAIN, 15));
		add(message, BorderLayout.CENTER);
		message.setColumns(10);

		TextPrompt placeholderTextField = new TextPrompt("Write a message...", message);
		placeholderTextField.setBorder(null);
		placeholderTextField.setFont(new Font("Arial", Font.PLAIN, 15));
		placeholderTextField.setForeground(Color.LIGHT_GRAY);

		send = new JButton();
		send.setContentAreaFilled(false);
		send.setIcon(new ImageIcon(Chat.class.getResource("/assets/send.png")));
		send.setOpaque(false);
		send.addActionListener(e -> send());
		send.setForeground(Color.WHITE);
		send.setFocusPainted(false);
		send.setBorderPainted(false);
		send.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		send.setFont(new Font("Arial", Font.BOLD, 16));
		send.setBorder(new EmptyBorder(5, 5, 5, 5));
		send.setVisible(false);
		add(send, BorderLayout.EAST);

		trash = new JButton("");
		trash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		trash.setFocusPainted(false);
		trash.setBorderPainted(false);
		trash.addActionListener(e -> this.chat.removeAllMessages());
		trash.setContentAreaFilled(false);
		trash.setBorder(new EmptyBorder(5, 5, 5, 5));
		trash.setIcon(new ImageIcon(Chat.class.getResource("/assets/trash.png")));
		add(trash, BorderLayout.WEST);
	}

	private void send() {
		MessageChat m = new MessageChat(this.message.getText(), Controller.getInstance().getUser());

		Controller.getInstance().sendMessage(m);
		this.message.setText("");
		this.revalidate();
		this.chat.scrollToBottom();
	}
	
	private void toggleSendIcon() {
		this.send.setVisible(ValidatorsController.getInstance().validateMessageChat(this.message.getText()));
	}

}
