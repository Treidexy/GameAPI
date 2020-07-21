package me.Treidex.GameAPI.GameObject.Components;

public class CMethods {
	protected CMethods() {}
	
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
}
