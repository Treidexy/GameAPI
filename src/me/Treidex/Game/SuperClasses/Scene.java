package me.Treidex.Game.SuperClasses;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.Treidex.Game.GameWindow;
import me.Treidex.Game.Anotations.Unfinished;
import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.Math.Mathf;
import me.Treidex.Game.Math.Vector2;


/**
 * Just what it says.
 * 
 * @author Treidex
 *
 */
@Unfinished
public class Scene {
	public GameObject[] staticObjects;
	
	/**
	 * The List of Game Objects.
	 */
	public GameObject[] gameObjects;
	
	public Vector2 translate = Vector2.zero;
	
	protected GameWindow window;
	
	/**
	 * Sets the parents for
	 * all the Game Objects.
	 */
	public final void setParents() {
		for (GameObject staticObject : staticObjects) {
			staticObject.setParents();
		}
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
		
		for (GameObject staticObject : staticObjects) {
			staticObject.scene = this;
			
			staticObject.init();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.scene = this;
			
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
		g.translate((int) translate.x, (int) translate.y);
		
		for (GameObject staticObject : staticObjects) {
			staticObject.draw(g);
		}
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
		for (GameObject staticObject : staticObjects) {
			staticObject.update();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	
	/**
	 * Another method for updating.
	 * Called a fixed times a second.
	 */
	public void fixedUpdate() {
		for (GameObject staticObject : staticObjects) {
			staticObject.fixedUpdate();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.fixedUpdate();
		}
	}
	
	/**
	 * Another method for updating.
	 * Called at the end of an update.
	 */
	public void lateUpdate() {
		for (GameObject staticObject : staticObjects) {
			staticObject.lateUpdate();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.lateUpdate();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		for (GameObject staticObject : staticObjects) {
			staticObject.mouseClicked(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseClicked(e);
		}
	}

	public void mousePressed(MouseEvent e) {
		for (GameObject staticObject : staticObjects) {
			staticObject.mousePressed(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mousePressed(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
		for (GameObject staticObject : staticObjects) {
			staticObject.mouseReleased(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseReleased(e);
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseDragged(e);
		}
	}

	public void mouseMoved(MouseEvent e) {
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseMoved(e);
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
	
	public void onDestroy() {
		for (GameObject gameObject : gameObjects) {
			gameObject.onDestroy();
		}
	}
	
	
	public void spawn(GameObject objectToSpawn) {
		gameObjects = Mathf.<GameObject> addToArray(GameObject.class, gameObjects, objectToSpawn);
	}
	
	public void destroyAll() {
		for (int i = 0; i < gameObjects.length; i++) {
			destroy(i);
		}
	}
	
	public void destroy(GameObject objectToDestroy) {
		destroy(Mathf.<GameObject> getIndexFromArray(objectToDestroy, gameObjects));
	}
	
	public void destroy(int index) {
		gameObjects[index].onDestroy();
		
		gameObjects = Mathf.<GameObject> removeFromArray(GameObject.class, gameObjects, index);
	}
}
