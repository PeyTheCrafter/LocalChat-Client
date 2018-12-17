package view.component.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HeaderChat extends JPanel {

	private static final long serialVersionUID = -6676935303075551196L;
	private final Color ON = new Color(46, 139, 87); // Green
	private final Color OFF = new Color(220, 20, 60); // Red
	private JLabel titleChat;
	private JLabel state;

	public HeaderChat(String title) {
		setBorder(new EmptyBorder(10, 0, 0, 0));
		setBackground(new Color(23, 33, 43));
		setLayout(new BorderLayout(0, 10));

		titleChat = new JLabel(title);
		titleChat.setBorder(new EmptyBorder(10, 10, 10, 10));
		titleChat.setHorizontalAlignment(SwingConstants.LEFT);
		titleChat.setForeground(Color.WHITE);
		titleChat.setFont(new Font("Arial", Font.BOLD, 17));
		add(titleChat, BorderLayout.CENTER);

		state = new JLabel("");

		state.setBackground(new Color(220, 20, 60));
		state.setOpaque(true);
		state.setPreferredSize(new Dimension(0, 5));
		add(state, BorderLayout.SOUTH);
	}

	public void changeState() {
		if (state.getBackground().equals(ON)) {
			state.setBackground(OFF);
		} else {
			state.setBackground(ON);
		}
		revalidate();
	}

	public void setTitle(String title) {
		this.titleChat.setText(title);
	}

}
