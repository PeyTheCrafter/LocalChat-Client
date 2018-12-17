package view.component.chat;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;

import org.itr_rescue.dataGuard.ui.VerticalFlowLayout;

import model.Message;
import model.MessageChat;
import view.component.chat.elements.*;
import view.elements.MyScrollBarUI;

public class ContentChat extends JScrollPane {

	private static final long serialVersionUID = 3184430084301200055L;
	private JPanel content;

	public ContentChat() {
		getVerticalScrollBar().setUnitIncrement(15);
		setComponentZOrder(getVerticalScrollBar(), 0);
		setComponentZOrder(getViewport(), 1);
		getVerticalScrollBar().setOpaque(false);

		getVerticalScrollBar().setUI(new MyScrollBarUI());
		setBorder(null);
		setLayout(new ScrollPaneLayout());
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setViewportBorder(null);
		setOpaque(false);
		getViewport().setOpaque(false);

		content = new JPanel();
		content.setAutoscrolls(true);
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		content.setOpaque(false);
		VerticalFlowLayout vfl_contentChat = new VerticalFlowLayout();
		vfl_contentChat.setHorizontalFill(VerticalFlowLayout.FILL_SPACE);
		vfl_contentChat.setVgap(0);
		vfl_contentChat.setHgap(0);
		vfl_contentChat.setHorizontalAlign(0.0f);
		content.setLayout(vfl_contentChat);

		setViewportView(content);
	}
	
	public void resizeContent() {
		this.content.setBounds(0, 0, this.getWidth(), this.getHeight());
	}

	public void addMessage(MessageChat message) {
		this.content.add(new VisualMessage(message));
		this.content.revalidate();
	}

	public void addInfo(Message message, Color background) {
		this.content.add(new VisualInfo(message, background));
		this.content.revalidate();
		scrollToBottom();
	}

	public void addInfo(Message message) {
		this.content.add(new VisualInfo(message));
		this.content.revalidate();
		scrollToBottom();
	}

	public void scrollToBottom() {
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	}

	public void removeAllMessages() {
		this.content.removeAll();
		this.content.updateUI();
	}

}
