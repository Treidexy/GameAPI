package me.Treidex.GameAPI.GameObject.Components.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.Util.Util;

public class Text extends UI {
	public String text;
	
	protected Color col;
	protected Font font;
	
	protected JSONObject textM;
	protected JSONObject colM;
	protected JSONObject fontM;
	
	public Text(String text, Color col, Font font) {
		initID("UI->Text");
		
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

	
	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		textM = new JSONObject();
		colM = Util.Color.getMap(col);
		fontM = Util.Font.getMap(font);
		
		textM.put("text", text);
		textM.put("color", colM);
		textM.put("font", fontM);
		
		return textM;
	}
	
	public static Component loadMap(final JSONObject map) {
		Color col = Util.Color.loadMap((JSONObject) map.get("color"));
		Font font = Util.Font.loadMap((JSONObject) map.get("font"));
		
		return new Text((String) map.get("text"), col, font);
	}
}
