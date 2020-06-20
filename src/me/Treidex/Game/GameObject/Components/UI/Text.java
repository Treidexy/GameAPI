package me.Treidex.Game.GameObject.Components.UI;

import java.awt.Graphics;

public class Text extends UI {
	public String text;
	
	public Text(String text, boolean isStatic) {
		super(isStatic);
		this.text = text;
	}
	
	public void draw(Graphics g) {
		if (isStatic)
			g.translate((int) -parent.scene.translate.x, (int) -parent.scene.translate.y);
		
		g.drawString(text, (int) transform.position().x, (int) transform.position().y);
		
		if (isStatic)
			g.translate((int) parent.scene.translate.x, (int) parent.scene.translate.y);
	}
}
