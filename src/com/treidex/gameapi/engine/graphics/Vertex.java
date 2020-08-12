package com.treidex.gameapi.engine.graphics;

import com.treidex.gameapi.engine.math.Vector2f;
import com.treidex.gameapi.engine.math.Vector3f;

public class Vertex
{
	private Vector3f position;
	private Vector2f uvMap;
	private int      color;

	public Vertex(Vector3f position, int color)
	{
		this.position = position;
		this.color    = color;
	}

	public Vertex(Vector3f position, Vector2f uvMap)
	{
		this.position = position;
		this.uvMap    = uvMap;
	}

	public Vertex(float x, float y, float z, int color)
	{
		this(new Vector3f(x, y, z), color);
	}

	public Vertex(float x, float y, float z, float uvX, float uvY)
	{
		this(new Vector3f(x, y, z), new Vector2f(uvX, uvY));
	}

	public Vector3f getPosition()
	{ return position; }

	public Vector2f getUvMap()
	{ return uvMap; }

	public int getColor()
	{ return color; }
}
