package me.Treidex.GameAPI.Util.Math;

import me.Treidex.GameAPI.Anotations.Unfinished;
import me.Treidex.GameAPI.GameObject.Components.Colliders.Collider;
import me.Treidex.GameAPI.GameObject.Components.Colliders.CollisionMap;

/**
 * 
 * Shoot a Ray at something to see how far it is, what you hit, etc.
 * 
 * @author Treidex
 *
 */
@Unfinished
public class Ray {
	
	/**
	 * The Increament ThreashHold (IDK what it means).
	 */
	private static final float INC_THREASHHOLD = 0.00000000006667f;
	
	/**
	 * The Collision Map of the Collider that got hit.
	 */
	public CollisionMap collisionMap;
	
	/**
	 * The Distance of the Ray.
	 */
	public float distance;
	
	/**
	 * Method to cast a Ray.
	 * 
	 * @param pos The Position of the Ray.
	 * @param ang The Ang of the Ray (In Radians).
	 * @param far How far the Ray can go.
	 * 
	 * @return The Ray.
	 */
	public static Ray cast(Vector2 pos, float ang, float far) {
		return cast(pos, Vector2.fromAngle(ang), far);
	}
	
	/**
	 * Method to cast a Ray.
	 * 
	 * @param pos The Position of the Ray.
	 * @param dir The Direction of the Ray (As a normalized Vector2).
	 * @param far How far the Ray can go.
	 * 
	 * @return The Ray.
	 */
	public static Ray cast(Vector2 pos, Vector2 dir, float far) {
		boolean hitB = false;
		
		CollisionMap cm = null;
		
		Ray out = null;
		
		float dist = 0;
		
		while (!hitB || dist <= far) {
			dist += INC_THREASHHOLD;
			dir.magnitude(dist);
			
			for (Collider c: Collider.colliders) {
				if (c.checkCollision(Vector2.add(pos, dir)).collisionMapf[0] == 1f) {
					hitB = true;
					cm = c.checkCollision(dir);
					
					break;
				}
			}
		}
		
		if (!hitB)
			return out;
		
		out = new Ray();
		out.collisionMap = cm;
		out.distance = dist;
		
		return out;
	}
}
