package me.Treidex.GameAPI.GameObject.Components;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.Anotations.Unfinished;
import me.Treidex.GameAPI.Util.Vector2;

/**
 * Transforms Store Position, Size, and Rotation;
 * basically storing Game Object details.
 * 
 * @author Treidex
 *
 */
public class Transform extends Component {
	
	/**
	 * Empty Preset.
	 */
	public static Transform empty = new Transform(Vector2.zero, Vector2.zero,0);
	
	private Vector2 center = Vector2.zero;
	
	/**
	 * Store Transform Position.
	 */
	private Vector2 position = Vector2.zero;
	
	/**
	 * Store Transform Size.
	 */
	public Vector2 size = Vector2.zero;
	
	/**
	 * Store Transform Rotation.
	 */
	@Unfinished
	public float rotation;
	
	protected JSONObject transformM;
	protected JSONObject centerM;
	protected JSONObject sizeM;
	
	/**
	 * Initialize the Transform.
	 * 
	 * @param position Transform Position.
	 * @param size Transform Size.
	 * @param rotation Transform Rotation.
	 */
	public Transform(Vector2 center, Vector2 size, float rotation) {
		initID("Transform");
		
		this.size = size;
		this.rotation = rotation;
		
		center(center);
	}
	
	public Vector2 center() {
		return center;
	}
	
	public void center(Vector2 center) {
		this.center = center;
		
		position = Vector2.sub(this.center, Vector2.div(size, 2));
		
	}
	
	public Vector2 position() {
		return position;
	}
	
	public void position(Vector2 position) {
		this.position = position;
		
		center = Vector2.add(this.position, Vector2.div(size, 2));
	}
	
	public Transform copy() {
		return new Transform(center.copy(), size.copy(), rotation);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		JSONObject out = new JSONObject();
		centerM = center.getMap();
		sizeM = size.getMap();
		
		out.put("center", centerM);
		out.put("rotation", rotation);
		out.put("size", sizeM);
		
		return out;
	}
	
	public static Component loadMap(final JSONObject map) {
		Vector2 center = Vector2.loadMap((JSONObject) map.get("center"));
		Vector2 size = Vector2.loadMap((JSONObject) map.get("size"));
		float rotation = (Float) map.get("rotation");
		
		return (Component) new Transform(center, size, rotation);
	}
	
	public String toString() {
		return "[ " + center + ", " + size + " ]";
	}
}
