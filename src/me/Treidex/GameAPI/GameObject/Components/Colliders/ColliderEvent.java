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
	 */
	public void onCollisionEnter(float[] collisionMap, Collider[] colliders);
	
	/**
	 * Structure for Exiting Collision.
	 */
	public void onCollisionExit();
}
