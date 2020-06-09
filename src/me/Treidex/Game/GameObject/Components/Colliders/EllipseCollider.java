package me.Treidex.Game.GameObject.Components.Colliders;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.Math.Mathf;
import me.Treidex.Game.Math.Vector2;

/**
 * Ellipse's are cool,
 * and I'm cool;
 * so Ellipse's now have
 * Colliders!
 * 
 * @author Treidex
 *
 */
@Unfinished
public class EllipseCollider extends Collider {
	
	/**
	 * Initialize the
	 * Ellipse Collider.
	 * 
	 * @param isTrigger Determines whether is a Trigger or not.
	 * @param margin The Margin in which to calculate from.
	 */
	public EllipseCollider(boolean isTrigger, float margin) {
		super(isTrigger, margin);
	}
	
	/**
	 * Draw The Wireframe
	 * of the Collider.
	 */
	public void draw(Graphics g) {
		g.setColor(new Color(50, 255, 14));
		g.drawOval((int) transform.position.x, (int) transform.position.y, (int) transform.size.x, (int) transform.size.y);
		
		g.setColor(new Color(255, 88, 14));
		g.drawOval((int) (transform.position.x + margin), (int) (transform.position.y + margin), (int) (transform.size.x - margin*2), (int) (transform.size.y - margin*2));
	}

	/**
	 * Checks if the Ellipse is colliding with
	 * another collider.
	 */
	public float[] checkCollision() {
		float[] collisionMap = new float[] {
			0,
			0,
			0
		};
		
		for (Collider collider : Collider.colliders) {
			
			if (collider == this)
				continue;
			
			for (float ang = 0; ang < 360; ang++) {
				float X = (float) Math.sin(ang);
				float Y = (float) Math.cos(ang);
				
				for (float multX = -transform.size.x; multX < transform.size.x/2; multX++) {
					float x = X * multX;
					for (float multY = -transform.size.y; multY < transform.size.y/2; multY++) {
						float y = Y * multY;
						
						float[] tempCollisionMap = collider.checkCollision(Vector2.add(transform.position, new Vector2(x, y)));
						
						if (tempCollisionMap[0] != 0)
							collisionMap[0] = tempCollisionMap[0];
						
						if (tempCollisionMap[1] != 0)
							collisionMap[1] += tempCollisionMap[1];
						if (tempCollisionMap[2] != 0)
							collisionMap[2] += tempCollisionMap[2];
					}
				}
			}
		}
		
		for (int i = 0; i < collisionMap.length; i++) {
			collisionMap[i] = Mathf.constrain(collisionMap[i], -1, 1);
		}
		
		return collisionMap;
	}

	/**
	 * Checks Collision for one spot.
	 */
	public float[] checkCollision(Vector2 checkPos) {
		float[] collisionMap = new float[] {
			0, // Has Collided?
			0, // Horizontal Map
			0  // Vertical Map
		};
		
		if (Math.pow((checkPos.x - transform.position.x), 2) / Math.pow(transform.size.x, 2) + Math.pow((checkPos.y - transform.position.y), 2) / Math.pow(transform.size.y, 2) <= 1) {
			collisionMap[0] = 1;
			
			if (
					checkPos.x >= transform.position.x && checkPos.x <= transform.position.x + margin &&
					checkPos.y >= transform.position.y && checkPos.y <= transform.position.y + transform.size.y
				) {
				collisionMap[1] = -1;
			}
			if (
					checkPos.x >= transform.position.x + transform.size.x - margin && checkPos.x <= transform.position.x + transform.size.x &&
					checkPos.y >= transform.position.y && checkPos.y <= transform.position.y + transform.size.y
				) {
				collisionMap[1] = 1;
			}
			
			if (
					checkPos.x >= transform.position.x && checkPos.x <= transform.position.x + transform.size.x &&
					checkPos.y >= transform.position.y && checkPos.y <= transform.position.y + margin
				) {
				collisionMap[2] = -1;
			}
			if (
					checkPos.x >= transform.position.x && checkPos.x <= transform.position.x + transform.size.x &&
					checkPos.y >= transform.position.y + transform.size.y - margin && checkPos.y <= transform.position.y + transform.size.y
				) {
				collisionMap[2] = 1;
			}
		}
		
		if (collisionMap[0] == 1) {
			if (!pcollided()) {
//					onCollisionEnter(collisionMap);
			}
			
			pcollided(true);
		} else {
			if (pcollided()) {
//					onCollisionExit();
			}
			
			pcollided(false);
		}
		
		return collisionMap;
	}
}
