package me.Treidex.Game.GameObject.Components.UI;

import java.awt.*;

public class Text extends UI {
	public String text;
	
	protected Color col;
	protected Font font;
	
	public Text(String text, Color col, Font font) {
		this.text = text;
		this.col = col;
		this.font = font;
	}
	
	public void draw(Graphics g) {
		g.setColor(col);
		g.setFont(font);
		
		g.drawString(text, (int) transform.position().x, (int) transform.position().y);
	}
}
