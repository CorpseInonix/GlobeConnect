package com.Chat;

import javax.swing.*;
import java.awt.event.*;

public class StartRecieving implements ActionListener {
	
	Timer timer;
	ChatPanel chatPanel;
	UserSelectionPanel selectionPanel;
	int queryTime = 5000;
	
	StartRecieving() {
		
		chatPanel = Main.getChatPanel();
		selectionPanel = Main.getSelectionPanel();
		
		timer = new Timer(queryTime, this);
		timer.addActionListener(this);
		timer.start();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String message;
		String sender;
		String time;
		
		if((message = Database.getNewMessage()) != null) {
			
			String[] tokens = message.split("/");
			message = tokens[0];
			sender = tokens[1];
			time = tokens[2] + "/" + tokens[3] + "/" + tokens[4];
			
			if(Main.getChatPanel().displayName.equals(sender)) {
				
				chatPanel.textArea.append(sender + " - " + time + "\n");
				chatPanel.textArea.append(message + "\n" + "\n");
				 
			}
			
			Disc.write(message, sender, time, sender);
			
			if(!selectionPanel.isUserInPanels(sender)) {
				
				new AddChat(sender);
				
			}
			
		}
		
	}

}
