package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import me.Treidex.Game.GameObject.GameObject;

public class Component {
	protected GameObject parent;
	protected Transform transform;
	
	public void init() {
	}
	public void draw(Graphics g) {
	}
	public void update() {
	}
	public void fixedUpdate() {
	}
	public void lateUpdate() {
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	
	public void setParent(GameObject parent) {
		this.parent = parent;
		
		transform = parent.transform;
	}
}
