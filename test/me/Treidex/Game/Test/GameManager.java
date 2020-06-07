package me.Treidex.Game.Test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.maths.Vector2;

public class GameManager extends me.Treidex.Game.GameManager {
	RectangleCollider rectColl;
	Image background = (Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui/KIU.png")));
	Image backgroundResized;
	public GameManager() {
//		rectColl = new RectangleCollider(
//				false,
//				2
//			) {
//				public void onCollisionEnter(float[] collisionMap) {System.out.println(collisionMap);}
//				public void onCollisionExit() {System.out.println("Exited");}
//			};
			
		
		gameObjects = new GameObject[] {
				new GameObject(
					new Transform(
						new Vector2(0, 0),
						new Vector2(100, 100),
						0f
					),
//					new Sprite(
//						"/sprites/Ball.png"
//					),
					new RectangleCollider(
						false,
						54
					),
					new Physics(
						ColliderType.Rectangle,
						new Vector2(0.1f, 1f),
						0.14f,
						0.69f
					)
				),
				new GameObject(
					new Transform(
						new Vector2(150, 600),
						new Vector2(900, 500),
						0f
					),
//					new Sprite(
//						"/sprites/Ball.png"
//					),
					new RectangleCollider(
						false,
						6
					)
				),
				new GameObject(
					new Transform(
						new Vector2(155, 0),
						new Vector2(100, 100),
						0f
					),
//					new Sprite(
//						"/sprites/Ball.png"
//					),
					new EllipseCollider(
						false,
						2
					),
					new Physics(
						ColliderType.Ellipse,
						new Vector2(0, 1),
						0.14f,
						0.69f
					)
				)
//				new Tester(
//					new Transform(
//						new Vector2(0, 100),
//						new Vector2(100, 50),
//						0f
//					),
//					new RectangleCollider(
//						false,
//						2
//					) {
//						public void onCollisionEnter(float[] collisionMap) {System.out.println(collisionMap);}
//						public void onCollisionExit() {System.out.println("Exited");}
//					}
//				)
		};
	}
	
	public void init() {
		setParents();
		
		super.init();
	}
	
	public void draw(Graphics g) {
//		if (backgroundResized != null)
//		g.drawImage(backgroundResized, 0, 0, null);
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, runner.getWidth(), runner.getHeight());
		
		super.draw(g);
		
//		backgroundResized = background.getScaledInstance(runner.getWidth(), runner.getHeight(), Image.SCALE_DEFAULT);
	}
//	
	public void update() {
		super.update();
	}
//	
//	public void fixedUpdate() {
//		super.fixedUpdate();
//	}
//	
//	public void lateUpdate() {
//		super.lateUpdate();
//	}
}
