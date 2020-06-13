package me.Treidex.Game.GameObject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import me.Treidex.Game.GameObject.Components.Component;
import me.Treidex.Game.GameObject.Components.Transform;

/**
 * Class of every Object On-Scene.
 * 
 * @author Treidex
 *
 */
public class GameObject {
	
	/**
	 * The Transform of the Game Object.
	 */
	public Transform transform;
	
	/**
	 * The Components the Game Object contains.
	 */
	public Component[] components;
	
	/**
	 * Initialize the Game Object.
	 * 
	 * @param transform The Transform of the Game Object.
	 * @param components The Components the Game Object contains.
	 */
	public GameObject(Transform transform, Component... components) {
		this.transform = transform;
		this.transform.setParent(this);
		this.components = components;
	}
	
	/**
	 * Sets the Parents of the Components
	 * in Game Object.
	 */
	public void setParents() {
		for (Component component : components) {
			component.setParent(this);
		}
	}
	
	/**
	 * Allows Method for getting Component.
	 * 
	 * @param <T> Component Type.
	 * @param componentClass Component Class.
	 * @return Component.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent (Class<T> componentClass){
	    for (Component c: this.components){
	        if(c.getClass() == componentClass) {
	            return (T) c;
	        }
	    }
	    return null;
	}
	
	// Child Methods
	
	/**
	 * Initialize all Components.
	 */
	public void init() {
		for (Component component : components) {
			component.init();
		}
	}
	
	/**
	 * Draw all Components
	 * 
	 * @param g Graphics Component.
	 */
	public void draw(Graphics g) {
		for (Component component : components) {
			component.draw(g);
		}
	}
	
	/**
	 * Update all Components.
	 */
	public void update() {
		for (Component component : components) {
			component.update();
		}
	}
	
	/**
	 * Fix Update all Components.
	 */
	public void fixedUpdate() {
		for (Component component : components) {
			component.fixedUpdate();
		}
	}
	
	/**
	 * Late Update all Components.
	 */
	public void lateUpdate() {
		for (Component component : components) {
			component.lateUpdate();
		}
	}
	
	/**
	 * Key Pressed Event for all Components.
	 * 
	 * @param e Key Event.
	 */
	public void keyPressed(KeyEvent e) {
		for (Component component : components) {
			component.keyPressed(e);
		}
	}
	
	/**
	 * Key Released Event for all Components.
	 * 
	 * @param e Key Event.
	 */
	public void keyReleased(KeyEvent e) {
		for (Component component : components) {
			component.keyReleased(e);
		}
	}
	
	public void onDestroy() {
		for (Component component : components) {
			component.onDestroy();
		}
	}
}