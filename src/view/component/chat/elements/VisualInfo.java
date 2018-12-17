package view.component.chat.elements;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import model.Message;
import view.elements.RoundedPanel;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class VisualInfo extends JPanel {

	private static final long serialVersionUID = 2406733580951366780L;
	public final static Color ERROR = new Color(220, 20, 60);
	private JPanel contentMessage;
	private JLabel info;

	public VisualInfo(Message message) {
		create(message);
	}

	public VisualInfo(Message message, Color background) {
		create(message, background);
	}

	public VisualInfo(Message message, int size) {
		create(message, size);
	}

	private void create(Message message) {
		setOpaque(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentMessage = new RoundedPanel();
		FlowLayout flowLayout = (FlowLayout) contentMessage.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		contentMessage.setOpaque(false);
		add(contentMessage);
		contentMessage.setEnabled(false);
		contentMessage.setMaximumSize(new Dimension(600, 2147483647));
		contentMessage.setFont(new Font("Arial", Font.PLAIN, 16));
		contentMessage.setBorder(new EmptyBorder(8, 13, 8, 13));

		info = new JLabel(message.getMessage());
		info.setHorizontalTextPosition(SwingConstants.CENTER);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Arial", Font.BOLD, 15));
		info.setForeground(Color.WHITE);
		contentMessage.add(info);
	}

	private void create(Message message, Color background) {
		setOpaque(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentMessage = new RoundedPanel(30, background);
		FlowLayout flowLayout = (FlowLayout) contentMessage.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		contentMessage.setOpaque(false);
		add(contentMessage);
		contentMessage.setEnabled(false);
		contentMessage.setMaximumSize(new Dimension(600, 2147483647));
		contentMessage.setFont(new Font("Arial", Font.PLAIN, 16));
		contentMessage.setBorder(new EmptyBorder(8, 13, 8, 13));

		info = new JLabel(message.getMessage());
		info.setHorizontalTextPosition(SwingConstants.CENTER);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Arial", Font.BOLD, 15));
		info.setForeground(Color.WHITE);
		contentMessage.add(info);
	}

	private void create(Message message, int size) {
		setOpaque(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentMessage = new RoundedPanel();
		FlowLayout flowLayout = (FlowLayout) contentMessage.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		contentMessage.setOpaque(false);
		add(contentMessage);
		contentMessage.setEnabled(false);
		contentMessage.setMaximumSize(new Dimension(600, 2147483647));
		contentMessage.setBorder(new EmptyBorder(8, 13, 8, 13));

		info = new JLabel(message.getMessage());
		info.setHorizontalTextPosition(SwingConstants.CENTER);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("Arial", Font.BOLD, size));
		info.setForeground(Color.WHITE);
		contentMessage.add(info);
	}

}
