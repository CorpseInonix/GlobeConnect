package com.Chat;

import java.io.*;
import java.util.*;

public class Disc {
	
	static File file;
	static RandomAccessFile randomFile;
	static BufferedWriter writer;
	static BufferedReader reader;
	
	public static boolean write(String message, String from, String time, String fileName) {
		
		boolean output = true;
		
		try {
			
			file = new File("Resources\\Conversations\\" + fileName + ".txt");
			
			if(!file.exists())
				file.createNewFile();
			
			writer = new BufferedWriter(new FileWriter(file, true));
			
			writer.append(from + " : " + time + "\n");
			writer.append(message + "\n" + "\n");
			writer.flush();
			writer.close();
			
		} catch(Exception ex) { output = false; }
		
		return output;
		
	}
	
	public static String read(String fileName) {
		
		StringBuilder output = new StringBuilder();
		
        try {
        	
        	randomFile = new RandomAccessFile("Resources\\Conversations\\" + fileName + ".txt", "r");
            long fileLength = randomFile.length();
            long startPoint = Math.max(0, fileLength - 100000);

            for (long pointer = fileLength - 1; pointer >= startPoint; pointer--) {
                randomFile.seek(pointer);
                char c = (char) randomFile.readByte();
                output.insert(0, c);
            }
            
            randomFile.close();

        } catch (Exception ex) {}
		
		return output.toString();
		
	}
	
	public static boolean writeUsers(ArrayList<String> arr) {
		
		boolean output = true;
		
		try {
			
			if(arr.size() > 0) {
				
				file = new File("Resources\\Users\\ContactListOfUsers.txt");
				
				if(!file.exists())
					file.createNewFile();
				
				writer = new BufferedWriter(new FileWriter(file));
				
				for(int i = 0; i < arr.size(); i++)
					writer.write(arr.get(i) + "\n");
				writer.flush();
				writer.close();
				
			}
			
		} catch(Exception ex) { output = false; }
		
		return output;
		
	}
	
	public static ArrayList<String> readUsers() {
		
		String user;
		ArrayList<String> output = new ArrayList<String>();
		
		try {
			
			file = new File("Resources\\Users\\ContactListOfUsers.txt");
			
			if(!file.exists())
				file.createNewFile();
			
			reader = new BufferedReader(new FileReader(file));
			
			while((user = reader.readLine()) != null)
				output.add(user);
			
		} catch(Exception ex) { output = null; }
		
		return output;
		
	}

}
