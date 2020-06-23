package me.Treidex.Game.GameObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.Treidex.Game.Math.JSON;

public class GOIO extends GOMethods {
	public String name;
	
	protected JSONObject goMap;
	protected JSONArray childrenA;
	
	public GOIO(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		goMap = new JSONObject();
		goMap.put("name", name);
		goMap.put("transform", transform);
		goMap.put("components", JSON.arrayToJSONArray(components));
		goMap.put("children", getChildren());
		goMap.put("active", isActive);
		
		return goMap;
	}
	
	public JSONArray getChildren() {
		childrenA = new JSONArray();
		
		if (!childrenNull)
			childrenA = JSON.arrayToJSONArray(children);
		else
			childrenA = null;
		
		return childrenA;
	}
}