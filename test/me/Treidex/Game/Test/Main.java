package me.Treidex.Game.Test;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.Game.GameManager;
import me.Treidex.Game.Program;
import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.GameObject.Components.UI.Text;
import me.Treidex.Game.Math.*;
import me.Treidex.Game.SuperClasses.Scene;
import me.Treidex.Game.Test.GameObjects.Coin;
import me.Treidex.Game.Test.GameObjects.Components.*;

public class Main {
	public static final int width = 1920;
	public static final int height = 1200;
	
	static GameManager gameManager;
	static Scene scene;
	static GameObject player;
	
	public static void main(String[] args) {
		scene = new Scene() {
			public void init() {
				player = null;
				player = new GameObject(
					new Transform(
						new Vector2(0, 0),
						new Vector2(50, 100),
						0f
					),
					new Follow(
						0f,
						new Vector2(0, 0),
						width,
						height
					),
					new PlayerController(
						1000,
						88,
						false
					),
					new SpriteRenderer(
						"/gui/KIU.png"
					),
					new RectangleCollider(
						false,
						5,
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
						new Vector2(0, 420),
						0.36f,
						0.14f
					)
//					new PlayerScore()
				);
				
				gameObjects = new GameObject[] {
//						new Coin(
//								this,
//								new Transform(
//									new Vector2(725, 400),
//									new Vector2(30, 30),
//									0f
//								),
//								ColliderType.Rectangle,
//								6,
//								new SpriteRenderer(
//									"/sprites/Ball.png"
//								)
//							),
//						new GameObject(
//								new Transform(
//									new Vector2(1000, 400),
//									new Vector2(50, 100),
//									0f
//								),
//								new SpriteRenderer(
//									"/sprites/Ball.png"
//								),
//								new RectangleCollider(
//									false,
//									2,
//									new ColliderEvent() {
//										public void onCollisionEnter(float[] collisionMap, Collider[] colliders) {
//											System.exit(0);
//										}
//										
//										public void onCollisionExit() {}
//									}
//								)
//								new Physics(
//									ColliderType.Rectangle,
//									new Vector2(-69f, 0),
//									0.36f,
//									0.14f
//								)
//							),
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
							new Vector2(50, 100),
							Vector2.zero,
							0
						),
						new Text(
							"Lol",
							false
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
				
				super.init();
			}
			
			public void draw(Graphics g) {
				g.setColor(new Color(255, 255, 255));
				g.fillRect(0, 0, width, height);
				
				super.draw(g);
			}
			
			public void fixedUpdate() {
				super.fixedUpdate();
				
//				System.out.println(((PlayerScore) player.components[5]) .score);
				
				if (player.transform.position().y >= 700) {
					gameManager.changeScene(scene);
				}
//				if (scene.gameObjects.length >= 3)
//				scene.destroy(2);
			}
		};
		

		gameManager = new GameManager(scene);
		
		Program program = new Program(gameManager, "Testing for Game API - Treidex", 1337, 60, width, height);
		program.start();
	}
}