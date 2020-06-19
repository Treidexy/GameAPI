package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import me.Treidex.Game.GameObject.GameObject;

/**
 * Component Used to Render Custom Sprites.
 * 
 * @author Treidex
 *
 */
public class SpriteRenderer extends Component {
	
	/**
	 * The Path to the Image File.
	 */
	public String filepath;
	
	/**
	 * The Raw Image for the Sprite.
	 */
	private Image spriteRaw;
	
	/**
	 * The Resized Image for the Sprite.
	 */
	private Image sprite;
	
	/**
	 * Initialize the Sprite Renderer.
	 * 
	 * @param filepath The Path to the Image File.
	 */
	public SpriteRenderer(String filepath) {
		this.filepath = filepath;
		
		spriteRaw = Toolkit.getDefaultToolkit().getImage(getClass().getResource(filepath));
		sprite = spriteRaw;
	}
	
	/**
	 * Override The setParent Function.
	 * Also scale Image.
	 */
	public void setParent(GameObject parent) {
		super.setParent(parent);
		
		sprite = spriteRaw.getScaledInstance((int) transform.size.x, (int) transform.size.y, Image.SCALE_DEFAULT);
	}
	
	/**
	 * Draw the Sprite.
	 */
	public void draw(Graphics g) {
		g.drawImage(sprite, (int) transform.position().x, (int) transform.position().y, null);
	}
}
