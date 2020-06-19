package me.Treidex.Game.Test.GameObjects;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.SuperClasses.Scene;
import me.Treidex.Game.Test.GameObjects.Components.PlayerScore;


public class Coin extends GameObject {
	private Scene scene;
	
	private Collider collider;
	private ColliderEvent colliderEvent;
	
	private SpriteRenderer renderer;
	
	public Coin(Scene scene, Transform transform, ColliderType colliderType, float colliderMargin, SpriteRenderer renderer) {
		super(transform, new Component[0]);
		
		this.scene = scene;
		this.renderer = renderer;
		
		initCollider();
		System.out.println(colliderEvent);
		
		switch(colliderType) {
			case Rectangle:
				collider = new RectangleCollider(false, colliderMargin, new ColliderEvent() {
					public void onCollisionEnter(float[] collisionMap, Collider[] colliders) {
						System.out.println("~~~~~~");
						
						PlayerScore player = null;
						
						for (Collider hitCollider: colliders) {
							if (hitCollider.getParent().<PlayerScore> hasComponent(PlayerScore.class))
								player = hitCollider.getParent().<PlayerScore> getComponent(PlayerScore.class);
						}
						
						if (player != null) {
							player.score++;
							
							destroy();
						}
					}
					
					public void onCollisionExit() {}
				});
				break;
			case Ellipse:
				break;
		}
	}
	
	public void init() {
		components = new Component[] {collider, renderer};
		
		for (Component component: components) {
			component.setParent(this);
		}
		
		super.init();
	}
	
	public void initCollider() {
		colliderEvent = new ColliderEvent() {
			public void onCollisionEnter(float[] collisionMap, Collider[] colliders) {
				System.out.println(colliders);
				
				PlayerScore player = null;
				
				for (Collider hitCollider: colliders) {
					if (hitCollider.getParent().<PlayerScore> hasComponent(PlayerScore.class))
						player = hitCollider.getParent().<PlayerScore> getComponent(PlayerScore.class);
				}
				
				if (player != null) {
					player.score++;
					
					destroy();
				}
			}
			
			public void onCollisionExit() {}
		};
	}
	
	private void destroy() {
		scene.destroy(this);
	}
}
