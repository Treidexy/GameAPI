package me.Treidex.Game.GameObject.Components;

import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.maths.Vector2;

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
	
	/**
	 * Store Transform Position.
	 */
	public Vector2 position;
	
	/**
	 * Store Transform Size.
	 */
	public Vector2 size;
	
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
	public Transform(Vector2 position, Vector2 size, float rotation) {
		this.position = position;
		this.size = size;
		this.rotation = rotation;
	}
}
