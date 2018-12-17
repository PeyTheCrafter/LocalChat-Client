package view.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Notifier extends JLabel {

	private static final long serialVersionUID = 6340448132387289904L;
	public static final Color ERROR = new Color(220, 20, 60); // Red
	public static final Color WARNING = new Color(220, 135, 20);  // Orange

	public Notifier() {
		setForeground(Color.WHITE);
		setOpaque(true);
		setBackground(new Color(165, 42, 42));
		setFont(new Font("Arial", Font.BOLD, 15));
		setHorizontalAlignment(SwingConstants.CENTER);
		setBorder(new EmptyBorder(5, 0, 5, 0));
	}

	public void notify(String message, Color backgroundNotification) {
		setText(message);
		setBackground(backgroundNotification);
	}

}
