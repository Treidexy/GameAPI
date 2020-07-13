package me.Treidex.GameAPI.Util.Math;

import java.lang.reflect.Array;

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
	public static float constrain(final float value, final float min, final float max) {
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
	public static float lerp(final float begin, final float end, final float lerp) {
		return begin + lerp * (end - begin);
	}
	
	public static String[] arrayToString(final Object[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i].toString();
		}
		
		return (String[]) array;
	}
	
	@SuppressWarnings("unchecked")
	public static <In, Out> Out[] convertArray(final In[] in) {
		Out[] out = (Out[]) in.clone();
		
		return out;
	}
	
	public static <T> boolean hasInArray(final T[] array, final T object) {
		for (T obj: array) {
			if (obj.equals(object))
				return true;
		}
		
		return false;
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
	public static <T> T[] addToArray(final Class<T> arrayClass, final T[] array, final T object) {
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
	public static <T> T[] removeFromArray(final Class<T> arrayClass, final T[] array, final int index) {
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
	
	public static <T> Integer getIndexFromArray(final T object, final T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == object) {
				return i;
			}
		}
		
		throw new NullPointerException("Cannot Find Object in Array!");
	}
}