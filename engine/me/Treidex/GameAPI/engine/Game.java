package me.Treidex.GameAPI.engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import me.Treidex.GameAPI.Util.Math.Mathf;
import me.Treidex.GameAPI.engine.graphics.Material;
import me.Treidex.GameAPI.engine.graphics.Renderer;
import me.Treidex.GameAPI.engine.graphics.Shader;
import me.Treidex.GameAPI.engine.graphics.Shape;
import me.Treidex.GameAPI.engine.graphics.Vertex;
import me.Treidex.GameAPI.engine.io.Input;
import me.Treidex.GameAPI.engine.io.Window;

public class Game implements Runnable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int width, height;
	
	private Thread thread;
	private Window window;
	private Renderer renderer;
	private Shader shader;
	
	private int color;
	public List<Shape> shapes = new ArrayList<Shape>();
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void start() {
		thread = new Thread(this);
		thread.start(); 
	}

	public void run() {
		init();
		while (!(window.shouldClose() || Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)))
		{
			update();
			draw();
		}
		exit();
	}
	
	private void init() {
		window = new Window("OpenGL Test (GameAPI) - Treidex", width, height);
		shader = new Shader("/shaders/mainVertex.glsl", "/shaders/mainFragment.glsl");
		renderer = new Renderer(shader);
		window.create();
		shader.create();
	}
	
	private void update() {
		window.update();
		width = window.getWidth();
		height = window.getHeight();
	}
	
	private void draw() {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			renderer.drawShape(shapes.get(i));
			shapes.get(i).destroy();
			shapes.remove(i);
		}
		window.swapBuffers();
	}
	
	private void exit() {
		window.destroy();
		shader.destroy();
		for (Shape shape : shapes)
			shape.destroy();
	}
	
	public void color(int newColor)
	{
		color = newColor;
	}
	
	public void background(int color)
	{
		window.setBackground(color);
	}
	
	public void image(String texturePath, float x, float y, float w, float h)
	{
		createShape
		(
			new Vertex[]
			{
				new Vertex(Mathf.map(x    , 0, width, -1, 1), Mathf.map(y    , 0, height, 1, -1), 0, 0),
				new Vertex(Mathf.map(x + w, 0, width, -1, 1), Mathf.map(y    , 0, height, 1, -1), 1, 0),
				new Vertex(Mathf.map(x + w, 0, width, -1, 1), Mathf.map(y + h, 0, height, 1, -1), 1, 1),
				new Vertex(Mathf.map(x    , 0, width, -1, 1), Mathf.map(y + h, 0, height, 1, -1), 0, 1)
			}, new int[]
			{
				0, 1, 2,
				0, 3, 2
			},
			new Material(texturePath)
		);
	}

	public void rect(float x, float y, float w, float h)
	{
		createShape
		(
			new Vertex[]
			{
				new Vertex(Mathf.map(x    , 0, width, -1, 1), Mathf.map(y    , 0, height, 1, -1), color),
				new Vertex(Mathf.map(x + w, 0, width, -1, 1), Mathf.map(y    , 0, height, 1, -1), color),
				new Vertex(Mathf.map(x + w, 0, width, -1, 1), Mathf.map(y + h, 0, height, 1, -1), color),
				new Vertex(Mathf.map(x    , 0, width, -1, 1), Mathf.map(y + h, 0, height, 1, -1), color)
			}, new int[]
			{
				0, 1, 2,
				0, 3, 2
			},
			null
		);
	}
	
	public void ellipse(float x, float y, float w, float h)
	{
		@SuppressWarnings("serial")
		List<Vertex> verticesList = new ArrayList<Vertex>()
		{{
			add(new Vertex(Mathf.map(x, 0, width, -1, 1), Mathf.map(y, 0, height, 1, -1), color));
		}};
		
		List<Integer> indicesList = new ArrayList<Integer>();
		
		for (int ang = 0; ang < 360; ang++)
		{
			float sx = x + (float) Math.sin(Math.toRadians(ang)) * w;
			float sy = y + (float) Math.cos(Math.toRadians(ang)) * h;
			
			verticesList.add(new Vertex(Mathf.map(sx, 0, width, -1, 1), Mathf.map(sy, 0, height, 1, -1), color));
			
			indicesList.add(0);
			indicesList.add(ang - 1 <= 0 ? 359 : ang - 1);
			indicesList.add(ang);
		}
		
		Vertex[] vertices = new Vertex[verticesList.size()];
		vertices = verticesList.toArray(vertices);
		
		Integer[] indicesI = new Integer[indicesList.size()];
		indicesI = indicesList.toArray((Integer[]) indicesI);
		
		int[] indices = new int[indicesI.length];
		for (int i = 0; i < indices.length; i++)
			indices[i] = indicesI[i];
		
		createShape
		(
			vertices,
			indices,
			null
		);
	}
	
	public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
	{
		createShape
		(
			new Vertex[]
			{
				new Vertex(Mathf.map(x1, 0, width, -1, 1), Mathf.map(y1, 0, height, 1, -1), color),
				new Vertex(Mathf.map(x2, 0, width, -1, 1), Mathf.map(y2, 0, height, 1, -1), color),
				new Vertex(Mathf.map(x3, 0, width, -1, 1), Mathf.map(y3, 0, height, 1, -1), color),
				new Vertex(Mathf.map(x4, 0, width, -1, 1), Mathf.map(y4, 0, height, 1, -1), color)
			}, new int[]
			{
				0, 1, 2,
				0, 3, 2
			},
			null
		);
	}
	
	public void createShape(Vertex[] vertices, int[] indices, Material material)
	{
		shapes.add(new Shape(vertices, indices, material) {{create();}});
	}
	
	public void createShape(Shape shape)
	{
		shape.create();
		shapes.add(shape);
	}
}
