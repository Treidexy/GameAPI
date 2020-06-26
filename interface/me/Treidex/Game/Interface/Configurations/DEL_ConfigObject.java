package me.Treidex.Game.Interface.Configurations;

import java.util.Map;

@Deprecated
public class DEL_ConfigObject {
	// <Maps>
	public Map<String, Object> data;
	
	private Map<String, String> strings;
	private Map<String, Boolean> booleans;
	private Map<String, Integer> integers;
	private Map<String, Float> floats;
	private Map<String, Double> doubles;
	// </Maps>
	
	// <Default Configurations>
	public void addDefault(String key, Object value) {
		data.put(key, value);
	}
	
	public void addDefault(String key, String value) {
		strings.put(key, value);
		
		addDefault(key, (Object) value);
	}
	
	public void addDefault(String key, Boolean value) {
		booleans.put(key, value);
		
		addDefault(key, (Object) value);
	}
	
	public void addDefault(String key, Integer value) {
		integers.put(key, value);
		
		addDefault(key, (Object) value);
	}
	
	public void addDefault(String key, Float value) {
		floats.put(key, value);
		
		addDefault(key, (Object) value);
	}
	
	public void addDefault(String key, Double value) {
		doubles.put(key, value);
		
		addDefault(key, (Object) value);
	}
	// </Default Configurations>
	
	// <Getting Values>
	public Object get(String key) {
		return data.get(key);
	}
	
	public String getString(String key) {
		return strings.get(key);
	}
	
	public Boolean getBoolean(String key) {
		return booleans.get(key);
	}
	
	public Integer getInteger(String key) {
		return integers.get(key);
	}
	
	public Float getFloat(String key) {
		return floats.get(key);
	}
	
	public Double getDouble(String key) {
		return doubles.get(key);
	}
	// </Getting Values>
	
	// <Setting Values>
	public void set(String key, Object value) {
		data.replace(key, value);
	}
	
	public void setString(String key, String value) {
		strings.replace(key, value);
		
		set(key, (Object) value);
	}
	
	public void setBoolean(String key, Boolean value) {
		booleans.replace(key, value);
		
		set(key, (Object) value);
	}
	
	public void setInteger(String key, Integer value) {
		integers.replace(key, value);
		
		set(key, (Object) value);
	}
	
	public void setFloat(String key, Float value) {
		floats.replace(key, value);
		
		set(key, (Object) value);
	}
	
	public void setDouble(String key, Double value) {
		doubles.replace(key, value);
		
		set(key, (Object) value);
	}
	// </Setting Values>
}
