package view.component.serverPool;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ButtonServer extends JButton implements MouseListener {

	private static final long serialVersionUID = -1017413906675288233L;

	public ButtonServer(String name) {
		super(name);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.BOLD, 17));
		setBorderPainted(false);
		setBorder(new EmptyBorder(10, 0, 10, 0));
		setBackground(new Color(23, 33, 43));
		setFocusPainted(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		setBackground(new Color(32, 43, 54));
		revalidate();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		setBackground(new Color(23, 33, 43));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
}
