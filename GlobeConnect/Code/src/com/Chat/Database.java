package com.Chat;

import java.sql.*;
import java.time.*;
import java.time.format.*;

public class Database {
	
	static Connection connection;
	static Statement statement;
	static PreparedStatement preparedStatement;
	static ResultSet result;
	static DateTimeFormatter format; 
	
	public static boolean connect() {
		
		boolean output = true;
		connection = null;
		
		try {
			
			String url = "jdbc:mysql://globeconnect-globeconnect.a.aivencloud.com:12494/defaultdb";
			String username = "avnadmin";
			String password = "AVNS_l1sBJ59XSQYFdm4dNZ2";
			
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            format = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm");
			
		} catch(Exception ex) { output = false; ex.printStackTrace(); }
		
		return output;
		
	}
	
	public static String getNewMessage() {
		
		String output = null;
		String message;
		String sender;
		String time;
		
		try {
			
			result = statement.executeQuery("select * from Messages where Reciever = '" + Main.getUsername() + "'");
			
			if(result.next()) {
				
				message = result.getString("Message");
				sender = result.getString("Sender");
				time = result.getString("Time");
				
				deleteMessage(result.getInt("MessageID"));
				
				output = message + "/" + sender + "/" + time;
				
			}
			
		} catch(Exception ex) { output = ""; }
		
		return output;
		
	}
	
	public static boolean sendMessage(String message, String reciever) {
		
		boolean output = true;
		
		if(reciever.length() <= 13 && message.length() <= 255) {
			
			try {
				
				statement.executeUpdate("insert into Messages (Reciever, Sender, Time, Message)"
						+ "values('" + reciever + "', '" + Main.getUsername() + "', '" + getTime() + "', '" + message + "')");
				
			} catch(Exception ex) { output = false; }
			
		} else {
			
			output = false;
			Main.getChatPanel().message.setText("Message was too long");
			
		}
		
		return output;
		
	}
	
	public static boolean deleteMessage(int MessageID) {
		
		boolean output = true;
		
		try {
			
			preparedStatement = connection.prepareStatement("delete from Messages where MessageID = ?");
			preparedStatement.setInt(1, MessageID);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception ex) { output = false; }
		
		return output;
		
	}
	
	public static boolean doesUserExist(String username) {
		
		boolean output = true;
		
		try {
			
			result = statement.executeQuery("Select Username from Users where Username = '" + username + "'");
			
			if(!result.next())
				output = false;
			
		} catch(Exception ex) { output = false; }
		
		return output;
		
	}
	
	public static boolean registerUser(String username, String password) {
		
		boolean output = true;
		
		try {
			
			if(doesUserExist(username))
				output = false;
			else
				statement.executeUpdate("insert into Users (Username, Password) "
						+ "values('" + username + "', '" + password + "')");
			
		} catch(Exception ex) { output = false; }
		
		return output;
		
	}
	
	public static boolean loginUser(String username, String password) {
		
		boolean output = true;
		
		try {
			
			result = statement.executeQuery("select * from Users where"
					+ " Username = '" + username + "' and Password = '" + password + "'");
			
			if(!result.next())
				output = false;
			
		} catch(Exception ex) { output = false; }
		
		return output;
		
	}
	
	public static String getTime() {
		
		String time = LocalDateTime.now().format(format);
		
		return time;
		
	}

}
