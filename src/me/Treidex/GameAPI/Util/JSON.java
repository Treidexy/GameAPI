package me.Treidex.GameAPI.Util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class JSON {
	@SuppressWarnings("unchecked")
	public static JSONArray arrayToJSONArray(Object[] array) {
		JSONArray out = new JSONArray();
		for (Object object: array) {
			out.add(object);
		}
		
		return out;
	}
	
	public static JSONObject load(String filename) {
		try {
			File file = new File(filename);
			Reader r = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONObject out = (JSONObject) parser.parse(r);
			
			return out;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
