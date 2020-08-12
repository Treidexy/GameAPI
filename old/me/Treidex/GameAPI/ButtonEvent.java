package me.Treidex.GameAPI;

import me.Treidex.GameAPI.GameObject.Components.UI.Button;

/**
 * What Happens when a Button gets Clicked?
 * This Happens!
 * 
 * @author Treidex
 *
 */
public interface ButtonEvent {
	
	/**
	 * What Happens when the Mouse is Over the Button?
	 * 
	 * @param b Reference of the Button.
	 */
	public void mouseOver(Button[] b);
	
	/**
	 * What Happens when the Mouse is Pressing the Button?
	 * 
	 * @param b Reference of the Button.
	 */
	public void mousePressed(Button[] b);
	
	/**
	 * What Happens when the Mouse has Released the Button?
	 * 
	 * @param b Reference of the Button.
	 */
	public void mouseReleased(Button[] b);
}
