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
	public static final int width = 1000;
	public static final int height = 800;
	
	public static void main(String[] args) {
		GameManager gameManager = new GameManager(new Scene() {
			public void init() {
				gameObjects = new GameObject[] {
					new GameObject(
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
							420,
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
								public void onCollisionEnter(float[] collisionMap) {
									System.out.println("Entering Collision!D");
								}
								
								public void onCollisionExit() {
									System.out.println("Exited Collision!D");
									System.exit(1);
								}
							}
						),
						new Physics(
							ColliderType.Rectangle,
							new Vector2(0, 269),
							0.36f,
							0.14f
						)
					),
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
					)
				};
				
				super.init();
			}
			
			public void draw(Graphics g) {
				g.setColor(new Color(255, 255, 255));
				g.fillRect(0, 0, width, height);
				
				super.draw(g);
			}
		});
		
		gameManager.scene = gameManager.scenes[0];
		Program program = new Program(gameManager, 1337, 60, width, height);
		program.start();
	}
}