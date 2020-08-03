package me.Treidex.GameAPI.engine.graphics;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Material
{
	private Texture texture;
	private float width, height;
	private int textureID;
	
	private String texturePath;
	
	public Material(String texturePath)
	{
		this.texturePath = texturePath;
	}
	
	public void create()
	{
		try {
			texture = TextureLoader.getTexture(texturePath.split("[.]")[1], Material.class.getResourceAsStream(texturePath), GL11.GL_NEAREST);
			width = texture.getWidth();
			height = texture.getHeight();
			textureID = texture.getTextureID();
		} catch (IOException e) {
			System.err.println("Can't find texture at " + texturePath + ": " + e.toString());
		}
	}
	
	public void destroy()
	{
		GL13.glDeleteTextures(textureID);
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public int getTextureID() {
		return textureID;
	}
}
