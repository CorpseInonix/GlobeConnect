package com.Chat;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	
	ChatPanel chatPanel;
	RecieverPanel recieverPanel;
	ClosingCode windowListener;
	
	MainFrame() {
		
		chatPanel = Main.getChatPanel();
		recieverPanel = Main.getRecieverPanel();
		windowListener = Main.getWindowListener();
		
		setTitle("Globe Connect");
		setDefaultCloseOperation(3);
		add(BorderLayout.CENTER, chatPanel);
		add(BorderLayout.WEST, recieverPanel);
		addWindowListener(windowListener);
		pack();
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("FrameLogo.jpg")).getImage());
		
	}

}
