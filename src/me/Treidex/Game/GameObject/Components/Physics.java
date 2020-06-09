package me.Treidex.Game.GameObject.Components;

import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.Math.Vector2;

/**
 * Component for Simulated Physics.
 * 
 * @author Treidex
 *
 */
public class Physics extends Component {
	
	/**
	 * The Collider the Physics Component uses.
	 */
	public Collider collider;
	
	/**
	 * The Velocity of the Physics Component.
	 */
	public Vector2 velocity;
	
	/**
	 * The Gravity of the Physics Component.
	 */
	public Vector2 gravity;
	
	/**
	 * The Rate of which you slow down.
	 */
	public float speedDamp;
	
	/**
	 * The Linear Interpolation for the Physics Component.
	 */
	public float lerp;
	
	/**
	 * Determine Whether the Physics Component is on the Ground.
	 */
	public boolean onGround;
	
	/**
	 * The Collider Type.
	 */
	private ColliderType colliderType;
	
	/**
	 * Initialize the Physics Component.
	 * 
	 * @param colliderType The Collider Type.
	 * @param gravity The Gravity of the Physics Component.
	 * @param speedDamp The Rate of which you slow down.
	 * @param lerp The Liner Interpolation for the Physics Component.
	 */
	public Physics(ColliderType colliderType, Vector2 gravity, float speedDamp, float lerp) {
		this.colliderType = colliderType;
		this.gravity = gravity;
		this.speedDamp = speedDamp;
		this.lerp = lerp;
		
		velocity = Vector2.zero;
	}
	
	/**
	 * Initialize the Collider.
	 */
	public void init() {
		switch(colliderType) {
			case Rectangle:
				collider = parent.<RectangleCollider> getComponent(RectangleCollider.class);
				break;
			case Ellipse:
				collider = parent.<EllipseCollider> getComponent(EllipseCollider.class);
				break;
		}
	}
	
	/**
	 * Update the Physics Component.
	 */
	public void fixedUpdate() {
		addForce(gravity);
		
		collisionHandle(collider.checkCollision());
		
		Vector2 newPos = Vector2.add(transform.position, velocity);
		transform.position = Vector2.lerp(transform.position, newPos, lerp);
		
		velocity = Vector2.lerp(velocity, Vector2.zero, speedDamp);
		
		if (velocity.x <= 0.1f && velocity.x >= -0.1f) {
			velocity.x = 0;
		}
		if (velocity.y <= 0.1f && velocity.y >= -0.1f) {
			velocity.y = 0;
		}
	}
	
	/**
	 * Method for Adding Force to the Physics Component.
	 * 
	 * @param force
	 */
	public void addForce(Vector2 force) {
		velocity = Vector2.add(velocity, force);
	}
	
	/**
	 * Handling Collision for Physics Component.
	 * 
	 * @param collisionMap The Collision Map.
	 */
	@Unfinished
	private void collisionHandle(float[] collisionMap) {
		if (collider.isTrigger) {
			return;
		}
		
		if (collisionMap[0] == 0) {
			onGround = false;
			return;
		}
		
		onGround = true;
		
		addForce(new Vector2((Math.abs(velocity.x) * collisionMap[1]), (Math.abs(velocity.y) * collisionMap[2])));
	}
}