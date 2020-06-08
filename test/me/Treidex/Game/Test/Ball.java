package me.Treidex.Game.Test;

import java.awt.Color;
import java.awt.Graphics;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.GameObject.Components.Component;
import me.Treidex.Game.GameObject.Components.Transform;

public class Ball extends GameObject {
	public Ball(Transform transform, Component... components) {
		super(transform, components);
	}
	
	public void init() {
		super.init();
	}

	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillOval((int) transform.position.x, (int) transform.position.y, (int) transform.size.x, (int) transform.size.y);
		
		super.draw(g);
	}
}