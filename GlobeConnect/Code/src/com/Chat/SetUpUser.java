package com.Chat;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SetUpUser extends JFrame implements ActionListener {
	
	JLabel icon;
	JLabel info;
	JLabel labelA;
	JLabel labelB;
	JTextField userField;
	JTextField passField;
	JButton register;
	JButton login;
	JButton reset;
	JPanel mainPanel;
	JPanel buttonPanel;
	
	public static void main(String args[]) {
		new SetUpUser();
	}
	
	SetUpUser() {
		
		mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		buttonPanel = new JPanel(new FlowLayout());
		
		icon = new JLabel();
		info = new JLabel();
		labelA = new JLabel("Username:");
		labelB = new JLabel("Password:");
		
		userField = new JTextField();
		passField = new JTextField();
		
		register = new JButton("Register");
		login = new JButton("Login");
		reset = new JButton("Reset");
		
		setUp();
		addComponents();
		
		setTitle("Globe Connect");
		getContentPane().setBackground(Color.BLACK);
		setSize(415, 275);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("FrameLogo.jpg")).getImage());
		
		if(!Database.connect()) {
			
			info.setText("Internet connection problem, please restart!");
			
			userField.setEnabled(false);
			passField.setEnabled(false);
			
			register.setEnabled(false);
			login.setEnabled(false);
			reset.setEnabled(false);
			
		}
		
	}
	
	public void setUp() {
		
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setBounds(77, 93, 240, 47);
		
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.setBounds(77, 152, 240, 35);
		
		labelA.setForeground(Color.WHITE);
		
		labelB.setForeground(Color.WHITE);
		
		info.setForeground(Color.RED);
		info.setBounds(10, 209, 290, 14);

		icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("DisplayIcon.jpg")));
		icon.setBounds(77, 11, 240, 68);
		
		register.setBackground(Color.BLACK);
		register.setForeground(Color.WHITE);
		register.setFocusable(false);
		register.addActionListener(this);
		
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		login.setFocusable(false);
		login.addActionListener(this);
		
		reset.setForeground(Color.WHITE);
		reset.setBackground(Color.BLACK);
		reset.setBounds(310, 200, 79, 23);
		reset.setFocusable(false);
		reset.addActionListener(this);
		
		userField.setBackground(Color.BLACK);
		userField.setForeground(Color.WHITE);
		userField.setCaretColor(Color.WHITE);
		userField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
		passField.setBackground(Color.BLACK);
		passField.setForeground(Color.WHITE);
		passField.setCaretColor(Color.WHITE);
		passField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		
	}
	
	public void addComponents() {
		
		mainPanel.add(labelA);
		mainPanel.add(userField);
		mainPanel.add(labelB);
		mainPanel.add(passField);
		
		buttonPanel.add(register);
		buttonPanel.add(login);
		
		add(mainPanel);
		add(buttonPanel);
		add(reset);
		add(icon);
		add(info);
		
	}
	
	public boolean performTests(String username, String password) {
		
		boolean output = true;
		
		if(username.length() > 13 || password.length() > 13) {
			
			info.setText("Username or password is too long, keep it short!");
			
			userField.setEnabled(false);
			passField.setEnabled(false);
			
			register.setEnabled(false);
			login.setEnabled(false);
			
			output = false;
			
		}
		
		if(username.equals("") || password.equals("")) {
			
            info.setText("Username or password can't be empty!");
			
			userField.setEnabled(false);
			passField.setEnabled(false);
			
			register.setEnabled(false);
			login.setEnabled(false);
			
			output = false;
			
		}
		
		if(username.contains(" ") || password.contains(" ")) {
			
            info.setText("Username or password must not contain spaces!");
			
			userField.setEnabled(false);
			passField.setEnabled(false);
			
			register.setEnabled(false);
			login.setEnabled(false);
			
			output = false;
			
		}
		
		return output;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = userField.getText();
		String password = passField.getText();
		
		if(e.getSource() == reset) {
			
			userField.setText("");
			passField.setText("");
			
			userField.setEnabled(true);
			passField.setEnabled(true);
			
			register.setEnabled(true);
			login.setEnabled(true);
			
			info.setText("");
			
		} else {
			
			if(performTests(username, password)) {
				
				if(e.getSource() == register) {
					
					if(Database.registerUser(username, password)) {
						
						Main.username = username;
						new Main().start();
						dispose();
						
					} else {
						
						info.setText("Username already exists!");
						
						userField.setEnabled(false);
						passField.setEnabled(false);
						
						register.setEnabled(false);
						login.setEnabled(false);
						
					}
					
				} else {
					
					if(Database.loginUser(username, password)) {
						
						Main.username = username;
						new Main().start();
						dispose();
						
					} else {
						
						info.setText("Username or password is incorrect!");
						
						userField.setEnabled(false);
						passField.setEnabled(false);
						
						register.setEnabled(false);
						login.setEnabled(false);
						
					}
					
				}
				
			}
			
		}
		
	}

}
