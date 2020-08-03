package me.Treidex.GameAPI.OpenGL.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils
{
	public static String loadFile(String filename)
	{
		StringBuilder result = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream(filename))))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				result.append(line).append("\n");
			}
		}
		catch (IOException e)
		{
			System.err.println("[!]: Can't find file '" + filename + "': " + e.toString());
		}
		
		return result.toString();
	}
}
