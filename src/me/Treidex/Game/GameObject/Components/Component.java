package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.Treidex.Game.GameObject.GameObject;

/**
 * How do you make anything?
 * With Components!
 * 
 * This is the structure for every Component.
 * 
 * @author Treidex
 *
 */
public class Component {
	
	public String name;
	
	/**
	 * Store the Parent Game Object in which
	 * the Component is used inside.
	 */
	protected GameObject parent;
	
	/**
	 * Store the Transform of
	 * the Parent.
	 */
	protected Transform transform;
	
	/**
	 * Structure for Initialization of the Component.
	 */
	public void init() {}
	
	/**
	 * Structure for Initialization of the Component.
	 * 
	 * @param g The Graphics Component.
	 */
	public void draw(Graphics g) {}
	
	/**
	 * Structure for Updating the Component.
	 */
	public void update() {}
	
	/**
	 * Structure for Fixed Updates of the Component.
	 */
	public void fixedUpdate() {}
	
	/**
	 * Structure for Late Updates of the Component.
	 */
	public void lateUpdate() {}
	
	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}
	
	/**
	 * Structure for Key Pressing for the Component.
	 * 
	 * @param e Key Event.
	 */
	public void keyPressed(KeyEvent e) {}
	
	/**
	 * Structure for Key Releasing for the Component.
	 * 
	 * @param e Key Event.
	 */
	public void keyReleased(KeyEvent e) {}
	
	public void onDestroy() {}
	
	public GameObject getParent() {
		return parent;
	}
	
	/**
	 * Used for the Game Object to set
	 * the Components Parent.
	 * 
	 * @param parent The Parent to be set.
	 */
	public void setParent(GameObject parent) {
		this.parent = parent;
		
		transform = parent.transform;
	}
	
	public String toString() {
		return "Component!";
	}
}
