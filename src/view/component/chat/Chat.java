package view.component.chat;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.Message;
import model.MessageChat;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Chat extends JPanel {

	private static final long serialVersionUID = -8668100300966062321L;
	
	private HeaderChat headerChat;
	private ContentChat contentChat;
	private ControlChat controlChat;

	public Chat(String title) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				resizeChat();
			}
		});
		setMaximumSize(new Dimension(500, 2147483647));
		setMinimumSize(new Dimension(500, 700));
		setPreferredSize(new Dimension(500, 700));
		setFocusTraversalPolicyProvider(true);
		setBounds(100, 100, 501, 700);

		setBackground(new Color(14, 22, 33));
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		headerChat = new HeaderChat(title);
		add(headerChat, BorderLayout.NORTH);
		
		contentChat = new ContentChat();
		add(contentChat, BorderLayout.CENTER);

		controlChat = new ControlChat(this);
		add(controlChat, BorderLayout.SOUTH);
	}
	
	public void removeAllMessages() {
		this.contentChat.removeAllMessages();
	}

	public void changeState() {
		this.headerChat.changeState();
	}
	
	public void setTitle(String title) {
		this.headerChat.setTitle(title);
	}

	public void addMessage(MessageChat message) {
		this.contentChat.addMessage(message);
	}

	public void addInfo(Message message, Color background) {
		this.contentChat.addInfo(message, background);
	}

	public void addInfo(Message message) {
		this.contentChat.addInfo(message);
	}

	private void resizeChat() {
		this.contentChat.resizeContent();
	}
	
	public void scrollToBottom() {
		this.contentChat.scrollToBottom();
	}
	
	public ContentChat getContentChat() {
		return this.contentChat;
	}
}
