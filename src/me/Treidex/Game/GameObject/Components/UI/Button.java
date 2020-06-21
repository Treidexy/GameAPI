package me.Treidex.Game.GameObject.Components.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import me.Treidex.Game.GameObject.Components.UI.Events.ButtonEvent;
import me.Treidex.Game.Math.Vector2;

public class Button extends UI {
	public ButtonEvent[] buttonEvents;
	
	public Color normalCol;
	public Color overCol;
	public Color pressedCol;
	
	protected boolean mouseOver;
	protected boolean mousePressed;
	protected boolean clicked;
	
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
		
		if (clicked)
			g.setColor(pressedCol);
		
		g.fillRoundRect((int) transform.position().x, (int) transform.position().y, (int) transform.size.x, (int) transform.size.y, 5, 5);
	}
	
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		clicked = mouseOver;
		
		if (clicked)
			for (ButtonEvent buttonEvent : buttonEvents) {
				buttonEvent.mousePressed(new Button[] {this});
			}
	}
	
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		
		if (clicked)
			for (ButtonEvent buttonEvent : buttonEvents) {
				buttonEvent.mouseReleased(new Button[] {this});
			}
		
		clicked = false;
	}
	
	public void mouseMoved(MouseEvent e) {
		Vector2 mouse = new Vector2(e.getX(), e.getY());
		
		if (
			Vector2.greaterThanOREqualTo(mouse, transform.position()) &&
			Vector2.lessThanOREqualTo(mouse, Vector2.add(transform.position(), transform.size))
		) {
			mouseOver = true;
			
			for (ButtonEvent buttonEvent : buttonEvents) {
				buttonEvent.mouseOver(new Button[] {this});
			}
		} else
			mouseOver = false;
	}
}
