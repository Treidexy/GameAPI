package me.Treidex.GameAPI.GameObject.Components;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.Anotations.Unfinished;
import me.Treidex.GameAPI.GameObject.Components.Colliders.*;
import me.Treidex.GameAPI.Util.Time;
import me.Treidex.GameAPI.Util.Math.Vector2;

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
	 * The Exact Position of the Physics Component.
	 */
	public Vector2 newPos;
	
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
	protected ColliderType colliderType;
	
	protected JSONObject physicsM;
	protected JSONObject gravityM;
	
	/**
	 * Initialize the Physics Component.
	 * 
	 * @param colliderType The Collider Type.
	 * @param gravity The Gravity of the Physics Component.
	 * @param speedDamp The Rate of which you slow down.
	 * @param lerp The Liner Interpolation for the Physics Component.
	 */
	public Physics(ColliderType colliderType, Vector2 gravity, float speedDamp, float lerp) {
		initID("Physics");
		
		this.colliderType = colliderType;
		this.gravity = gravity;
		this.speedDamp = speedDamp;
		this.lerp = lerp;
		
		velocity = Vector2.zero;
		newPos = Vector2.zero;
	}
	
	/**
	 * Initialize the Physics Component.
	 */
	public void init() {
		switch(colliderType) {
			case Rectangle:
				collider = getComponent(RectangleCollider.class);
				break;
			case Ellipse:
				collider = getComponent(EllipseCollider.class);
				break;
		}
		
		if (collider.isTrigger) {
			new Exception("Physics Colliders must not be Triggers!");
		}
	}
	
	/**
	 * Interpolate the Position.
	 */
	public void update() {
		transform.position(Vector2.lerp(transform.position(), newPos, lerp));
	}
	
	/**
	 * Update the Physics Component.
	 */
	public void fixedUpdate() {
		addForce(Vector2.mult(gravity, Time.fixedDeltaTime));
		
		collisionHandle(collider.checkCollision().collisionMapf);
		
		newPos = Vector2.add(transform.position(), velocity);
		transform.position(Vector2.lerp(transform.position(), newPos, lerp));
		
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
	 * @param force The Force you want to add.
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
		if (collisionMap[0] == 0) {
			onGround = false;
			return;
		}
		
		onGround = true;
		
		addForce(new Vector2((Math.abs(velocity.x) * collisionMap[1]), (Math.abs(velocity.y) * collisionMap[2])));
	}

	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		physicsM = new JSONObject();
		gravityM = gravity.getMap();
		
		physicsM.put("collider-type", colliderType.ordinal());
		physicsM.put("gravity", gravityM);
		physicsM.put("speed-damp", speedDamp);
		physicsM.put("lerp", lerp);
		
		return physicsM;
	}
	
	public static Component loadMap(final JSONObject map) {
		Vector2 gravity = Vector2.loadMap((JSONObject) map.get("gravity"));
		
		return new Physics(ColliderType.values()[(Integer) map.get("collider-type")], gravity, (Float) map.get("speed-damp"), (Float) map.get("lerp"));
	}
}