package me.Treidex.GameAPI.GameObject.Components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.GameObject.GameObject;

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
	
	protected JSONObject spMap;
	
	/**
	 * Initialize the Sprite Renderer.
	 * 
	 * @param filepath The Path to the Image File.
	 */
	public SpriteRenderer(String fp) {
		initID("Sprite Renderer");
		
		String filepath = "/" + fp;
		
		this.filepath = filepath;
		try {
			spriteRaw = Toolkit.getDefaultToolkit().getImage(getClass().getResource(filepath));
			sprite = spriteRaw;
		} catch (NullPointerException e) {
			throw new NullPointerException("Could not render image: '" + filepath + "'!");
		}
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

	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		spMap = new JSONObject();
		spMap.put("file-path", filepath);
		
		return spMap;
	}
	
	public static Component loadMap(final JSONObject map) {
		return new SpriteRenderer((String) map.get("file-path"));
	}
}
