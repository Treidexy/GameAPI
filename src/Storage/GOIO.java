

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.GameObject.Components.ComponentNoIDException;
import me.Treidex.GameAPI.GameObject.Components.Transform;
import me.Treidex.GameAPI.Util.Math.Mathf;

public class GOIO extends GOMethods {
	
	
	protected JSONObject goMap;
	protected JSONArray childrenA;
	protected JSONObject componentsA;
	
	public GOIO(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		try {
			goMap = new JSONObject();
			goMap.put("name", name);
			goMap.put("transform", transform.getMap());
			goMap.put("components", getComponents());
			goMap.put("children", getChildren());
			goMap.put("active", isActive);
			
			return goMap;
		} catch (ComponentNoIDException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static GameObject loadMap(JSONObject map) {
		Transform transform = (Transform) Transform.loadMap((JSONObject) map.get("transform")); 
		Component[] components = loadComponents((JSONObject) map.get("components"));
		GameObject[] children = loadChildren((JSONArray) map.get("children"));
		
		return new GameObject((String) map.get("name"), (Boolean) map.get("active"), transform, components, children);
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public JSONObject getComponents() throws ComponentNoIDException {
		componentsA = new JSONObject();
		
		for (Component c: components) {
			componentsA.put(c.getID(), c.getMap());
		}
		
		return componentsA;
	}
	
	public static Component[] loadComponents(JSONObject map) {
		Component[] out = new Component[0];
		
		for (int i = 0; i < map.size(); i++)
			for (String componentID: Component.getIDs()) {
				Component selComponent = (Component) map.get(componentID);
				if (selComponent != null)
					out = Mathf.<Component> addToArray(Component.class, out, selComponent);
			}
		
		return out;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getChildren() {
		childrenA = new JSONArray();
		
		if (!childrenNull)
			for (GameObject child: children) {
				childrenA.add(child.getMap());
			}
		
		return childrenA;
	}
	
	public static GameObject[] loadChildren(JSONArray children) {
		GameObject[] out = new GameObject[0];
		
		for (int i = 0; i < children.size(); i++)
			out = Mathf.addToArray(GameObject.class, out, GameObject.loadMap((JSONObject) children.get(i)));
		
		return out;
	}
}