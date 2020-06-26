package me.Treidex.Game.Interface.Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;

@Deprecated
public class DEL_Config {
	public DEL_ConfigObject data;
	
	private String filename;
	private String text;
	
	public DEL_Config(String filename) {
		this.filename = filename;
	}
	
	public void save() {
		try {
			File file = new File(filename);
			Writer writer = new FileWriter(file);
			writer.append(text);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println("[!]: Error saving Configuration to file: " + filename + " [" + e + "]!");
		}
	}
	
	public void load() {
		try {
			File file = new File(filename);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			text = new String(data, "UTF-8");
		} catch (Exception e) {
			System.out.println("[!]: Error loading Configuration to file: " + filename + " [" + e + "]!");
		}
	}
	
	public void parse() {
		String[] lines = text.split("\n");
		
		@SuppressWarnings("unused")
		String selId = null;
		
		for (String line: lines) {
			String[] args = line.split(" ").length > 0? line.split(" "): new String[] { line };
			
			if (args[0].equals("OBJECT=")) {
				selId = "OBJECT";
				continue;
			}
			if (args[0].equals("STRING=")) {
				selId = "STRING";
				continue;
			}
			if (args[0].equals("BOOLEAN=")) {
				selId = "BOOLEAN";
				continue;
			}
			if (args[0].equals("INTEGER=")) {
				selId = "INTEGER";
				continue;
			}
			if (args[0].equals("FLOAT=")) {
				selId = "FLOAT";
				continue;
			}
			if (args[0].equals("DOUBLE=")) {
				selId = "DOUBLE";
				continue;
			}
			
			if (data.data.containsKey(args[0])) {
				
			}
		}
	}
}
