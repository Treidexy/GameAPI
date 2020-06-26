package me.Treidex.Game.Interface.Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Config {
	private String filename;
	private String[] defaultConfig;
	private String text;
	
	public Config(String filename, String... defaultConfig) {
		this.filename = filename;
		this.defaultConfig = defaultConfig;
		
		File file = new File(filename);
		
		try {
			if (file.createNewFile())
				revertToDefaults();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		load();
		if (getConfig().length < defaultConfig.length)
			revertToDefaults();
	}
	
	public void save() {
		try {
			File file = new File(filename);
			Writer writer = new FileWriter(file);
			writer.write(text);
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
	
	public void revertToDefaults() {
		setConfig(defaultConfig);
		save();
	}
	
	public String[] getConfig() {
		return text.split(":").length > 0? text.split(":"): new String[] { text };
	}
	
	public void setConfig(String[] config) {
		StringBuilder textBuff = new StringBuilder();
		
		for (String configItem: config) {
			textBuff.append(configItem + ":");
		}
		
		if (textBuff.length() > 0)
			textBuff.deleteCharAt(textBuff.length()-1);
		
		text = textBuff.toString();
	}
	
	public boolean exists() {
		return new File(filename).exists();
	}
}
