package me.Treidex.GameAPI.Util;

public interface Methods {
	// Math
	public static double rad_D(final double deg) {
		return Math.toRadians(deg);
	}
	
	public static double deg_D(final double rad) {
		return Math.toDegrees(rad);
	}
	
	
	public static float rad(final float deg) {
		return (float) Math.toRadians(deg);
	}
	
	public static float deg(final float rad) {
		return (float) Math.toDegrees(rad);
	}
	
	// Console
	public static void print(Object msg) {
		System.out.print(msg);
	}
	
	public static void printErr(Object msg) {
		System.err.print(msg);
	}
	
	public static void println(Object msg) {
		System.out.println(msg);
	}
	
	public static void printlnErr(Object msg) {
		System.err.println(msg);
	}
}
