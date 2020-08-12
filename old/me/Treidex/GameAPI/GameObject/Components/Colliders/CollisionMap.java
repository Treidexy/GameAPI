package me.Treidex.GameAPI.GameObject.Components.Colliders;

/**
 * 
 * A Map containing
 * Info about the collision.
 * 
 * @author Treidex
 *
 */
public class CollisionMap {
	
	/**
	 * The Map of the sides
	 * hit.
	 */
	public float[] collisionMapf;
	
	/**
	 * What Collider got hit.
	 */
	public Collider collision;
	
	/**
	 * What Colliders got hit.
	 */
	public Collider[] collisions;
	
	/**
	 * Create Collision Map.
	 * 
	 * @param collisionMapf The Map of the sides hit.
	 * @param collision What Collider got hit.
	 */
	public CollisionMap(float[] collisionMapf, Collider collision) {
		this.collisionMapf = collisionMapf;
		this.collision = collision;
	}
	
	/**
	 * Create Collision Map.
	 * 
	 * @param collisionMapf The Map of the sides hit.
	 * @param collisions What Colliders got hit.
	 */
	public CollisionMap(float[] collisionMapf, Collider[] collisions) {
		this.collisionMapf = collisionMapf;
		this.collisions = collisions;
	}
}
