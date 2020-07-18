package me.Treidex.GameAPI.Util.Math;

import org.json.simple.JSONObject;

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
	
	protected JSONObject vector2M;
	
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
	 * 
	 * @return The two Vectors Added.
	 */
	public static Vector2 add(final Vector2 vector1, final Vector2 vector2) {
		return new Vector2(vector1.x + vector2.x, vector1.y + vector2.y);
	}
	
	/**
	 * Method for Subtracting two Vectors.
	 * 
	 * @param vector1 The Vector you want to Subtract.
	 * @param vector2 The Vector used to Subtract.
	 * 
	 * @return The Subtracted Vector.
	 */
	public static Vector2 sub(final Vector2 vector1, final Vector2 vector2) {
		return new Vector2(vector1.x - vector2.x, vector1.y - vector2.y);
	}
	
	/**
	 * Method Used for Vector Multiplication.
	 * 
	 * @param vector The Vector you want to Multiply.
	 * @param multiplier The Amount you want to Multiply the Vector by.
	 * 
	 * @return The Multiplied Vector.
	 */
	public static Vector2 mult(final Vector2 vector, final float multiplier) {
		return new Vector2(vector.x * multiplier, vector.y * multiplier);
	}
	
	/**
	 * Method Used for Vector Division.
	 * 
	 * @param vector The Vector you want to Divide.
	 * @param divider The Amount you want to Divide the Vector by.
	 * 
	 * @return The Divided Vector.
	 */
	public static Vector2 div(final Vector2 vector, final float divider) {
		return new Vector2(vector.x / divider, vector.y / divider);
	}
	
	/**
	 * Method Used for getting the Negative Vector.
	 * 
	 * @param vector The Vector.
	 * 
	 * @return The Negative Vector.
	 */
	public static Vector2 neg(final Vector2 vector) {
		return Vector2.sub(zero, vector);
	}
	
	/**
	 * Method Used for getting an Absolute Vector.
	 * 
	 * @param vector The Vector.
	 * 
	 * @return The Absolute Vector.
	 */
	public static Vector2 abs(final Vector2 vector) {
		return new Vector2(Math.abs(vector.x), Math.abs(vector.y));
	}
	
	public static boolean both_greaterThan(final Vector2 vector1, final Vector2 vector2) {
		return (vector1.x > vector2.x && vector1.y > vector2.y);
	}
	
	public static boolean both_greaterThanOREqualTo(final Vector2 vector1, final Vector2 vector2) {
		return (vector1.x >= vector2.x && vector1.y >= vector2.y);
	}
	
	public static boolean both_lessThan(final Vector2 vector1, final Vector2 vector2) {
		return (vector1.x < vector2.x && vector1.y < vector2.y);
	}
	
	public static boolean both_lessThanOREqualTo(final Vector2 vector1, final Vector2 vector2) {
		return (vector1.x <= vector2.x && vector1.y <= vector2.y);
	}
	
	public static boolean equals(final Vector2 vector1, final Vector2 vector2) {
		return (vector1.x == vector2.x && vector1.y == vector2.y);
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
	 * @see me.Treidex.GameAPI.Util.Math.Mathf#lerp(float, float, float) Linear Interpolation (Lerping).
	 */
	public static Vector2 lerp(final Vector2 startPos, final Vector2 endPos, final float lerp) {
		return Vector2.add(endPos, Vector2.mult(Vector2.sub(endPos, startPos), lerp));
	}
	
	/**
	 * Method Used for Nomalizing a Vector.
	 * 
	 * @param vector The Vector.
	 * 
	 * @return The Normalized Vector.
	 */
	public static Vector2 normalized(final Vector2 vector) {
		float magnitude = vector.magnitude();
		
		return new Vector2(vector.x / magnitude, vector.y / magnitude);
	}
	
	/**
	 * Method for Creating a Vector from an Angle
	 * 
	 * @param ang The angle (In Radians).
	 * 
	 * @return The Directional Vector.
	 */
	public static Vector2 fromAngle(final float ang) {
		return new Vector2((float) Math.sin(ang), (float) Math.cos(ang));
	}
	
	/**
	 * Method for Adding to a Vector.
	 * 
	 * @param vector The other Vector you want to Add.
	 * 
	 * @return The Added Vector.
	 */
	public Vector2 add(final Vector2 vector) {
		x += vector.x;
		y += vector.y;
		
		return this;
	}
	
	/**
	 * Method for Subtracting from a Vector.
	 * 
	 * @param vector2 The Vector used to Subtract.
	 * 
	 * @return The Subtracted Vector.
	 */
	public Vector2 sub(final Vector2 vector) {
		x -= vector.x;
		y -= vector.y;
		
		return this;
	}
	
	/**
	 * Method Used for Vector Multiplication.
	 * 
	 * @param multiplier The Amount you want to Multiply the Vector by.
	 * 
	 * @return The Multiplied Vector.
	 */
	public Vector2 mult(final float multiplier) {
		x *= multiplier;
		y *= multiplier;
		
		return this;
	}
	
	/**
	 * Method Used for Vector Division.
	 * 
	 * @param divider The Amount you want to Divide the Vector by.
	 * 
	 * @return The Divided Vector.
	 */
	public Vector2 div(final float divider) {
		x /= divider;
		y /= divider;
		
		return this;
	}
	
	/**
	 * Method Used for the Negative Vector.
	 * 
	 * @return The Negative Vector.
	 */
	public Vector2 neg() {
		x *= -1;
		y *= -1;
		
		return this;
	}
	
	/**
	 * Method Used for the Absolute Vector.
	 * 
	 * @param vector The Vector.
	 * 
	 * @return The Absolute Vector.
	 */
	public Vector2 abs() {
		return this;
	}
	
	public boolean both_greaterThan(final Vector2 vector) {
		return (x > vector.x && y > vector.y);
	}
	
	public boolean both_greaterThanOREqualTo(final Vector2 vector) {
		return (x >= vector.x && y >= vector.y);
	}
	
	public boolean both_lessThan(final Vector2 vector) {
		return (x < vector.x && y < vector.y);
	}
	
	public boolean both_lessThanOREqualTo(final Vector2 vector) {
		return (x <= vector.x && y <= vector.y);
	}
	
	/**
	 * See if a this equals another Vector.
	 * 
	 * @param vector The other Vector.
	 * 
	 * @return Whether the two Vectors are equal.
	 */
	public boolean equals(final Vector2 vector) {
		return (x == vector.x && y == vector.y);
	}
	
	/**
	 * Method Used for Linear Interpolation
	 * for two Vectors.
	 * 
	 * @param startPos The Start Position.
	 * @param endPos The End Position.
	 * @param lerp The Amount you want to Lerp.
	 * 
	 * @return The Lerped Vector.
	 * 
	 * @see me.Treidex.GameAPI.Util.Math.Mathf#lerp(float, float, float) Linear Interpolation (Lerping).
	 */
	public Vector2 lerp(final Vector2 endPos, final float lerp) {
		x = Mathf.lerp(x, endPos.x, lerp);
		y = Mathf.lerp(y, endPos.y, lerp);
		
		return this;
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
		if (magnitude() >= limit)
			return;
		
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
	
	/**
	 * Method Used for Nomalizing a Vector.
	 * 
	 * @return The Normalized Vector.
	 */
	public Vector2 normalize() {
		float magnitude = magnitude();
		
		x /= magnitude;
		y /= magnitude;
		
		return this;
	}
	
	/**
	 * Change The Magnitude of the Vector.
	 * 
	 * @param newMagnitude The Magnitude to change it to.
	 */
	public void magnitude(float newMagnitude) {
		normalize();
		
		x *= newMagnitude;
		y *= newMagnitude;
	}

	/**
	 * Method to Copy a Vector.
	 * 
	 * @return A new Instance of the Vector.
	 */
	public Vector2 copy() {
		return new Vector2(x, y);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		vector2M = new JSONObject();
		vector2M.put("x", x);
		vector2M.put("y", y);
		
		return vector2M;
	}
	
	public static Vector2 loadMap(JSONObject map) {
		return new Vector2((Float) map.get("x"), (Float) map.get("y"));
	}
	
	/**
	 * Return a String of The Vector.
	 */
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}
}
