package me.Treidex.Game.GameObject.Components.Colliders;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.Component;
import me.Treidex.Game.GameObject.Components.Transform;
import me.Treidex.Game.maths.Mathf;
import me.Treidex.Game.maths.Vector2;

public abstract class Collider extends Component {
	public static Collider[] colliders = new Collider[0];
	
	public boolean isTrigger;
	public Transform transform;
	public float margin;
	
//	public abstract void onCollisionEnter(float[] collisionMap);
//	public abstract void onCollisionExit();
	
	public abstract float[] checkCollision();
	public abstract float[] checkCollision(Vector2 checkPos);
	
	private boolean pcollided;
	
	public Collider(boolean isTrigger, float margin) {
		this.isTrigger = isTrigger;
		this.margin = margin;
		
		colliders = Mathf.<Collider> addToArray(Collider.class, colliders, this);
	}
	
	public void setParent(GameObject parent) {
		super.setParent(parent);
		
		transform = parent().transform;
	}
	
	public boolean pcollided() {
		return pcollided;
	}
	public void pcollided(boolean pcollided) {
		this.pcollided = pcollided;
	}
}