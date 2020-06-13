package me.Treidex.Game.Math;

import java.lang.reflect.Array;

import me.Treidex.Game.GameObject.GameObject;

/**
 * An Addition to java.lang.Math,
 * used for more Math functions.
 * 
 * @author Treidex
 *
 */
public final class Mathf {
	
	/**
	 * Constrains a value between two numbers.
	 * 
	 * @param value The Value you want to Constrain.
	 * @param min The Minimum the Value could be.
	 * @param max The Maximum the Value could be.
	 * @return The Constrained value.
	 */
	public static float constrain(float value, float min, float max) {
		float newValue = value;
		
		if (newValue < min)
			newValue = min;
		if (newValue > max)
			newValue = max;
		
		return newValue;
	}
	
	/**
	 * Linear Interpolation.
	 * 
	 * @param begin The Beginning Value.
	 * @param end The Ending Value.
	 * @param lerp How much Interpolation (0-1).
	 * @return The Interpolated value.
	 */
	public static float lerp(float begin, float end, float lerp) {
		return begin + lerp * (end - begin);
	}
	
	/**
	 * Add a Value to an Array.
	 * 
	 * @param <T> Array Type.
	 * @param arrayClass Array Class.
	 * @param array Array you want to Modify.
	 * @param object What you want to add to the Array.
	 * @return The Modified Array.
	 */
	public static <T> T[] addToArray(Class<T> arrayClass, T[] array, T object) {
		T[] parray = array.clone();
		
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(arrayClass, parray.length + 1);
		
		for (int i = 0; i < parray.length; i++) {
			out[i] = parray[i];
		}
		
		out[out.length - 1] = object;
		
		return out;
	}
	
	/**
	 * Remove a Value from an Array.
	 * 
	 * @param <T> Array Type.
	 * @param arrayClass Array Class.
	 * @param array Array you want to modify.
	 * @param index Index of Object you want to Remove.
	 * @return The Modified Array.
	 */
	public static <T> T[] removeFromArray(Class<T> arrayClass, T[] array, int index) {
		T[] parray = array.clone();
		
		@SuppressWarnings("unchecked")
		T[] out = (T[]) Array.newInstance(arrayClass, parray.length - 1);
		
		int change = 0;
		for (int i = 0; i < parray.length; i++) {
			if (i == index) {
				change = 1;
				continue;
			}
			
			out[i - change] = parray[i];
		}
		
		return out;
	}
	
	public static <T> Integer getIndexFromArray(T object, T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == object) {
				return i;
			}
		}
		
		return null;
	}
}