package me.Treidex.Game.Test;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.Math.Vector2;

public class GameManager extends me.Treidex.Game.GameManager {
	public GameManager() {
		gameObjects = new GameObject[] {
			new GameObject(
				new Transform(
					new Vector2(0, 0),
					new Vector2(50, 100),
					0f
				),
				new PlayerController(
					25,
					100,
					false
				),
				new SpriteRenderer(
					"/gui/KIU.png"
				),
				new RectangleCollider(
					false,
					2
				),
				new Physics(
					ColliderType.Rectangle,
					new Vector2(0, 15),
					0.14f,
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
	}

	public void init() {
		setParents();
		
		super.init();
	}

	public void draw(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, runner.getWidth(), runner.getHeight());
		
		super.draw(g);
	}

	public void update() {
		super.update();
	}
	
	// Maybe Later...
//	private void readJSON(String filename) {
//		try {
//			Object jsonObj = new JSONParser().parse(new FileReader("GameObjects.json"));
//			
//			JSONArray json = (JSONArray) jsonObj;
//			
//			for (int i = 0; i < json.size(); i++) {
//				json.get(i)
//			}
//		} catch (Exception e) {
//			System.err.println("[!]: Error reading file \"" + filename + "\": " + e.toString());
//		}
//	}
}
