package me.Treidex.Game.Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.Treidex.Game.*;
import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.GameObject.Components.UI.*;
import me.Treidex.Game.GameObject.Components.UI.Events.*;
import me.Treidex.Game.Scene.*;
import me.Treidex.Game.Util.*;

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
					"Player",
					new Transform(
						new Vector2(0, 0),
						new Vector2(50, 100),
						0f
					),
					new Component[] {
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
					},
					new GameObject[] {
						new GameObject(
							"Text1",
							new Transform(
								new Vector2(50, 100),
								Vector2.zero,
								0
							),
							new Text(
								"Lol",
								new Color(0, 0, 0),
								new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 69)
							)
						)
					}
//					new PlayerScore()
				);
				
				noTranslateObjects = new GameObject[] {
//					new GameObject(
//						"Save and Exit Button",
//						new Transform(
//							new Vector2(50, 100),
//							new Vector2(100, 100),
//							0
//						),
//						new Component[] {
//							new Button(
//								new Color(200, 200, 200),
//								new Color(188, 188, 188),
//								new Color(100, 100, 100),
//								new ButtonEvent() {
//									public void mouseOver(Button[] b) {}
//									
//									public void mousePressed(Button[] b) {}
//									
//									public void mouseReleased(Button[] b) {
//										scene.save("scene.json");
//										System.exit(0);
//									}
//								}
//							)
//						},
//						new GameObject[] {
//							new GameObject(
//								"ButtonText",
//								new Transform(
//									new Vector2(5, 45),
//									Vector2.zero,
//									0
//								),
//								new Text(
//									"Save\n and\nExit...",
//									new Color(0, 0, 0),
//									new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 24)
//								)
//							)
//						}
//					)
				};
				
				staticObjects = new GameObject[] {
					new GameObject(
						"Ground1",
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
						"Ground2",
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
					),
					new GameObject(
						"Text2",
						new Transform(
							new Vector2(550, 100),
							Vector2.zero,
							0
						),
						new Text(
							"Dis is a Static Texto!",
							new Color(0, 0, 0),
							new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 69)
						)
					)
				};
				
				gameObjects = new GameObject[] {
					player
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
		
		Program program = new Program(gameManager, "Testing for Game API - Treidex", 120, 60, width, height);
		program.start();
	}
}