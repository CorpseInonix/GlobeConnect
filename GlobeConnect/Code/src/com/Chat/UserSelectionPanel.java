package com.Chat;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class UserSelectionPanel extends JPanel {
	
	ArrayList<JPanel> userPanels;
	ArrayList<String> usernames;
	PanelListener panelListener;
	int panelNumber = 9;
	int i;
	
	UserSelectionPanel() {
		
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(129, 363));
		setLayout(new GridLayout(panelNumber, 1));
		
		panelListener = Main.getPanelListener();
		
		userPanels = new ArrayList<JPanel>();
		usernames = new ArrayList<String>();
		
		for(int i = 0; i < panelNumber; i++) {
			
			JPanel p = new JPanel(new BorderLayout());
			JLabel user = new JLabel("");
			
			user.setForeground(Color.WHITE);
			user.setFont(new Font("Ariel", Font.BOLD, 13));
			
			p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			p.setBackground(Color.BLACK);
			p.add(BorderLayout.WEST, user);
			p.addMouseListener(panelListener);
			userPanels.add(p);
			add(p);
			
		}
		
		ArrayList<String> storedUsernames = Disc.readUsers();
		
		try {
			
			for(int i = 0; i < storedUsernames.size(); i++)
				usernames.add(storedUsernames.get(i));
			
		} catch(Exception ex) {}
		
		displayUsers();
		
	}
	
	public void displayUsers() {
		
		for(i = 0; i < usernames.size(); i++) {
			
			JLabel l = (JLabel) userPanels.get(i).getComponent(0);
			l.setText(usernames.get(i));
			
		}
		
	}
	
	public boolean isUserInPanels(String username) {
		
		boolean output = false;
		
		for(int i = 0; i < panelNumber; i++)
			try {
				if(usernames.get(i).equals(username)) {
					output = true;
					break;
				}
			} catch(Exception ex) { output = false; }
		
		return output;
		
	}

}
