package me.Treidex.Game.Math;

import me.Treidex.Game.Anotations.Unfinished;

/**
 * A Class that stores a 2D Vector.
 * 
 * @author Treidex
 *
 */
public class Vector2 {
	
	/**
	 * A Preset Vector2
	 * state.
	 */
	public static final Vector2 zero = new Vector2(0, 0);
	
	/**
	 * The X of the Vector.
	 */
	public float x;
	
	/**
	 * The Y of the Vector.
	 */
	public float y;
	
	/**
	 * The magnitude of the Vector.
	 */
	public float magnitude;
	
	/**
	 * Initialize the Vector.
	 * 
	 * @param x The X of the Vector.
	 * @param y The Y of the Vector.
	 */
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method for Adding two Vectors.
	 * 
	 * @param vector1 A Vector you want to Add.
	 * @param vector2 Another Vector you want to Add.
	 * @return The two Vectors Added.
	 */
	public static Vector2 add(Vector2 vector1, Vector2 vector2) {
		return new Vector2(vector1.x + vector2.x, vector1.y + vector2.y);
	}
	
	/**
	 * Method for Subtracting two Vectors.
	 * 
	 * @param vector1 The Vector you want to Subtract.
	 * @param vector2 The Vector used to Subtract.
	 * @return The Subtracted Vector.
	 */
	public static Vector2 sub(Vector2 vector1, Vector2 vector2) {
		return new Vector2(vector1.x - vector2.x, vector1.y - vector2.y);
	}
	
	/**
	 * Method Used for Vector Multiplication.
	 * 
	 * @param vector The Vector you want to Multiply.
	 * @param multiplier The Amount you want to Multiply the Vector by.
	 * @return The Multiplied Vector.
	 */
	public static Vector2 mult(Vector2 vector, float multiplier) {
		return new Vector2(vector.x * multiplier, vector.y * multiplier);
	}
	
	/**
	 * Method Used for Vector Division.
	 * 
	 * @param vector The Vector you want to Divide.
	 * @param divider The Amount you want to Divide the Vector by.
	 * @return The Divided Vector.
	 */
	public static Vector2 div(Vector2 vector, float divider) {
		return new Vector2(vector.x / divider, vector.y / divider);
	}
	
	public static Vector2 neg(Vector2 vector) {
		return Vector2.sub(zero, vector);
	}
	
	public static Vector2 abs(Vector2 vector) {
		return new Vector2(Math.abs(vector.x), Math.abs(vector.y));
	}
	
	/**
	 * Method Used for Linear Interpolation
	 * for two Vectors.
	 * 
	 * @param startPos The Start Position.
	 * @param endPos The End Position.
	 * @param lerp The Amount you want to Lerp.
	 * @return The Lerped Vector.
	 * 
	 * @see me.Treidex.Game.Math.Mathf#lerp(float, float, float) Linear Interpolation (Lerping).
	 */
	public static Vector2 lerp(Vector2 startPos, Vector2 endPos, float lerp) {
		return Vector2.add(endPos, Vector2.mult(Vector2.sub(endPos, startPos), lerp));
	}
	
	public static Vector2 normalized(Vector2 vector) {
		float magnitude = vector.magnitude();
		
		return new Vector2(vector.x / magnitude, vector.y / magnitude);
	}
	
	/**
	 * Method to Limit the X and Y
	 * of the Vector.
	 * 
	 * @param limit The Maximum Value the location can be.
	 */
	public void limit(float limit) {
		if (x > limit)
			x = limit;
		if (x < -limit)
			x = -limit;
		
		if (y > limit)
			y = limit;
		if (y < -limit)
			y = -limit;
	}
	
	/**
	 * Limit The Magnitude of the Vector.
	 * 
	 * @param limit The Limit.
	 */
	public void limitMag(float limit) {
		normalize();
		
		x *= limit;
		y *= limit;
	}
	
	/**
	 * Get the Magnitude of a Vector
	 * 
	 * @return The Magnitude of the Vector.
	 */
	public float magnitude() {
		float mag = 0;
		
		double xSqr = Math.pow(x, 2);
		double ySqr =  Math.pow(y, 2);
		double magSqr = xSqr + ySqr;
		
		mag = (float) Math.sqrt(magSqr);
		
		return mag;
	}
	
	public void normalize() {
		float magnitude = magnitude();
		
		x /= magnitude;
		y /= magnitude;
	}
	
	/**
	 * (UN-FINISHED)
	 * Change The Magnitude of the Vector.
	 * 
	 * @param newMagnitude The Magnitude to change it to.
	 */
	public void magnitude(float newMagnitude) {
		// TODO Make It Work!!!
	}

	/**
	 * Method to Copy a Vector.
	 * 
	 * @return A new Instance of the Vector.
	 */
	public Vector2 copy() {
		return new Vector2(x, y);
	}
	
	/**
	 * Return a String of The Vector.
	 */
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}
}
