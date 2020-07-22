package me.Treidex.GameAPI.Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager extends Methods {
	public static <T> void WriteToFile (String filename, T obj) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(obj);
			
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
			printlnErr(e.toString());
		}
	}
	
	public static <T> T ReadFile (String filename) {
		try {
			FileInputStream fis = new FileInputStream("Main Scene.jscn");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			@SuppressWarnings("unchecked")
			T out = (T) ois.readObject();
			
			ois.close();
			fis.close();
			
			return out;
		} catch (Exception e) {
			printlnErr(e.toString());
			
			return null;
		}
	}
}
