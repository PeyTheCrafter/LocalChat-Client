package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.itr_rescue.dataGuard.ui.VerticalFlowLayout;

import model.Message;
import model.MessageChat;
import view.component.Notifier;
import view.component.chat.Chat;
import view.component.chat.elements.VisualInfo;
import view.component.serverPool.ServerPool;

public class View extends JFrame {

	private static final long serialVersionUID = -8433159879477627219L;
	private JPanel contentPane;
	private Chat chat;
	private ServerPool serverPool;
	private Notifier notifier;
	private JPanel panel;

	public View() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				toggleSidebar();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 634));
		setTitle("LocalChat");
		setBounds(100, 100, 1040, 668);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.serverPool = new ServerPool();
		add(this.serverPool, BorderLayout.WEST);

		panel = new JPanel();
		panel.setBackground(new Color(14, 22, 33));
		contentPane.add(panel, BorderLayout.CENTER);
		VerticalFlowLayout vfl_panel = new VerticalFlowLayout();
		vfl_panel.setHorizontalFill(VerticalFlowLayout.FILL_SPACE);
		vfl_panel.setVerticalAlign(0.4f);
		panel.setLayout(vfl_panel);
		panel.add(new VisualInfo(new Message("Please select a server to start messaging"), 17));

		notifier = new Notifier();

		this.chat = new Chat("localhost");

		setVisible(true);
	}

	public void showMessage(MessageChat message) {
		this.chat.addMessage(message);
	}

	public void showInfo(Message message) {
		this.chat.addInfo(message);
	}

	public void loadServers(List<String> address) {
		this.serverPool.loadServers(address);
	}

	public void showInfo(Message message, Color background) {
		this.chat.addInfo(message, background);
	}

	public void showChat(String name) {
		this.contentPane.remove(panel);

		this.chat.setTitle(name);
		this.contentPane.add(this.chat, BorderLayout.CENTER);

		revalidate();
	}

	public void notify(String message, Color backgroundNotification) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				notifier.notify(message, backgroundNotification);
				contentPane.add(notifier, BorderLayout.NORTH);
				revalidate();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				contentPane.remove(notifier);
				revalidate();
			}
		});
		t.start();
	}

	private void toggleSidebar() {
		this.serverPool.setVisible(getWidth() > 700);
	}

	public void chageStateChat() {
		this.chat.changeState();
	}

}
