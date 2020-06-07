package me.Treidex.Game.maths;

public class Vector2 {
	public static final Vector2 zero = new Vector2(0, 0);
	
	public float x, y, magnitude;
	
	public Vector2() {
		x = 0;
		y = 0;
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector2 add(Vector2 vector1, Vector2 vector2) {
		return new Vector2(vector1.x + vector2.x, vector1.y + vector2.y);
	}
	
	public static Vector2 sub(Vector2 vector1, Vector2 vector2) {
		return new Vector2(vector1.x - vector2.x, vector1.y - vector2.y);
	}
	
	public static Vector2 mult(Vector2 vector, float multiplier) {
		return new Vector2(vector.x * multiplier, vector.y * multiplier);
	}
	
	public static Vector2 div(Vector2 vector, float divider) {
		return new Vector2(vector.x / divider, vector.y / divider);
	}
	
	public static Vector2 lerp(Vector2 pos1, Vector2 pos2, float lerp) {
		return Vector2.add(pos1, Vector2.mult(Vector2.sub(pos2, pos1), lerp));
	}
	
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
	
	public void limitMag(float limit) {
		
	}
	
	public float magnitude() {
		float mag = 0;
		
		double xSqr = Math.pow(x, 2);
		double ySqr =  Math.pow(y, 2);
		double magSqr = xSqr + ySqr;
		
		mag = (float) Math.sqrt(magSqr);
		
		return mag;
	}
	
	public void magnitude(float newMagnitude) {
		
	}

	public Vector2 copy() {
		return new Vector2(x, y);
	}
	
	@Override
	public String toString() {
		return "[ " + x + ", " + y + " ]";
	}
}
