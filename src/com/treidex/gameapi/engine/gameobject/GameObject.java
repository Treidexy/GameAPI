package com.treidex.gameapi.engine.gameobject;

import com.treidex.gameapi.engine.component.Component;
import com.treidex.gameapi.engine.graphics.Mesh;
import com.treidex.gameapi.engine.math.Vector3f;

public class GameObject
{
	private String   name;
	private Vector3f position, rotation, scale;
	private Mesh     mesh;
	
	private Component[] components;

	public GameObject(String name, Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh)
	{
		this.name     = name;
		this.position = position;
		this.rotation = rotation;
		this.scale    = scale;
		this.mesh     = mesh;
	}

	public String getName()
	{ return name; }

	public Vector3f getPosition()
	{ return position; }

	public Vector3f getRotation()
	{ return rotation; }

	public Vector3f getScale()
	{ return scale; }

	public Mesh getMesh()
	{ return mesh; }

}
