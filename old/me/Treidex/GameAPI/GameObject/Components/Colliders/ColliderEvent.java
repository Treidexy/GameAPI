package me.Treidex.GameAPI.GameObject.Components.Colliders;


/**
 * 
 * Just what it says,
 * this is a Custom Collider Event.
 * 
 * @author Treidex
 *
 */
public interface ColliderEvent {
	/**
	 * Structure for Entering Collision.
	 * 
	 * @param collisionMap The Collision Map.
	 * @param colliders The Colliders that it is hitting.
	 */
	public void onCollisionEnter(float[] collisionMap, Collider[] colliders);
	
	/**
	 * Structure for Exiting Collision.
	 */
	public void onCollisionExit();
}
