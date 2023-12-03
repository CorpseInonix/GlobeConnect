package com.Chat;

import javax.swing.*;
import java.awt.*;

public class RecieverPanel extends JPanel {
	
	JLabel logo;
	JLabel add;
	
	RecieverPanel() {
		
		setBackground(Color.BLACK);
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		setPreferredSize(new Dimension(130, 420));
		
		logo = new JLabel("Chats   ");
		add = new JLabel("+ ");
		
		setUp();
		addComponents();
		
	}
	
	public void setUp() {
		
		logo.setFont(new Font("Ariel", Font.BOLD, 24));
		logo.setForeground(Color.WHITE);
		
		add.setFont(new Font("Ariel", Font.BOLD, 34));
		add.setForeground(Color.WHITE);
		add.addMouseListener(Main.getLabelListener());
		
	}
	
	public void addComponents() {
		
		add(logo);
		add(add);
		add(Main.getSelectionPanel());
		
	}

}
