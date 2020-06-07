package me.Treidex.Game.maths;

import java.lang.reflect.Array;

public final class Mathf {
	public static float constrain(float value, float min, float max) {
		float newValue = value;
		
		if (newValue < min)
			newValue = min;
		if (newValue > max)
			newValue = max;
		
		return newValue;
	}
	
	public static double constrain(double value, double min, double max) {
		double newValue = value;
		
		if (newValue < min)
			newValue = min;
		if (newValue > max)
			newValue = max;
		
		return newValue;
	}
	
	public static float lerp(float a, float b, float lerp) {
		return a + lerp * (b - a);
	}
	
	public static <T> T[] addToArray(Class<T> arrayType, T[] array, T object) {
		T[] parray = array.clone();
		T[] out = (T[]) Array.newInstance(arrayType, parray.length + 1);
		for (int i = 0; i < parray.length; i++) {
			out[i] = parray[i];
		}
		out[out.length - 1] = object;
		
		return out;
	}
}