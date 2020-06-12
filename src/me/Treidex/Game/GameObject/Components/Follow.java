package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;

import me.Treidex.Game.Math.Vector2;

/**
 * A Component that makes the Game
 * Focus on
 * a Game Object.
 * 
 * @author Treidex
 *
 */
public class Follow extends Component {
	
	/**
	 * The Position in which
	 * the Game should follow.
	 */
	private Vector2 pos;
	
	/**
	 * The Linear Interpolation of the Focus Change.
	 */
	private float lerp;
	
	/**
	 * The Width of the Canvas.
	 */
	private int width;
	
	/**
	 * The Height of the Canvas.
	 */
	private int height;
	
	/**
	 * Initialize the Follow Component.
	 * 
	 * @param lerp The Linear Interpolation of the Focus Change.
	 * @param width The Width of the Canvas.
	 * @param height The Height of the Canvas.
	 */
	public Follow(float lerp, int width, int height) {
		this.lerp = lerp;
		this.width = width;
		this.height = height;
		
		pos = Vector2.zero;
	}
	
	/**
	 * Translate the Canvas to
	 * the Focus Position.
	 */
	public void draw(Graphics g) {
		g.translate((int) -((pos.x + transform.size.x) - (width/2)), (int) -((pos.y + transform.size.y) - (height/2)));
	}
	
	/**
	 * Update the Fucos Position.
	 */
	public void lateUpdate() {
		pos = Vector2.lerp(pos, transform.position, lerp);
	}
}
