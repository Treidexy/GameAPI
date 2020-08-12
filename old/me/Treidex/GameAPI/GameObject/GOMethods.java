package me.Treidex.GameAPI.GameObject;

import me.Treidex.GameAPI.Scene;
import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.GameObject.Components.Transform;

/**
 * All the Final Methods for Game Objects.
 * 
 * @author Treidex
 *
 */
public class GOMethods {
	
	/**
	 * The Name of the Game Object.
	 */
	public String name;
	
	/**
	 * The Game Object's parent.
	 */
	public GameObject parent;
	
	/**
	 * The Transform of the Game Object.
	 */
	public Transform transform;
	
	/**
	 * The Components the Game Object contains.
	 */
	public Component[] components;
	
	/**
	 * Children of the Game Object.
	 */
	public GameObject[] children;
	
	/**
	 * The Scene in which the Game Object is in.
	 */
	public Scene scene;
	
	/**
	 * Is the Game Object Active?
	 */
	protected boolean isActive = true;
	
	/**
	 * Does the Game Object have Children?
	 */
	protected boolean childrenNull = false;
	
	/**
	 * Setter for isActive.
	 * 
	 * @param active Whether The Game Object should be Active or not.
	 * 
	 * @see me.Treidex.GameAPI.GameObject.GOMethods#isActive isActive.
	 */
	public final void setActive(boolean active) {
		this.isActive = active;
	}
	
	/**
	 * Getter for isActive.
	 * 
	 * @return Whether The Game Object is Active or not.
	 * 
	 * @see me.Treidex.GameAPI.GameObject.GOMethods#isActive isActive.
	 */
	public final boolean isActive() {
		return isActive;
	}
	
	/**
	 * Set the Parent of this Game Object.
	 * 
	 * @param parent The Parent Game Object.
	 * 
	 * @see me.Treidex.GameAPI.GameObject.GOMethods#parent Parent.
	 */
	public final void setParent(GameObject parent) {
		this.parent = parent;
	}
	
	public final void setScene(Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * See if the Game Object has a Component.
	 * 
	 * @param <T> Component Type.
	 * @param componentClass Component Class.
	 * 
	 * @return If the Game Object has a Component.
	 */
	public final boolean hasComponent(Class<? extends Component> componentClass){
	    for (Component c: this.components){
	        if(c.getClass() == componentClass) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Allows Method for getting Component.
	 * 
	 * @param <T> Component Type.
	 * @param componentClass Component Class.
	 * @return Component.
	 */
	@SuppressWarnings("unchecked")
	public final <T extends Component> T getComponent(Class<T> componentClass){
	    for (Component c: this.components){
	        if(componentClass.isInstance(c)) {
	            return (T) c;
	        }
	    }
	    return null;
	}
}
