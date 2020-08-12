package me.Treidex.GameAPI.GameObject.Components;

import java.awt.Color;
import java.awt.Graphics2D;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.Debug;
import me.Treidex.GameAPI.Util.Math.Vector2;

/**
 * Transforms Store Position, Size, and Rotation;
 * basically storing Game Object details.
 * 
 * @author Treidex
 *
 */
public final class Transform extends Component {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6682642857596465277L;

	/**
	 * Empty Preset.
	 */
	public static Transform empty = new Transform(Vector2.zero, Vector2.zero, 0);
	
	/**
	 * Store Transform Center.
	 */
	private Vector2 center = Vector2.zero;
	
	/**
	 * Store Transform Position (Top-Left).
	 */
	private Vector2 position = Vector2.zero;
	
	/**
	 * Store Transform Size.
	 */
	public Vector2 size = Vector2.zero;
	
	/**
	 * Store Transform Rotation.
	 */
	private float rotation;
	
	private Vector2 up;
	private Vector2 left;
	
	/**
	 * Is this position Relative to the Parent
	 */
	public boolean relative;
	
	protected JSONObject transformM;
	protected JSONObject centerM;
	protected JSONObject sizeM;
	
	/**
	 * Create the Transform.
	 * 
	 * @param center Transform Center.
	 * @param size Transform Size.
	 * @param rotation Transform Rotation.
	 */
	public Transform(Vector2 center, Vector2 size, float rotation) {
		initID("Transform");
		
		this.size = size;
		rotation(rad(rotation));
		
		center(center);
	}
	
	/**
	 * Initialze the Transform.
	 */
	public void init() {
		if (parent != null) {
			if (parent.parent != null)
				relative = true;
			else
				relative = false;
		}
	}
	
	public void draw(Graphics2D g) {
		if (Debug.statements.contains("debug")) {
			g.setColor(new Color(255, 69, 14));
			g.drawLine((int) transform.center().x, (int) transform.center().y, (int) (transform.center().x + transform.up().x*25), (int) (transform.center().y + transform.up().y*25));
			g.setColor(new Color(14, 255, 14));
			g.drawLine((int) transform.center().x, (int) transform.center().y, (int) (transform.center().x + transform.left().x*25), (int) (transform.center().y + transform.left().y*25));
		}
	}
	
	/**
	 * Getter for the Center of the Transform.
	 * 
	 * @return the Center of the Transform.
	 */
	public Vector2 center() {
		if (relative)
			return Vector2.add(center, parent.parent.transform.center);
		else
			return center;
	}
	
	/**
	 * Setter for the Center of the Transform.
	 * 
	 * @param center The new Center of the Transform.
	 */
	public void center(Vector2 center) {
		this.center = center;
		
		position = Vector2.sub(this.center, Vector2.div(size, 2));
		
	}
	
	/**
	 * Getter for the Position of the Transform.
	 * 
	 * @return the Position of the Transform.
	 */
	public Vector2 position() {
		if (relative)
			return Vector2.add(position, parent.parent.transform.position);
		else
			return position;
	}
	
	/**
	 * Setter for the Position of the Transform.
	 * 
	 * @param position The new Position of the Transform.
	 */
	public void position(Vector2 position) {
		this.position = position;
		
		center = Vector2.add(this.position, Vector2.div(size, 2));
	}
	
	public float rotation() {
		return rotation;
	}
	
	public void rotation(float newRot) {
		this.rotation = newRot;
		
		up = Vector2.fromAngle(-rotation + PI);
		left = Vector2.fromAngle(-rotation - HALF_PI);
	}
	
	public void rotate(float rad) {
		rotation(rotation + rad);
	}
	
	public Vector2 up() {
		return up;
	}
	
	public Vector2 left() {
		return left;
	}
	
	/**
	 * Copy a Transform.
	 * 
	 * @return A Copy of the Transform.
	 */
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
	
	/**
	 * Return the Transform as a String.
	 */
	public String toString() {
		return "[ " + center + ", " + size + " ]";
	}
}
