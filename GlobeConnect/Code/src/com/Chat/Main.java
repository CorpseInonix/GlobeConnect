package com.Chat;

public class Main {
	
	static MainFrame frame;
	static ChatPanel chatPanel;
	static RecieverPanel recieverPanel;
	static LabelListener labelListener;
	static KeyboardListener keyListener;
	static StartRecieving start;
	static ClosingCode windowListener;
	static UserSelectionPanel selectionPanel;
	static PanelListener panelListener;
	static String username;
	
	public void start() {
		
		panelListener = new PanelListener();
		windowListener = new ClosingCode();
		keyListener = new KeyboardListener();
		labelListener = new LabelListener();
		selectionPanel = new UserSelectionPanel();
		recieverPanel = new RecieverPanel();
		chatPanel = new ChatPanel();
		frame = new MainFrame();
		start = new StartRecieving();
		chatPanel.message.requestFocus();
		
	}
	
	public static ChatPanel getChatPanel() {
		return chatPanel;
	}
	
	public static RecieverPanel getRecieverPanel() {
		return recieverPanel;
	}
	
	public static UserSelectionPanel getSelectionPanel() {
		return selectionPanel;
	}
	
	public static MainFrame getFrame() {
		return frame;
	}
	
	public static LabelListener getLabelListener() {
		return labelListener;
	}
	
	public static KeyboardListener getKeyListener() {
		return keyListener;
	}
	
	public static PanelListener getPanelListener() {
		return panelListener;
	}
	
	public static ClosingCode getWindowListener() {
		return windowListener;
	}
	
	public static String getUsername() {
		return username;
	}

}
