package me.Treidex.GameAPI.GameObject.Components.UI.Events;

import me.Treidex.GameAPI.GameObject.Components.UI.Button;

public interface ButtonEvent {
	public void mouseOver(Button[] b);
	public void mousePressed(Button[] b);
	public void mouseReleased(Button[] b);
}
