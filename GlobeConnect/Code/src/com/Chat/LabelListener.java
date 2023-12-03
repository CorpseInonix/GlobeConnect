package com.Chat;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LabelListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		new AddChat();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		JLabel l = (JLabel) e.getSource();
		l.setForeground(Color.ORANGE);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		JLabel l = (JLabel) e.getSource();
		l.setForeground(Color.WHITE);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
