package me.Treidex.GameAPI.Util.Math;

import me.Treidex.GameAPI.GameObject.Components.Colliders.Collider;
import me.Treidex.GameAPI.GameObject.Components.Colliders.CollisionMap;

public class Ray {
	private static final float INC_THREASHHOLD = 0.00000000006667f;
	
	public Collider hit;
	public CollisionMap collisionMap;
	public float distance;
	
	public static Ray cast(Vector2 pos, float ang, float far) {
		return cast(pos, Vector2.fromAngle(ang), far);
	}
	
	public static Ray cast(Vector2 pos, Vector2 dir, float far) {
		boolean hitB = false;
		
		Collider hit = null;
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
					
					hit = c;
					
					break;
				}
			}
		}
		
		if (!hitB)
			return out;
		
		out = new Ray();
		out.hit = hit;
		out.collisionMap = cm;
		out.distance = dist;
		
		return out;
	}
}
