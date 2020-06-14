package me.Treidex.Game.Test;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.Game.GameManager;
import me.Treidex.Game.Program;
import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.Math.*;
import me.Treidex.Game.SuperClasses.Scene;

public class Main {
	public static final int width = 1200;
	public static final int height = 1080;
	
	static GameManager gameManager;
	static Scene scene;
	static GameObject player;
	static GameObject[] gameObjects;
	
	private static void init() {
		player = new GameObject(
				new Transform(
					new Vector2(0, 0),
					new Vector2(50, 100),
					0f
				),
				new Follow(
					0.1f,
					width,
					height
				),
				new PlayerController(
					500,
					69,
					false
				),
				new SpriteRenderer(
					"/gui/KIU.png"
				),
				new RectangleCollider(
					false,
					2,
					new ColliderEvent() {
						public void onCollisionEnter(float[] collisionMap, Collider[] colliders) {
							System.out.println("Entering Collision with: " + colliders[0]);
						}
						
						public void onCollisionExit() {
							System.out.println("Exited Collision!D");
						}
					}
				),
				new Physics(
					ColliderType.Rectangle,
					new Vector2(0, 269),
					0.36f,
					0.14f
				)
			);
			gameObjects = new GameObject[] {
				player,
				new GameObject(
					new Transform(
						new Vector2(-15, 500),
						new Vector2(690, 50),
						0f
					),
					new SpriteRenderer(
						"/gui/Menu.png"
					),
					new RectangleCollider(
						false,
						2
					)
				),
				new GameObject(
					new Transform(
						new Vector2(700, 450),
						new Vector2(690, 50),
						0f
					),
					new SpriteRenderer(
						"/gui/Menu.png"
					),
					new RectangleCollider(
						false,
						2
					)
				)
			};
	}
	
	public static void main(String[] args) {
		
		
		
		scene = new Scene() {
			public void init() {
				Main.init();
				
				this.gameObjects = Main.gameObjects;
				System.out.println('f');
				
				super.init();
			}
			
			public void draw(Graphics g) {
				g.setColor(new Color(255, 255, 255));
				g.fillRect(0, 0, width, height);
				
				super.draw(g);
			}
			
			public void fixedUpdate() {
				super.fixedUpdate();
				
				if (player.transform.position.y >= 700) {
					gameManager.changeScene(scene);
				}
//				if (scene.gameObjects.length >= 3)
//				scene.destroy(2);
			}
		};
		

		gameManager = new GameManager(scene);
		
		Program program = new Program(gameManager, 1337, 60, width, height);
		program.start();
	}
}