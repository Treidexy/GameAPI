package com.treidex.gameapi.engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import com.treidex.gameapi.engine.graphics.Color;
import com.treidex.gameapi.engine.math.Matrix4f;

public class Window
{
	public String title;
	public int    width, height;

	private long                   window;
	private int                    frames;
	private static long            time;
	private Input                  input;
	private int                    background;
	private int[]                  windowPosX = new int[1], windowPosY = new int[1];
	private GLFWWindowSizeCallback sizeCallback;
	private boolean                isResized;
	private boolean                isFullscreen;
	private Matrix4f               projection;

	public Window(String title, int width, int height)
	{
		this.title  = title;
		this.width  = width;
		this.height = height;

		projection = Matrix4f.projection(90.0f, (float) width / (float) height, 0.1f, 100.0f);
	}

	public void create()
	{
		if (!GLFW.glfwInit())
		{
			System.err.println("[!]: GLFW wasn't initialized!");
			return;
		}

		input  = new Input();
		window = GLFW.glfwCreateWindow(width, height, title, isFullscreen ? GLFW.glfwGetPrimaryMonitor() : 0, 0);

		if (window == 0)
		{
			System.err.println("[!]: Window wasn't created!");
			return;
		}

		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		windowPosX[0] = (videoMode.width() - width) / 2;
		windowPosY[0] = (videoMode.height() - height) / 2;
		GLFW.glfwSetWindowPos(window, windowPosX[0], windowPosY[0]);
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();

		createCallbacks();

		GLFW.glfwShowWindow(window);

		GLFW.glfwSwapInterval(1);

		time = System.currentTimeMillis();
	}

	public void update()
	{
		if (isResized)
		{
			GL11.glViewport(0, 0, width, height);
			isResized = false;
		}
		GL11.glClearColor((float) Color.getRed(background) / 255, (float) Color.getGreen(background) / 255,
				(float) Color.getBlue(background) / 255, 1f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GLFW.glfwPollEvents();

		frames++;
		if (System.currentTimeMillis() > time + 1000)
		{
			GLFW.glfwSetWindowTitle(window, title + " | FPS: " + frames);
			time   = System.currentTimeMillis();
			frames = 0;
		}
	}

	public void swapBuffers()
	{
		GLFW.glfwSwapBuffers(window);
	}

	public boolean shouldClose()
	{
		return GLFW.glfwWindowShouldClose(window);
	}

	public void destroy()
	{
		input.destroy();
		sizeCallback.free();
		GLFW.glfwWindowShouldClose(window);
		GLFW.glfwDestroyWindow(window);
		GLFW.glfwTerminate();
	}

	public void setBackground(int color)
	{ background = color; }

	public boolean isFullscreen()
	{ return isFullscreen; }

	public void setFullscreen(boolean isFullscreen)
	{
		this.isFullscreen = isFullscreen;
		isResized         = true;
		if (isFullscreen)
		{
			GLFW.glfwGetWindowPos(window, windowPosX, windowPosY);
			GLFW.glfwSetWindowMonitor(window, GLFW.glfwGetPrimaryMonitor(), 0, 0, width, height, 0);
		}
		else
		{
			GLFW.glfwSetWindowMonitor(window, windowPosX[0], windowPosY[0], 0, width, height, 0);
		}
	}

	public String getTitle()
	{ return title; }

	public int getWidth()
	{ return width; }

	public int getHeight()
	{ return height; }

	public long getWindow()
	{ return window; }

	public int getFrames()
	{ return frames; }

	public Matrix4f getProjectionMatrix()
	{ return projection; }

	private void createCallbacks()
	{
		sizeCallback = new GLFWWindowSizeCallback()
		{
			public void invoke(long window, int w, int h)
			{
				width     = w;
				height    = h;
				isResized = true;
			}
		};

		GLFW.glfwSetKeyCallback(window, input.getKeyboardCallback());
		GLFW.glfwSetCursorPosCallback(window, input.getMouseMoveCallback());
		GLFW.glfwSetMouseButtonCallback(window, input.getMouseButtonsCallback());
		GLFW.glfwSetScrollCallback(window, input.getScrollCallback());
		GLFW.glfwSetWindowSizeCallback(window, sizeCallback);
	}
}
