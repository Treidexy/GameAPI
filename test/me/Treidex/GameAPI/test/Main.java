package me.Treidex.GameAPI.test;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.GameAPI.GameManager;
import me.Treidex.GameAPI.Program;
import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.GameObject.Components.Follow;
import me.Treidex.GameAPI.GameObject.Components.Physics;
import me.Treidex.GameAPI.GameObject.Components.PlayerController;
import me.Treidex.GameAPI.GameObject.Components.SpriteRenderer;
import me.Treidex.GameAPI.GameObject.Components.Transform;
import me.Treidex.GameAPI.GameObject.Components.Colliders.ColliderType;
import me.Treidex.GameAPI.GameObject.Components.Colliders.RectangleCollider;
import me.Treidex.GameAPI.Scene.Scene;
import me.Treidex.GameAPI.Util.Vector2;

public final class Main {
	private static int width = 1000;
	private static int height = 800;
	
	private static Scene scene;
	private static GameManager gameManager;
	private static Program program;
	
	public static void main(String[] args) {
		scene = new Scene() {
			public void init() {
				name = "Scene 1";
				
				noTranslateObjects = new GameObject[] {};
				staticObjects = new GameObject[] {
					new GameObject(
						"Ground",
						new Transform(
							new Vector2(500, 700),
							new Vector2(1000, 50),
							0
						),
						new SpriteRenderer(
							"gui/Menu.png"
						),
						new RectangleCollider(
							false,
							2
						)
					)
				};
				gameObjects = new GameObject[] {
					new GameObject(
						"Player",
						new Transform(
							new Vector2(0, 0),
							new Vector2(50, 100),
							0
						),
						new Follow(
							0,
							Vector2.zero,
							width,
							height
						),
						new SpriteRenderer(
							"sprites/Ball.png"
						),
						new RectangleCollider(
							false,
							2
						),
						new Physics(
							ColliderType.Rectangle,
							new Vector2(0, 520),
							0f,
							0f
						),
						new PlayerController(
							1000,
							69,
							false
						)
					)
				};
				
				super.init();
			}
			
			public void draw(Graphics g) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, width, height);
				
				super.draw(g);
			}
		};
		
		gameManager = new GameManager(scene);
		program = new Program(gameManager, "Testing the Game Engine - Treidex", 420, 60, width, height);
		program.start();
	}

}
