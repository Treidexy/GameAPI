package me.Treidex.Game.SuperClasses;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import me.Treidex.Game.GameWindow;
import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.GameObject.GameObject;


/**
 * Just what it says.
 * 
 * @author Treidex
 *
 */
@Unfinished
public class Scene {
	/**
	 * The List of Game Objects.
	 */
	public GameObject[] gameObjects;
	
	protected GameWindow window;
	
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
		setParents();
		
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
}
