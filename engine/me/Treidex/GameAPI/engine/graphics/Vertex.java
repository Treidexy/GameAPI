package me.Treidex.GameAPI.engine.graphics;

import me.Treidex.GameAPI.Util.Math.Vector2;

public class Vertex
{
	private Vector2 position, uvMap;
	private int color;
	
	public Vertex(Vector2 position, int color)
	{
		this.position = position;
		this.color = color;
	}
	
	public Vertex(Vector2 position, Vector2 uvMap)
	{
		this.position = position;
		this.uvMap = uvMap;
	}
	
	public Vertex(float x, float y, int color)
	{
		this(new Vector2(x, y), color);
	}
	
	public Vertex(float x, float y, float uvX, float uvY)
	{
		this(new Vector2(x, y), new Vector2(uvX, uvY));
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getUvMap() {
		return uvMap;
	}

	public int getColor() {
		return color;
	}
}
