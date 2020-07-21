package me.Treidex.GameAPI.Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.Treidex.GameAPI.GameManager;
import me.Treidex.GameAPI.Program;
import me.Treidex.GameAPI.Scene;
import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.GameObject.Prefab;
import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.GameObject.Components.Follow;
import me.Treidex.GameAPI.GameObject.Components.Physics;
import me.Treidex.GameAPI.GameObject.Components.PlayerController;
import me.Treidex.GameAPI.GameObject.Components.SpriteRenderer;
import me.Treidex.GameAPI.GameObject.Components.Transform;
import me.Treidex.GameAPI.GameObject.Components.Colliders.ColliderType;
import me.Treidex.GameAPI.GameObject.Components.Colliders.RectangleCollider;
import me.Treidex.GameAPI.GameObject.Components.UI.Text;
import me.Treidex.GameAPI.Test.Components.Arrow;
import me.Treidex.GameAPI.Test.Components.DebugSwitcher;
import me.Treidex.GameAPI.Test.Components.JumpPadSpawner;
import me.Treidex.GameAPI.Test.Components.TimedObject;
import me.Treidex.GameAPI.Util.Constants;
import me.Treidex.GameAPI.Util.Methods;
import me.Treidex.GameAPI.Util.Math.Vector2;

/**
 * 
 * @author Treidex
 *
 */
public final class Main extends Methods implements Constants {
	private static final int width = 1000;
	private static final int height = 800;
	
	private static final String PlayerName = "Treidex";
	
	private static Scene scene;
	public static GameManager gameManager;
	private static Program program;
	
	private static GameObject player;
	
	public static Prefab prefab_JumpPad = new Prefab() {
		public GameObject instansiate() {
			return new GameObject(
				"JUMPAD_",
				new Transform(
					Vector2.zero,
					new Vector2(50, 10),
					0
				),
				new RectangleCollider(
					false,
					2
				),
				new TimedObject(
					0.24f
				)
			);
		}
	};
	
	public static void main(String[] args) {
		scene = new Scene("Main Scene") {
			public void init() {
				player = new GameObject(
					"Player",
					new Transform(
						new Vector2(0, 0),
						new Vector2(50, 100),
						10
					),
					new Component[] {
						new Follow(
							0,
							Vector2.zero,
							width,
							height
						),
						new SpriteRenderer(
							"gui/icon.png"
						),
						new RectangleCollider(
							false,
							2
						),
						new Physics(
							ColliderType.Rectangle,
							new Vector2(0, 540),
							0f,
							0f
						),
						new PlayerController(
							1000,
							69,
							false
						),
						new JumpPadSpawner()
					},
					new GameObject[] {
						new GameObject(
							"Text",
							new Transform(
								new Vector2(0, 0),
								new Vector2((float) (PlayerName.length()) * 6, 20),
								0
							),
							new Text(
								PlayerName,
								Color.CYAN,
								new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 20)
							)
						)
					}
				);
				
				noTranslateObjects = new GameObject[] {};
				staticObjects = new GameObject[] {
					new GameObject(
						"Game Manager",
						Transform.empty,
						new DebugSwitcher()
					),

					new GameObject(
						"Ground 1",
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
					),
					new GameObject(
						"Ground 2",
						new Transform(
							new Vector2(1500, 600),
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
					),
					new GameObject(
						"Ground 3",
						new Transform(
							new Vector2(-500, 900),
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
					),
					new GameObject(
						"Ground 1",
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
					player,
					new GameObject(
							"Arrow",
							new Transform(
								Vector2.zero,
								new Vector2(50, 50),
								45
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
								Vector2.zero,
								0.69f,
								0f
							),
							new Arrow()
						)
				};
				
				super.init();
			}
			
			public void draw(Graphics g) {
				g.setColor(Color.DARK_GRAY);
				g.fillRect(0, 0, width, height);
				
				super.draw(g);
			}
			
			public void fixedUpdate() {
				if (player.transform.position().y >= 1000) {
					gameManager.changeScene(scene);
					println(player.transform.position());
				}
				
				super.fixedUpdate();
			}
		};
		
		gameManager = new GameManager(scene);
		program = new Program(gameManager, "Testing the Game Engine - Treidex", 420, 60, width, height);
		program.start();
	}
}
