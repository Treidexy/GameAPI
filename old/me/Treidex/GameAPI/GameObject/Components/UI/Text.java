package me.Treidex.GameAPI.GameObject.Components.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * 
 * Text is Super Important.
 * 
 * @author Treidex
 *
 */
public class Text extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8057213038123495572L;

	/**
	 * The actual text.
	 */
	public String text;
	
	/**
	 * The Color of the Text.
	 */
	protected Color col;
	
	/**
	 * The Text Font.
	 */
	protected Font font;
	
	/**
	 * Create the Text Component.
	 * 
	 * @param text The actual text.
	 * @param col The Color of the Text.
	 * @param font The Text Font.
	 */
	public Text(String text, Color col, Font font) {
		initID("UI->Text");
		
		this.text = text;
		this.col = col;
		this.font = font;
	}
	
	/**
	 * Draw the Text Component.
	 */
	public void draw(Graphics2D g) {
		g.setColor(col);
		g.setFont(font);
		
		drawString(g, text, (int) transform.position().x, (int) transform.position().y);
	}
	
	/**
	 * Method for drawing Custom Strings.
	 * 
	 * @param g Graphics
	 * @param text Text to draw.
	 * @param x The X of the Text.
	 * @param y The Y of the Text.
	 */
	private void drawString(Graphics2D g, String text, int x, int y) {
		if (text.contains("\n"))
	        for (String line : text.split("\n"))
	            g.drawString(line, x, y += g.getFontMetrics().getHeight());
		else
			g.drawString(text, x, y);
    }
}
