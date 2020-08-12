package me.Treidex.GameAPI.GameObject.Components.Colliders;

/**
 * Used to determine which
 * Type a Collider is.
 * 
 * @author Treidex
 *
 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.Collider Collider.
 */
public enum ColliderType {
	
	/**
	 * The Rectangle Collider.
	 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.RectangleCollider Rectangle Collider.
	 */
	Rectangle,
	
	/**
	 * The Ellipse Collider
	 * @see me.Treidex.GameAPI.GameObject.Components.Colliders.EllipseCollider Ellipse Collider.
	 */
	Ellipse;
}