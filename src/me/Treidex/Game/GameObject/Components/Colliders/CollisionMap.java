package me.Treidex.Game.GameObject.Components.Colliders;

public class CollisionMap {
	public float[] collisionMapf;
	public Collider collision;
	public Collider[] collisions;
	
	public CollisionMap(float[] collisionMapf, Collider collision) {
		this.collisionMapf = collisionMapf;
		this.collision = collision;
	}
	
	public CollisionMap(float[] collisionMapf, Collider[] collisions) {
		this.collisionMapf = collisionMapf;
		this.collisions = collisions;
	}
}
