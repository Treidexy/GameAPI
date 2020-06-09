package me.Treidex.Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import me.Treidex.Game.GameObject.GameObject;

/**
 * Imagine the world
 * if everyone just did
 * whatever, with no organization.
 * Crazy, right?
 * That is why Managers exist.
 * This is the Manager for your game.
 * 
 * @author Treidex
 *
 */
public class GameManager {
	
	/**
	 * The List of Game Objects.
	 */
	public GameObject[] gameObjects;
	
	/**
	 * The Canvas the Game is ran on.
	 */
	protected Game runner;
	
	/**
	 * Sets the parents for
	 * all the Game Objects.
	 */
	public final void setParents() {
		for (GameObject gameObject : gameObjects) {
			gameObject.setParents();
		}
	}
	
	/**
	 * Initializes
	 * all the Game Objects.
	 * Called when Initialized.
	 */
	public void init() {
		for (GameObject gameObject : gameObjects) {
			gameObject.init();
		}
	}
	
	/**
	 * Draws
	 * all Game Objects.
	 * Called after every frame.
	 * 
	 * @param g The Graphics Component to help Draw.
	 */
	public void draw(Graphics g) {
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(g);
		}
	}
	
	/**
	 * Updates
	 * all Game Objects.
	 * Called every frame.
	 */
	public void update() {
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	
	/**
	 * Another method for updating.
	 * Called a fixed times a second.
	 */
	public void fixedUpdate() {
		for (GameObject gameObject : gameObjects) {
			gameObject.fixedUpdate();
		}
	}
	
	/**
	 * Another method for updating.
	 * Called at the end of an update.
	 */
	public void lateUpdate() {
		for (GameObject gameObject : gameObjects) {
			gameObject.lateUpdate();
		}
	}
	
	/**
	 * Called whenever a key is Pressed.
	 *
	 * @param e The Key Event.
	 */
	public void keyPressed(KeyEvent e) {
		for (GameObject gameObject : gameObjects) {
			gameObject.keyPressed(e);
		}
	}
	
	/**
	 * Called whenever a key is Released.
	 * 
	 * @param e The Key Event.
	 */
	public void keyReleased(KeyEvent e) {
		for (GameObject gameObject : gameObjects) {
			gameObject.keyReleased(e);
		}
	}

	public void setRunner(Game runner) {
		this.runner = runner;
	}
}
