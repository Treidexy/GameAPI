package me.Treidex.GameAPI.GameObject.Components;

import java.awt.Graphics;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.Util.Math.Vector2;

/**
 * A Component that makes the Game
 * Focus on
 * a Game Object.
 * 
 * @author Treidex
 *
 */
public class Follow extends Component {
	
	/**
	 * The Linear Interpolation of the Focus Change.
	 */
	protected float lerp;
	
	/**
	 * The Offset of the Focus
	 */
	protected Vector2 offset;
	
	/**
	 * The Width of the Canvas.
	 */
	protected int width;
	
	/**
	 * The Height of the Canvas.
	 */
	protected int height;
	
	protected JSONObject followM;
	protected JSONObject offsetM;
	
	/**
	 * The Position in which
	 * the Game should follow.
	 */
	private Vector2 pos;
	
	/**
	 * Initialize the Follow Component.
	 * 
	 * @param lerp The Linear Interpolation of the Focus Change.
	 * @param width The Width of the Canvas.
	 * @param height The Height of the Canvas.
	 */
	public Follow(float lerp, Vector2 offset, int width, int height) {
		initID("Follow");
		
		this.lerp = lerp;
		this.offset = offset;
		this.width = width;
		this.height = height;
		
		pos = Vector2.zero;
	}
	
	/**
	 * Translate the Canvas to
	 * the Focus Position.
	 */
	public void draw(Graphics g) {
		Vector2 translate = Vector2.neg(Vector2.sub(pos, Vector2.div(new Vector2(width, height), 2)));
		Vector2 translateDif = Vector2.sub(translate, parent.scene.translate);
		
		g.translate((int) translateDif.x, (int) translateDif.y);
		
		parent.scene.translate = translate;
	}
	
	/**
	 * Update the Fucos Position.
	 */
	public void lateUpdate() {
		pos = Vector2.lerp(pos, Vector2.sub(transform.center(), offset), lerp);
	}

	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		followM = new JSONObject();
		offsetM = offset.getMap();
		
		followM.put("lerp", lerp);
		followM.put("offset", offsetM);
		followM.put("width", width);
		followM.put("height", height);
		
		return followM;
	}
	
	public static Component loadMap(final JSONObject map) {
		Vector2 offset = Vector2.loadMap((JSONObject) map.get("offset"));
		
		return new Follow((Float) map.get("lerp"), offset, (Integer) map.get("width"), (Integer) map.get("height"));
	}
}
