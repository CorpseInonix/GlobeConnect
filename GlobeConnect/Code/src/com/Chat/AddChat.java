package com.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddChat extends JFrame implements ActionListener {
	
	JPanel mainPanel;
	JLabel logo;
	JLabel info;
	JButton add;
	JTextField usernameField;
	
	AddChat(String username) {
		
		addChat(username);
		
	}
	
	AddChat() {
		
		mainPanel = new JPanel(new FlowLayout());
		
		logo = new JLabel("Enter the username");
		
		info = new JLabel("");
		
		add = new JButton("Add");
		
		usernameField = new JTextField(10);
		
		setTitle("Globe Connect");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(263, 161);
		add(BorderLayout.CENTER, mainPanel);
		add(BorderLayout.SOUTH, info);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("FrameLogo.jpg")).getImage());
		
		setUp();
		addComponents();
		
	}
	
	public void setUp() {
		
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setBounds(61, 11, 122, 80);
		
		logo.setForeground(Color.WHITE);
		
		usernameField.setBackground(Color.BLACK);
		usernameField.setForeground(Color.WHITE);
		usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		usernameField.setCaretColor(Color.WHITE);
		
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setFocusable(false);
		add.addActionListener(this);
		
		info.setForeground(Color.RED);
		info.setBounds(10, 97, 260, 14);
		
	}
	
	public void addComponents() {
		
		mainPanel.add(logo);
		mainPanel.add(usernameField);
		mainPanel.add(add);
		
	}
	
	public boolean addChat(String username) {
		
		boolean output = true;
		
        if(Database.doesUserExist(username)) {
			
			UserSelectionPanel panel = Main.getSelectionPanel();
			
			for(int i = 0; i < panel.panelNumber; i++) {
				
				JLabel l = (JLabel) panel.userPanels.get(i).getComponent(0);
				
                if(!l.getText().equals(username)) {
                	
                	if(!username.equals(Main.getUsername())) {
    					
    					if(l.getText().equals("") && i <= panel.panelNumber - 1) {
    						
    						l.setText(username);
        					dispose();
        					panel.usernames.add(username);
        					break;
    						
    					} else if(i == panel.panelNumber - 1) {
    						
    						for(int j = panel.panelNumber - 2; j >= 0; j--)
    							panel.usernames.set(j + 1, panel.usernames.get(j));
    						
    						panel.usernames.set(0, username);
    						
    						panel.displayUsers();
    						
    						dispose();
    						
    					}
    					
    				} else {
    					
    					info.setText("You can't send a message to yourself!");
    					output = false;
    					break;
    					
    				}
                	
                } else {
                	
                	info.setText("User has already been added!");
                	output = false;
                	break;
                	
                }
				
			}
			
		} else {
			
			info.setText("User doesn't exist!");
			output = false;
			
		}
		
		return output;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		addChat(usernameField.getText());
		
	}

}
