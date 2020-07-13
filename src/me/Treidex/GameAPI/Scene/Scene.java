package me.Treidex.GameAPI.Scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.Treidex.GameAPI.GameWindow;
import me.Treidex.GameAPI.Anotations.Unfinished;
import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.Util.Math.Mathf;
import me.Treidex.GameAPI.Util.Math.Vector2;


/**
 * Just what it says.
 * 
 * @author Treidex
 *
 */
@Unfinished
public class Scene {
	
	public Vector2 translate = Vector2.zero;
	
	public String name;
	
	public GameObject[] noTranslateObjects = new GameObject[0];
	
	public GameObject[] staticObjects = new GameObject[0];
	
	/**
	 * The List of Game Objects.
	 */
	public GameObject[] gameObjects = new GameObject[0];
	
	protected GameWindow window;
	
	public Scene() {}
	
	public Scene(String name, GameObject[] noTranslateObjects, GameObject[] staticObjects, GameObject[] gameObjects) {
		this.name = name;
		this.noTranslateObjects = noTranslateObjects;
		this.staticObjects = staticObjects;
		this.gameObjects = gameObjects;
	}
	
	/**
	 * Sets the parents for
	 * all the Game Objects.
	 */
	public final void setParents() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.setParents();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.setParents();
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.setParents();
		}
	}
	
	/**
	 * Initializes
	 * all the Game Objects.
	 * Called when Initialized.
	 */
	public void init() {
		setParents();
		
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.scene = this;
			
			noTranslateObject.init();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.scene = this;
			
			gameObject.init();
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.scene = this;
			
			staticObject.init();
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
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.draw(g);
		}
		
		g.translate((int) translate.x, (int) translate.y);
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(g);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.draw(g);
		}
	}
	
	/**
	 * Updates
	 * all Game Objects.
	 * Called every frame.
	 */
	public void update() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.update();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.update();
		}
	}
	
	
	/**
	 * Another method for updating.
	 * Called a fixed times a second.
	 */
	public void fixedUpdate() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.fixedUpdate();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.fixedUpdate();
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.fixedUpdate();
		}
	}
	
	/**
	 * Another method for updating.
	 * Called at the end of an update.
	 */
	public void lateUpdate() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.lateUpdate();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.lateUpdate();
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.lateUpdate();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.mouseClicked(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseClicked(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.mouseClicked(e);
		}
	}

	public void mousePressed(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.mousePressed(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mousePressed(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.mousePressed(e);
		}
	}

	public void mouseReleased(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.mouseReleased(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseReleased(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.mouseReleased(e);
		}
		
	}
	
	public void mouseDragged(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.mouseDragged(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseDragged(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.mouseDragged(e);
		}
	}

	public void mouseMoved(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.mouseMoved(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.mouseMoved(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.mouseMoved(e);
		}
	}
	
	/**
	 * Called whenever a key is Pressed.
	 *
	 * @param e The Key Event.
	 */
	public void keyPressed(KeyEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.keyPressed(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.keyPressed(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.keyPressed(e);
		}
	}
	
	/**
	 * Called whenever a key is Released.
	 * 
	 * @param e The Key Event.
	 */
	public void keyReleased(KeyEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.keyReleased(e);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.keyReleased(e);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.keyReleased(e);
		}
	}
	
	public void onDestroy() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.onDestroy();
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.onDestroy();
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.onDestroy();
		}
	}
	
	public final GameObject findGameObjectByName(String name) {
		GameObject out = null;
		for (GameObject gameObject: gameObjects) {
			if (gameObject.name.equals(name))
				out = gameObject;
		}
		
		return out;
	}
	
	
	public void spawn(GameObject objectToSpawn) {
		gameObjects = Mathf.<GameObject> addToArray(GameObject.class, gameObjects, objectToSpawn);
		gameObjects[Mathf.<GameObject> getIndexFromArray(objectToSpawn, gameObjects)].init();
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
