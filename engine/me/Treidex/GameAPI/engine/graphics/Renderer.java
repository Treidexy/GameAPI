package me.Treidex.GameAPI.engine.graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class Renderer
{
	private Shader shader;
	
	public Renderer(Shader shader)
	{
		this.shader = shader;
	}
	
	public void drawShape(Shape shape)
	{
		GL30.glBindVertexArray(shape.getVAO());
		GL30.glEnableVertexAttribArray(0);
		GL30.glEnableVertexAttribArray(1);
		GL30.glEnableVertexAttribArray(2);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, shape.getIBO());
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		if (shape.getMaterial() != null)
			GL13.glBindTexture(GL11.GL_TEXTURE_2D, shape.getMaterial().getTextureID());
		shader.bind();
			GL11.glDrawElements(GL11.GL_TRIANGLES, shape.getIndices().length, GL11.GL_UNSIGNED_INT, 0);
		shader.unbind();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL30.glDisableVertexAttribArray(0);
		GL30.glDisableVertexAttribArray(1);
		GL30.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);
	}
}
