package me.Treidex.GameAPI.Util;

/**
 * 
 * Static Class for Time Utilities.
 * 
 * @author Treidex
 *
 */
public final class Time {
	
	/**
	 * This makes Time un-Instansiable.
	 */
	private Time() {}
	
	/**
	 * Used to calculate Frame Rate.
	 */
	public static long lastTick = 0;
	
	/**
	 * Used to Calculate Fixed Updates.
	 */
	public static long lastFixedTick = 0;
	
	/**
	 * Time In between frames.
	 */
	public static float deltaTime = 0;
	
	/**
	 * Fixed time in between Fixed Updates.
	 */
	public static float fixedDeltaTime = 0;
}