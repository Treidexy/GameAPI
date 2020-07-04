package me.Treidex.GameAPI.GameObject.Components.Colliders;

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
