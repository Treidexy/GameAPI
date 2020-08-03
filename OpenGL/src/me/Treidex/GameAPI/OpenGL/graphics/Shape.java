package me.Treidex.GameAPI.OpenGL.graphics;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

import me.Treidex.GameAPI.OpenGL.math.Color;

public class Shape
{
	private Vertex[] vertices;
	private int[] indices;
	private Material material;
	private int vao, pbo, ibo, cbo, tbo;
	
	public Shape(Vertex[] vertices, int[] indices, Material material)
	{
		this.vertices = vertices;
		this.indices = indices;
		this.material = material;
	}
	
	public void create()
	{
		if (material != null)
			material.create();
		
		// Vertex Array
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
		
		// Position
		FloatBuffer positionBuffer = MemoryUtil.memAllocFloat(vertices.length * 2);
		float[] positionData = new float[vertices.length * 2];
		for (int i = 0; i < vertices.length; i++)
		{
			positionData[i * 2] = vertices[i].getPosition().x;
			positionData[i * 2 + 1] = vertices[i].getPosition().y;
		}
		positionBuffer.put(positionData).flip();
		
		pbo = storeData(positionBuffer, 0, 2);
		
		// Color
		FloatBuffer colorBuffer = MemoryUtil.memAllocFloat(vertices.length * 4);
		float[] colorData = new float[vertices.length * 4];
		for (int i = 0; i < vertices.length; i++)
		{
			colorData[i * 4]     = Color.getRed   (vertices[i].getColor());
			colorData[i * 4 + 1] = Color.getGreen (vertices[i].getColor());
			colorData[i * 4 + 2] = Color.getBlue  (vertices[i].getColor());
			colorData[i * 4 + 3] = Color.getAlpha (vertices[i].getColor());
		}
		colorBuffer.put(colorData).flip();
		
		cbo = storeData(colorBuffer, 1, 4);
		
		// UV
		if (material != null)
		{
			FloatBuffer textureBuffer = MemoryUtil.memAllocFloat(vertices.length * 2);
			float[] textureData = new float[vertices.length * 2];
			for (int i = 0; i < vertices.length; i++)
			{
				textureData[i * 2]     = vertices[i].getUvMap().x;
				textureData[i * 2 + 1] = vertices[i].getUvMap().y;
			}
			textureBuffer.put(textureData).flip();
			
			tbo = storeData(textureBuffer, 2, 2);
		}
		
		// Indices
		IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
		indicesBuffer.put(indices).flip();
		
		ibo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	
	private int storeData(FloatBuffer buffer, int index, int size)
	{
		int bufferID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, bufferID);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(index, size, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
		return bufferID;
	}
	
	public void destroy()
	{
		GL15.glDeleteBuffers(pbo);
		GL15.glDeleteBuffers(ibo);
		GL15.glDeleteBuffers(cbo);
		if (material != null)
			GL15.glDeleteBuffers(tbo);
		
		GL30.glDeleteVertexArrays(vao);
		
		if (material != null)
			material.destroy();
	}
	
	public Vertex[] getVertices()
	{
		return vertices;
	}

	public int[] getIndices()
	{
		return indices;
	}

	public int getVAO()
	{
		return vao;
	}

	public int getPBO()
	{
		return pbo;
	}
	
	public int getCBO()
	{
		return cbo;
	}

	public int getTBO()
	{
		return tbo;
	}
	
	public int getIBO()
	{
		return ibo;
	}
	
	public Material getMaterial()
	{
		return material;
	}
}
