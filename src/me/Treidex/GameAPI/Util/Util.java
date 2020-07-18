package me.Treidex.GameAPI.Util;

import org.json.simple.JSONObject;

@Deprecated
public final class Util {
	public static class Color {
		@SuppressWarnings("unchecked")
		public static JSONObject getMap(java.awt.Color col) {
			JSONObject out = new JSONObject();
			out.put("red", col.getRed());
			out.put("green", col.getGreen());
			out.put("blue", col.getBlue());
			out.put("alpha", col.getAlpha());
			
			return out;
		}
		
		public static java.awt.Color loadMap(JSONObject map) {
			return new java.awt.Color((Integer) map.get("red"), (Integer) map.get("green"), (Integer) map.get("blue"), (Integer) map.get("alpha"));
		}
	}
	
	public static class Font {
		@SuppressWarnings("unchecked")
		public static JSONObject getMap(java.awt.Font font) {
			JSONObject out = new JSONObject();
			out.put("name", font.getName());
			out.put("style", font.getStyle());
			out.put("size", font.getSize());
			
			return out;
		}
		
		public static java.awt.Font loadMap(JSONObject map) {
			return new java.awt.Font((String) map.get("name"), (Integer) map.get("style"), (Integer) map.get("size"));
		}
	}
}
