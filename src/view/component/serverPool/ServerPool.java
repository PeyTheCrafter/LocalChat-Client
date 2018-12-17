package view.component.serverPool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import org.itr_rescue.dataGuard.ui.VerticalFlowLayout;

import controller.Controller;
import model.ServerData;
import view.component.Notifier;
import view.elements.TextPrompt;

public class ServerPool extends JPanel {

	private static final long serialVersionUID = -7597726764381945738L;
	private JTextField ip;
	private JTextField port;
	private JButton btnConnect;
	private JPanel servers;
	private JPanel serversContent;
	private JProgressBar progressSearchServers;

	public ServerPool() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(23, 33, 43));
		setLayout(new BorderLayout(0, 0));

		JPanel panelConfig = new JPanel();
		add(panelConfig, BorderLayout.NORTH);
		panelConfig.setBorder(null);
		panelConfig.setForeground(Color.WHITE);
		panelConfig.setFont(new Font("Arial", Font.PLAIN, 14));
		panelConfig.setOpaque(false);
		panelConfig.setLayout(new GridLayout(0, 1, 0, 10));

		ip = new JTextField();
		ip.setFont(new Font("Arial", Font.PLAIN, 15));
		ip.setForeground(Color.WHITE);
		ip.setCaretColor(Color.WHITE);
		ip.setOpaque(false);
		ip.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)),
				new EmptyBorder(5, 5, 5, 5)));
		panelConfig.add(ip);
		ip.setColumns(10);

		TextPrompt placeholderIP = new TextPrompt("IP Server [localhost]", ip);
		placeholderIP.setBorder(null);
		placeholderIP.setFont(new Font("Arial", Font.PLAIN, 17));
		placeholderIP.setForeground(Color.LIGHT_GRAY);

		btnConnect = new JButton("CONNECT");
		btnConnect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConnect.setContentAreaFilled(false);
		btnConnect.setFocusPainted(false);
		btnConnect.setForeground(Color.WHITE);
		btnConnect.setFont(new Font("Arial", Font.BOLD, 15));
		btnConnect.setBorder(null);
		btnConnect.addActionListener(e -> {
			connect(this.ip.getText());
		});

		port = new JTextField();
		port.addActionListener(e -> {
			connect(this.ip.getText());
		});
		port.setFont(new Font("Arial", Font.PLAIN, 15));
		port.setForeground(Color.WHITE);
		port.setCaretColor(Color.WHITE);
		port.setOpaque(false);
		port.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 255, 255)),
				new EmptyBorder(5, 5, 5, 5)));
		panelConfig.add(port);
		port.setColumns(10);

		TextPrompt placeholderPort = new TextPrompt("Port [6544]", port);
		placeholderPort.setBorder(null);
		placeholderPort.setFont(new Font("Arial", Font.PLAIN, 17));
		placeholderPort.setForeground(Color.LIGHT_GRAY);
		panelConfig.add(btnConnect);

		servers = new JPanel();
		servers.setBorder(null);
		servers.setOpaque(false);
		//add(servers);
		servers.setLayout(new BorderLayout(0, 0));

		progressSearchServers = new JProgressBar();
		progressSearchServers.setBackground(new Color(23, 33, 43));
		progressSearchServers.setBorderPainted(false);
		progressSearchServers.setPreferredSize(new Dimension(146, 10));
		progressSearchServers.setForeground(new Color(46, 139, 87));
		progressSearchServers.setIndeterminate(true);
		servers.add(progressSearchServers, BorderLayout.NORTH);

		serversContent = new JPanel();
		serversContent.setBorder(null);
		serversContent.setOpaque(false);
		servers.add(serversContent, BorderLayout.CENTER);
		VerticalFlowLayout vfl_serversContent = new VerticalFlowLayout();
		vfl_serversContent.setHorizontalAlign(0.0f);
		vfl_serversContent.setVgap(0);
		vfl_serversContent.setHorizontalFill(VerticalFlowLayout.FILL_SPACE);
		serversContent.setLayout(vfl_serversContent);
	}

	private void connect(String ip) {
		ServerData sd = new ServerData();

		sd.setIp(ip);
		sd.setPort(6544);

		if (!Controller.getInstance().connect(sd)) {
			Controller.getInstance().showError("Server not found or connection already established", Notifier.ERROR);
		} else {
			Controller.getInstance().changeStateChat();
		}
	}

	public void loadServers(List<String> address) {
		for (String ip : address) {
			ButtonServer b = new ButtonServer(ip);
			b.addActionListener(e -> connect(((JButton) e.getSource()).getText()));
			this.serversContent.add(b);
		}
		this.progressSearchServers.setIndeterminate(false);
		updateUI();
	}

}
