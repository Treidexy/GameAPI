package me.Treidex.Game.GameObject.Components.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import me.Treidex.Game.GameObject.Components.UI.Events.ButtonEvent;
import me.Treidex.Game.Math.Vector2;

public class Button extends UI {
	public ButtonEvent[] buttonEvents;
	
	protected Color normalCol;
	protected Color overCol;
	protected Color pressedCol;
	
	protected boolean mouseOver;
	protected boolean mousePressed;
	
	public Button(Color normalCol, Color overCol, Color pressedCol, ButtonEvent... buttonEvents) {
		this.normalCol = normalCol;
		this.overCol = overCol;
		this.pressedCol = pressedCol;
		this.buttonEvents = buttonEvents;
	}
	
	public void draw(Graphics g) {
		g.setColor(normalCol);
		
		if (mouseOver)
			g.setColor(overCol);
		
		if (mousePressed)
			g.setColor(pressedCol);
		
		g.fillRoundRect((int) transform.position().x, (int) transform.position().y, (int) transform.size.x, (int) transform.size.y, 5, 5);
	}
	
	public void mousePressed(MouseEvent e) {
		mousePressed = mouseOver;
	}
	
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}
	
	public void mouseMoved(MouseEvent e) {
		Vector2 mouse = new Vector2(e.getX(), e.getY());
		
		if (
			Vector2.greaterThanOREqualTo(mouse, transform.position()) &&
			Vector2.lessThanOREqualTo(mouse, Vector2.add(transform.position(), transform.size))
		) {
			mouseOver = true;
		} else {
			mouseOver = false;
		}
	}
}
