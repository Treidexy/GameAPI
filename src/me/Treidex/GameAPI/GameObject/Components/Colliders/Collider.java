package me.Treidex.GameAPI.GameObject.Components.Colliders;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.Util.Math.Mathf;
import me.Treidex.GameAPI.Util.Math.Vector2;

/**
 * Colliders!
 * Without them,
 * you'd go right through
 * your best friend.
 * 
 * @author Treidex
 *
 */
public abstract class Collider extends Component {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8883887059368321670L;

	/**
	 * List of all Colliders.
	 */
	public static Collider[] colliders = new Collider[0];
	
	/**
	 * Is this Collider a Trigger?
	 */
	public boolean isTrigger;
	
	/**
	 * Checking Margin;
	 * used to save computing
	 * Power.
	 */
	public float margin;
	
	/**
	 * Used to determine
	 * when to trigger
	 * onCollisionEnter and
	 * onCollisionExit.
	 */
	private boolean pcollided;
	
	/**
	 * Function structure.
	 * All Colliders must have
	 * this.
	 * 
	 * @return Collision Map (Tells Physics Component how to move).
	 */
	public abstract CollisionMap checkCollision();
	
	/**
	 * Function structure.
	 * Used for checking individual
	 * spots of Collider.
	 * 
	 * @param checkPos The Position in which to Check.
	 * @return Collision Map.
	 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.Collider#checkCollision() Check Collision().
	 */
	public abstract CollisionMap checkCollision(Vector2 checkPos);
	
	/**
	 * List of all 
	 * the Collider Events.
	 */
	protected ColliderEvent[] colliderEvents;
	
	/**
	 * Create the Collider.
	 * 
	 * @param isTrigger Determines whether the Collider is a Trigger.
	 * @param margin The Margin in which to check Collision.
	 * @param colliderEvents The Collider Events.
	 */
	public Collider(boolean isTrigger, float margin, ColliderEvent[] colliderEvents) {
		this.isTrigger = isTrigger;
		this.margin = margin;
		this.colliderEvents = colliderEvents;
	}
	
	/**
	 * Initialize the Collider.
	 */
	public void init() {
		for (Collider collider: colliders)
			if (collider == this)
				return;
		colliders = Mathf.<Collider> addToArray(Collider.class, colliders, this);
	}
	
	/**
	 * Used for when
	 * colliders want to remove
	 * a Collider
	 * from the Colliders Array.
	 * 
	 * @param index The index in the Colliders Array in wich to Destroy.
	 * 
	 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.Collider#colliders Colliders Array.
	 */
	public void destroyCollider(int index) {
		colliders = Mathf.<Collider> removeFromArray(Collider.class, colliders, index);
	}
	
	/**
	 * Getter for pcollided.
	 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.Collider#pcollided Past Collided.
	 * 
	 * @return pcollided The Value for pcollided.
	 */
	public boolean pcollided() {
		return pcollided;
	}
	
	/**
	 * Setter for pcollided.
	 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.Collider#pcollided Past Collided.
	 * 
	 * @param pcollided Whether Collider Collided before.
	 */
	public void pcollided(boolean pcollided) {
		this.pcollided = pcollided;
	}
}