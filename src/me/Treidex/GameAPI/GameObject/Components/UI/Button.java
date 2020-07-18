package me.Treidex.GameAPI.GameObject.Components.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.GameObject.Components.UI.Events.ButtonEvent;
import me.Treidex.GameAPI.Util.Util;
import me.Treidex.GameAPI.Util.Math.Vector2;

/**
 * 
 * Buttons are Essential to Everything.
 * 
 * @author Treidex
 *
 */
public class Button extends UI {
	
	/**
	 * List of all the Button Events.
	 * 
	 * @see me.Treidex.GameAPI.GameObject.Components.UI.Events.ButtonEvent Button Event.
	 */
	public ButtonEvent[] buttonEvents;
	
	/**
	 * The Normal Color of the Button.
	 */
	public Color normalCol;
	
	/**
	 * The Color of the Button when the Mouse is Over it.
	 */
	public Color overCol;
	
	/**
	 * The Pressed Color of the Button.
	 */
	public Color pressedCol;
	
	/**
	 * Is the Mouse Over?
	 */
	protected boolean mouseOver;
	
	/**
	 * Is the Mouse Pressed.
	 */
	protected boolean mousePressed;
	
	/**
	 * Is the Mouse Pressing the Button?
	 */
	protected boolean clicked;
	
	protected JSONObject buttonM;
	protected JSONObject ncMap;
	protected JSONObject ocMap;
	protected JSONObject pcMap;
	protected JSONArray btA;
	
	/**
	 * Create the Button.
	 * 
	 * @param normalCol The Normal Color of the Button
	 * @param overCol The Color of the Button when the Mouse is Over it.
	 * @param pressedCol The Pressed Color of the Button.
	 * @param buttonEvents The Button Events.
	 */
	public Button(Color normalCol, Color overCol, Color pressedCol, ButtonEvent... buttonEvents) {
		initID("UI->Button");
		
		this.normalCol = normalCol;
		this.overCol = overCol;
		this.pressedCol = pressedCol;
		this.buttonEvents = buttonEvents;
	}
	
	/**
	 * Draw the Button.
	 */
	public void draw(Graphics g) {
		g.setColor(normalCol);
		
		if (mouseOver)
			g.setColor(overCol);
		
		if (clicked)
			g.setColor(pressedCol);
		
		g.fillRoundRect((int) transform.position().x, (int) transform.position().y, (int) transform.size.x, (int) transform.size.y, 5, 5);
	}
	
	/**
	 * Mouse Pressed Button Event.
	 */
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		clicked = mouseOver;
		
		if (clicked)
			for (ButtonEvent buttonEvent : buttonEvents) {
				buttonEvent.mousePressed(new Button[] {this});
			}
	}
	
	/**
	 * Mouse Released Button Event.
	 */
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		
		if (clicked)
			for (ButtonEvent buttonEvent : buttonEvents) {
				buttonEvent.mouseReleased(new Button[] {this});
			}
		
		clicked = false;
	}
	
	/**
	 * Mouse Moved Button Event.
	 */
	public void mouseMoved(MouseEvent e) {
		Vector2 mouse = new Vector2(e.getX(), e.getY());
		
		if (
			Vector2.both_greaterThanOREqualTo(mouse, transform.position()) &&
			Vector2.both_lessThanOREqualTo(mouse, Vector2.add(transform.position(), transform.size))
		) {
			mouseOver = true;
			
			for (ButtonEvent buttonEvent : buttonEvents) {
				buttonEvent.mouseOver(new Button[] {this});
			}
		} else
			mouseOver = false;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		buttonM = new JSONObject();
		ncMap = Util.Color.getMap(normalCol);
		ocMap = Util.Color.getMap(overCol);
		pcMap = Util.Color.getMap(pressedCol);
		
		buttonM.put("normal-color", ncMap);
		buttonM.put("over-color", ocMap);
		buttonM.put("pressed-color", pcMap);
		
		return buttonM;
	}
	
	public static Component loadMap(final JSONObject map) {
		Color normalCol = Util.Color.loadMap((JSONObject) map.get("normal-color"));
		Color overCol = Util.Color.loadMap((JSONObject) map.get("over-color"));
		Color pressedCol = Util.Color.loadMap((JSONObject) map.get("pressed-color"));
		
		return new Button(normalCol, overCol, pressedCol);
	}
}
