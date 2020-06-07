package me.Treidex.Game;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.Game.GameObject.GameObject;

public class GameManager {
	public GameObject[] gameObjects;
	
	protected Game runner;
	
	public final void setParents() {
		for (GameObject gameObject : gameObjects) {
			gameObject.setParents();
		}
	}
	
	public void init() {
		for (GameObject gameObject : gameObjects) {
			gameObject.init();
		}
	}
	public void draw(Graphics g) {
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(g);
		}
	}
	
	public void update() {
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	public void fixedUpdate() {
		for (GameObject gameObject : gameObjects) {
			gameObject.fixedUpdate();
		}
	}
	
	public void lateUpdate() {
		for (GameObject gameObject : gameObjects) {
			gameObject.lateUpdate();
		}
	}

	public void setRunner(Game runner) {
		this.runner = runner;
	}
}
