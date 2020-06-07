package me.Treidex.Game.GameObject.Components;

import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.maths.Vector2;

public class Physics extends Component {
	public Collider collider;
	public Vector2 velocity;
	public Vector2 gravity;
	
	public float speedDamp;
	public float lerp;
	
	public boolean onGround;
	
	private ColliderType colliderType;
	
	public Physics(ColliderType colliderType, Vector2 gravity, float speedDamp, float lerp) {
		this.colliderType = colliderType;
		this.gravity = gravity;
		this.speedDamp = speedDamp;
		this.lerp = lerp;
		
		velocity = Vector2.zero;
	}
	
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
	
	public void addForce(Vector2 force) {
		velocity = Vector2.add(velocity, force);
	}
	
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