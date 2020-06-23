package me.Treidex.Game.Math;

import org.json.simple.JSONArray;

public final class JSON {
	@SuppressWarnings("unchecked")
	public static JSONArray arrayToJSONArray(Object[] array) {
		JSONArray out = new JSONArray();
		for (Object object: array) {
			out.add(object);
		}
		
		return out;
	}
}
