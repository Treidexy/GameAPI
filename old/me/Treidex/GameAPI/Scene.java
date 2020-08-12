package me.Treidex.GameAPI;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.GameObject.Prefab;
import me.Treidex.GameAPI.Util.Math.Mathf;
import me.Treidex.GameAPI.Util.Math.Vector2;


/**
 * Just what it says.
 * 
 * @author Treidex
 *
 */
public class Scene implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Translationg of the Scene.
	 * 
	 * @see me.Treidex.GameAPI.GameObject.Components.Follow Follow.
	 */
	public Vector2 translate = Vector2.zero;
	
	/**
	 * The Name of the Scene.
	 */
	public String name;
	
	/**
	 * List of Game Objects not Affected by Translation.
	 */
	public GameObject[] noTranslateObjects = new GameObject[0];
	
	/**
	 * List of Static Game Objects.
	 */
	public GameObject[] staticObjects = new GameObject[0];
	
	/**
	 * The List of Game Objects.
	 */
	public GameObject[] gameObjects = new GameObject[0];
	
	/**
	 * Create the Scene
	 * 
	 * @param name The Name of the Scene.
	 */
	public Scene(String name) { this.name = name; }
	
	/**
	 * Create the Scene.
	 * 
	 * @param name The Name of the Scene.
	 * @param noTranslateObjects List of Game Objects not Affected by Translation.
	 * @param staticObjects List of Static Game Objects.
	 * @param gameObjects The List of Game Objects.
	 */
	@Deprecated
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
	
	public final void setScenes() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			noTranslateObject.setScene(this);
		}
		for (GameObject gameObject : gameObjects) {
			gameObject.setScene(this);
		}
		for (GameObject staticObject : staticObjects) {
			staticObject.setScene(this);
		}
	}
	
	/**
	 * Initializes
	 * all the Game Objects.
	 * Called when Initialized.
	 */
	public void init() {
		setParents();
		setScenes();
		
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.init();
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.init();
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
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
			if (noTranslateObject.isActive())
				noTranslateObject.draw(g);
		}
		
		g.translate((int) translate.x, (int) translate.y);
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.draw(g);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
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
			if (noTranslateObject.isActive())
				noTranslateObject.update();
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.update();
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.update();
		}
	}
	
	
	/**
	 * Another method for updating.
	 * Called a fixed times a second.
	 */
	public void fixedUpdate() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.fixedUpdate();
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.fixedUpdate();
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.fixedUpdate();
		}
	}
	
	/**
	 * Another method for updating.
	 * Called at the end of an update.
	 */
	public void lateUpdate() {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.lateUpdate();
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.lateUpdate();
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.lateUpdate();
		}
	}
	
	/**
	 * Called whenever a Mouse Clicks.
	 * @param e The Mouse Event
	 */
	public void mouseClicked(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.mouseClicked(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.mouseClicked(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.mouseClicked(e);
		}
	}

	/**
	 * Called whenever a Mouse Presses.
	 * @param e The Mouse Event
	 */
	public void mousePressed(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.mousePressed(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.mousePressed(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.mousePressed(e);
		}
	}

	/**
	 * Called whenever a Mouse Releases.
	 * @param e The Mouse Event
	 */
	public void mouseReleased(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.mouseReleased(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.mouseReleased(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.mouseReleased(e);
		}
		
	}
	
	/**
	 * Called whenever a Mouse Drags.
	 * @param e The Mouse Event
	 */
	public void mouseDragged(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.mouseDragged(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.mouseDragged(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.mouseDragged(e);
		}
	}

	/**
	 * Called whenever a Mouse Moves.
	 * @param e The Mouse Event
	 */
	public void mouseMoved(MouseEvent e) {
		for (GameObject noTranslateObject : noTranslateObjects) {
			if (noTranslateObject.isActive())
				noTranslateObject.mouseMoved(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.mouseMoved(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
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
			if (noTranslateObject.isActive())
				noTranslateObject.keyPressed(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.keyPressed(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
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
			if (noTranslateObject.isActive())
				noTranslateObject.keyReleased(e);
		}
		for (GameObject gameObject : gameObjects) {
			if (gameObject.isActive())
				gameObject.keyReleased(e);
		}
		for (GameObject staticObject : staticObjects) {
			if (staticObject.isActive())
				staticObject.keyReleased(e);
		}
	}
	
	/**
	 * Called when the Scene gets Destroyed.
	 */
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
	
	/**
	 * Method to Find a Game Object by its Name.
	 * 
	 * @param name The Name of the Game Object.
	 * 
	 * @return The Game Object with that Name.
	 */
	public final GameObject findGameObjectByName(String name) {
		GameObject out = null;
		for (GameObject gameObject: gameObjects) {
			if (gameObject.name.equals(name))
				out = gameObject;
		}
		
		return out;
	}
	
	/**
	 * Spawn a GameObject
	 * 
	 * @param objectToSpawn The Game Object you want to Spawn.
	 */
	public void spawn(GameObject objectToSpawn) {
		gameObjects = Mathf.<GameObject> addToArray(GameObject.class, gameObjects, objectToSpawn);
		gameObjects[Mathf.<GameObject> getIndexFromArray(objectToSpawn, gameObjects)].init();
		setParents();
		setScenes();
	}
	
	/**
	 * Instansiate a Prefab into the Scene
	 * 
	 * @param prefab The Prefab to Instansiate.
	 * 
	 * @return The Instansiated Prefab.
	 */
	public GameObject instansiate(Prefab prefab) {
		GameObject out = prefab.instansiate();
		
		spawn(out);
		
		return out;
	}
	
	/**
	 * Method to Destroy all Game Objects in the Scene.
	 */
	public void destroyAll() {
		for (int i = 0; i < gameObjects.length; i++) {
			destroy(0);
		}
		
		for (int i = 0; i < staticObjects.length; i++) {
			destroyStatic(0);
		}
		
		for (int i = 0; i < noTranslateObjects.length; i++) {
			destroyNoTranslate(0);
		}
	}
	
	/**
	 * Method to Destroy a Game Object.
	 * 
	 * @param objectToDestroy The Game Object you want to Destroy.
	 */
	public void destroy(GameObject objectToDestroy) {
		destroy(Mathf.<GameObject> getIndexFromArray(objectToDestroy, gameObjects));
	}
	
	/**
	 * Method to Destroy a Static Game Object.
	 * 
	 * @param objectToDestroy The Static Game Object you want to Destroy.
	 */
	public void destroyStatic(GameObject objectToDestroy) {
		destroyStatic(Mathf.<GameObject> getIndexFromArray(objectToDestroy, staticObjects));
	}
	
	/**
	 * Method to Destroy a No Translate Game Object.
	 * 
	 * @param objectToDestroy The No Translate Game Object you want to Destroy.
	 */
	public void destroyNoTranslate(GameObject objectToDestroy) {
		destroyNoTranslate(Mathf.<GameObject> getIndexFromArray(objectToDestroy, noTranslateObjects));
	}
	
	/**
	 * Method to Destroy a Game Object using its position in the array.
	 * 
	 * @param index The index of the Game Object you want to Destroy.
	 */
	public void destroy(int index) {
		gameObjects[index].onDestroy();
		
		gameObjects = Mathf.<GameObject> removeFromArray(GameObject.class, gameObjects, index);
	}
	
	/**
	 * Method to Destroy a Static Game Object using its position in the array.
	 * 
	 * @param index The index of the Static Game Object you want to Destroy.
	 */
	public void destroyStatic(int index) {
		staticObjects[index].onDestroy();
		
		staticObjects = Mathf.<GameObject> removeFromArray(GameObject.class, staticObjects, index);
	}
	
	/**
	 * Method to Destroy a No Translate Game Object using its position in the array.
	 * 
	 * @param index The index of the No Translate Game Object you want to Destroy.
	 */
	public void destroyNoTranslate(int index) {
		noTranslateObjects[index].onDestroy();
		
		noTranslateObjects = Mathf.<GameObject> removeFromArray(GameObject.class, noTranslateObjects, index);
	}
}
