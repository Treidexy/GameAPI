package me.Treidex.GameAPI.GameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.GameObject.Components.Transform;
import me.Treidex.GameAPI.Util.Math.Mathf;

/**
 * Class of every Object On-Scene.
 * 
 * @author Treidex
 *
 */
public final class GameObject extends GOMethods {
	
	/**
	 * Initialize the Game Object.
	 * 
	 * @param name The Name of the Game Object
	 * @param transform The Transform of the Game Object.
	 * @param components The Components of the Game Object
	 */
	public GameObject(String name, Transform transform, Component... components) {
		this.name = name;
		this.transform = transform;
		this.components = components;
		
		childrenNull = true;
		this.components = Mathf.addToArray(Component.class, this.components, this.transform);
	}
	
	/**
	 * Initialize the Game Object.
	 * 
	 * @param name The Name of the Game Object
	 * @param transform The Transform of the Game Object.
	 * @param components The Components of the Game Object
	 * @param children The Children of the Game Object.
	 */
	public GameObject(String name, Transform transform, Component[] components, GameObject[] children) {
		this.name = name;
		this.transform = transform;
		this.components = components;
		this.children = children;
		
		for (GameObject child: children) {
			child.setParent(this);
		}
		
		this.components = Mathf.addToArray(Component.class, this.components, this.transform);
	}
	
	/**
	* Initialize the Game Object.
	 * 
	 * @param name The Name of the Game Object
	 * @param isActive Is the Game Object Active?
	 * @param transform The Transform of the Game Object.
	 * @param components The Components of the Game Object
	 * @param children The Children of the Game Object.
	 */
	public GameObject(String name, boolean isActive, Transform transform, Component[] components, GameObject[] children) {
		this.name = name;
		this.isActive = isActive;
		this.transform = transform;
		this.components = components;
		this.children = children;
		
		for (GameObject child: children) {
			child.setParent(this);
		}
		
		this.components = Mathf.addToArray(Component.class, this.components, this.transform);
	}
	
	/**
	 * Sets the Parents of the Components
	 * in Game Object.
	 */
	public void setParents() {
		for (Component component: components) {
			component.setParent(this);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.setParents();
			}
	}
	
	// Child Methods
	
	/**
	 * Initialize all Components.
	 */
	public void init() {
		for (Component component: components) {
			component.init();
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.init();
			}
	}
	
	/**
	 * Draw all Components
	 * 
	 * @param g Graphics Component.
	 */
	public void draw(Graphics g) {
		for (Component component: components) {
			component.draw((Graphics2D) g);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.draw(g);
			}
	}
	
	/**
	 * Update all Components.
	 */
	public void update() {
		for (Component component: components) {
			component.update();
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.update();
			}
	}
	
	/**
	 * Fix Update all Components.
	 */
	public void fixedUpdate() {
		for (Component component : components) {
			component.fixedUpdate();
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.fixedUpdate();
			}
	}
	
	/**
	 * Late Update all Components.
	 */
	public void lateUpdate() {
		for (Component component : components) {
			component.lateUpdate();
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.lateUpdate();
			}
	}
	
	/**
	 * Call Mouse Click Event to all Components.
	 * 
	 * @param e Mouse Event.
	 */
	public void mouseClicked(MouseEvent e) {
		for (Component component : components) {
			component.mouseClicked(e);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.mouseClicked(e);
			}
	}

	/**
	 * Call Mouse Press Event to all Components.
	 * 
	 * @param e Mouse Event.
	 */
	public void mousePressed(MouseEvent e) {
		for (Component component : components) {
			component.mousePressed(e);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.mousePressed(e);
			}
	}

	/**
	 * Call Mouse Release Event to all Components.
	 * 
	 * @param e Mouse Event.
	 */
	public void mouseReleased(MouseEvent e) {
		for (Component component : components) {
			component.mouseReleased(e);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.mouseReleased(e);
			}
	}
	
	/**
	 * Call Mouse Drag Event to all Components.
	 * 
	 * @param e Mouse Event.
	 */
	public void mouseDragged(MouseEvent e) {
		for (Component component : components) {
			component.mouseDragged(e);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.mouseDragged(e);
			}
	}

	/**
	 * Call Mouse Move Event to all Components.
	 * 
	 * @param e Mouse Event.
	 */
	public void mouseMoved(MouseEvent e) {
		for (Component component : components) {
			component.mouseMoved(e);
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.mouseMoved(e);
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
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.keyPressed(e);
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
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.keyReleased(e);
			}
	}
	
	/**
	 * Call On Destroy Methods for all Components.
	 */
	public void onDestroy() {
		for (Component component : components) {
			component.onDestroy();
		}
		
		if (!childrenNull)
			for (GameObject child: children) {
				child.onDestroy();
			}
	}
}