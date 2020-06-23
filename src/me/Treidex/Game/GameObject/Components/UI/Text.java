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
		
		drawString(g, text, (int) transform.position().x, (int) transform.position().y);
	}
	
	private void drawString(Graphics g, String text, int x, int y) {
		if (text.contains("\n"))
	        for (String line : text.split("\n"))
	            g.drawString(line, x, y += g.getFontMetrics().getHeight());
		else
			g.drawString(text, x, y);
    }
}
