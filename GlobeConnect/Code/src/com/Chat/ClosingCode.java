package com.Chat;

import java.awt.event.*;

public class ClosingCode implements WindowListener {

	@Override
	public void windowClosing(WindowEvent e) {
		
		try {
			
			Disc.writer.close();
			Disc.reader.close();
			Disc.randomFile.close();
			
			Database.connection.close();
			Database.statement.close();
			Database.result.close();
			Database.preparedStatement.close();
			
		} catch(Exception ex) { }
		
		Disc.writeUsers(Main.getSelectionPanel().usernames);
		
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

}
