package me.Treidex.Game.GameObject;

import me.Treidex.Game.GameObject.Components.Component;
import me.Treidex.Game.GameObject.Components.Transform;
import me.Treidex.Game.Scene.Scene;

public class GOMethods {
	public String name;
	
	public GameObject parent;
	/**
	 * The Transform of the Game Object.
	 */
	public Transform transform;
	
	/**
	 * The Components the Game Object contains.
	 */
	public Component[] components;
	
	public GameObject[] children;
	
	public Scene scene;
	
	protected String sceneName;
	protected boolean isActive = true;
	protected boolean childrenNull = false;
	
	public void setActive(boolean active) {
		this.isActive = active;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setParent(GameObject parent) {
		this.parent = parent;
	}
	
	public <T extends Component> boolean hasComponent(Class<T> componentClass){
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
	public <T extends Component> T getComponent(Class<T> componentClass){
	    for (Component c: this.components){
	        if(c.getClass() == componentClass) {
	            return (T) c;
	        }
	    }
	    return null;
	}
}
