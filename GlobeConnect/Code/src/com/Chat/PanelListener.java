package com.Chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		for(int i = 0; i < Main.getSelectionPanel().panelNumber; i++) {
			
			UserSelectionPanel p2 = Main.getSelectionPanel();
			p2.userPanels.get(i).setBackground(Color.BLACK);
			p2.userPanels.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			
		}
		
		JPanel p = (JPanel) e.getSource();
		JLabel user = (JLabel) p.getComponent(0);
		
		if(!user.getText().equals("")) {
			
			p.setBackground(Color.GRAY);
			p.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
			
			ChatPanel panel = Main.getChatPanel();
			String username = user.getText();
			
			panel.displayName = username;
			panel.reciever.setText(username);
			
			panel.textArea.setText(Disc.read(panel.displayName));
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		JPanel p = (JPanel) e.getSource();
		JLabel user = (JLabel) p.getComponent(0);
		
		if(!user.getText().equals("") && p.getBackground() == Color.BLACK) {
			
			p.setBackground(Color.DARK_GRAY);
			p.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		JPanel p = (JPanel) e.getSource();
		
		if(p.getBackground() == Color.DARK_GRAY) {
			
			p.setBackground(Color.BLACK);
			p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
