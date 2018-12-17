package view.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelBackgroundImage extends JPanel {
	
	private String bg;
	
	public JPanelBackgroundImage(String bg) {
		this.bg = bg;
	}
	
	protected void paintComponent(Graphics panel) {
		Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
		
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource(bg));
		panel.drawImage(imagenFondo.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paintComponent(panel);
	}
}