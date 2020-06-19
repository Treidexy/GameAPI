package me.Treidex.Game.GameObject.Components;

import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.Math.Vector2;

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
	
	/**
	 * Initialize the Transform.
	 * 
	 * @param position Transform Position.
	 * @param size Transform Size.
	 * @param rotation Transform Rotation.
	 */
	public Transform(Vector2 center, Vector2 size, float rotation) {
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
	
	public String toString() {
		return "[ " + center + ", " + size + " ]";
	}
}
