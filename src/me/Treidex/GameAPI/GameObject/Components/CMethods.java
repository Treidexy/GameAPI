package me.Treidex.GameAPI.GameObject.Components;

import me.Treidex.GameAPI.GameObject.GameObject;

public class CMethods {
	/**
	 * Store the Parent Game Object in which
	 * the Component is used inside.
	 */
	protected GameObject parent;
	
	protected CMethods() {}
	
	public final void destroy(GameObject go) {
		parent.scene.destroy(go);
	}
	
	public final void destroy(int i) {
		parent.scene.destroy(i);
	}
	
	public final void destroy() {
		parent.scene.destroy(parent);
	}
	
	// Math
	public static final double rad_D(final double deg) {
		return Math.toRadians(deg);
	}
	
	public static final double deg_D(final double rad) {
		return Math.toDegrees(rad);
	}
	
	
	public static final float rad(final float deg) {
		return (float) Math.toRadians(deg);
	}
	
	public static final float deg(final float rad) {
		return (float) Math.toDegrees(rad);
	}
	
	// Console
	public static final void print(Object msg) {
		System.out.print(msg);
	}
	
	public static final void printErr(Object msg) {
		System.err.print(msg);
	}
	
	public static final void println(Object msg) {
		System.out.println(msg);
	}
	
	public static final void printlnErr(Object msg) {
		System.err.println(msg);
	}
}
