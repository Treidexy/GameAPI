package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;

import me.Treidex.Game.GameObject.GameObject;

public class Component {
	private GameObject parent;
	
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
	
	public void setParent(GameObject parent) {
		this.parent = parent;
	}

	public final GameObject parent() {
		return parent;
	}
}
