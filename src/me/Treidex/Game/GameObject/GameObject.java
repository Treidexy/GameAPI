package me.Treidex.Game.GameObject;

import java.awt.Graphics;

import me.Treidex.Game.GameObject.Components.Component;
import me.Treidex.Game.GameObject.Components.Transform;

public class GameObject {
	public Transform transform;
	public Component[] components;
	
	public GameObject(Transform transform, Component... components) {
		this.transform = transform;
		this.transform.setParent(this);
		this.components = components;
	}
	
	public void setParents() {
		for (Component component : components) {
			component.setParent(this);
		}
	}
	
	public void setComponents(Component... components) {
		this.components = components;
	}
	
	public <T extends Component> T getComponent (Class<T> componentClass){
	    for (Component c: this.components){
	    	System.out.println("Checking: " + c.getClass().getSimpleName() + "...");
	    	
	        if(c.getClass() == componentClass) {
	            System.out.println("Component of type: " + c.getClass().getSimpleName() + " found!");
	            return (T) c;
	        }
	    }
	    System.out.println("No component found");
	    return null;
	}
	
	// Methods
	public void init() {
		for (Component component : components) {
			component.init();
		}
	}
	public void draw(Graphics g) {
		for (Component component : components) {
			component.draw(g);
		}
	}
	public void update() {
		for (Component component : components) {
			component.update();
		}
	}
	public void fixedUpdate() {
		for (Component component : components) {
			component.fixedUpdate();
		}
	}
	public void lateUpdate() {
		for (Component component : components) {
			component.lateUpdate();
		}
	}
}