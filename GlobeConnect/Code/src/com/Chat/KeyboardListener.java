package com.Chat;

import java.awt.event.*;
import javax.swing.*;

public class KeyboardListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == 10) {
			
			ChatPanel chatPanel = Main.getChatPanel();
			JTextField t = (JTextField) e.getSource();
			
			String text = t.getText();
			String time = Database.getTime();
			String username = Main.getUsername();
			
			if(!text.contains("'") || text.contains("\"")) {
				
				chatPanel.textArea.append(username + " : " + time + "\n");
				chatPanel.textArea.append(text + "\n" + "\n");
				
				Database.sendMessage(text, chatPanel.displayName);
				Disc.write(text, username, time, chatPanel.displayName);
				
				t.setText("");
				
			} else {
				
				t.setText("Please do not use special characters");
				
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}
