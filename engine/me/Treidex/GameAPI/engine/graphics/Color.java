package me.Treidex.GameAPI.engine.graphics;

public class Color
{
	private Color()
	{}
	
	public static int g(double g)
	{
		return rgb(g, g, g);
	}
	
	public static int ga(double g, double a)
	{
		return rgba(g, g, g, a);
	}
	
	public static int rgb(double r, double g, double b)
	{
		return rgba(r, g, b, 255);
	}
	
	public static int rgba(double r, double g, double b, double a)
	{
		if (r > 255) r = 255; else if (r < 0) r = 0;
		if (g > 255) g = 255; else if (g < 0) g = 0;
		if (b > 255) b = 255; else if (b < 0) b = 0;
		if (a > 255) a = 255; else if (a < 0) a = 0;

		return ((int) a << 24) | ((int) r << 16) | ((int) g << 8) | (int) b;
	}
	
	public static float getRed(int color)
	{
		return (color >> 16) & 0xFF;
	}
	
	public static float getGreen(int color)
	{
		return (color >> 8) & 0xFF;
	}
	
	public static float getBlue(int color)
	{
		return (color & 0xFF);
	}
	
	public static float getAlpha(int color)
	{
		return (color >> 24) & 0xFF;
	}
}
