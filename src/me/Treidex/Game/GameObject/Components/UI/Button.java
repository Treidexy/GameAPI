package me.Treidex.Game.GameObject.Components.UI;

import java.awt.Color;

public class Button extends UI {
	protected Color normalCol;
	protected Color overCol;
	protected Color pressedCol;
	
	public Button(boolean isStatic, Color normalCol, Color overCol, Color pressedCol) {
		super(isStatic);
		
		this.normalCol = normalCol;
		this.overCol = overCol;
		this.pressedCol = pressedCol;
	}
	
	
}
