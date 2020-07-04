package me.Treidex.GameAPI.Util;

public final class Time {
	
	/**
	 * Used to calculate Frame Rate.
	 */
	public static long lastTick = 0;
	
	/**
	 * Used to Calculate Fixed Updates.
	 */
	public static long lastFixedTick = 0;
	
	public static float deltaTime = 0;
	public static float fixedDeltaTime = 0;
}