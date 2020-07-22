package me.Treidex.GameAPI.GameObject.Components;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import org.json.simple.JSONObject;

/**
 * Component Used to Render Custom Sprites.
 * 
 * @author Treidex
 *
 */
public class SpriteRenderer extends Component {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8916266846766341203L;

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
	 * @param fp The Path to the Image File.
	 */
	public SpriteRenderer(String fp) {
		initID("Sprite Renderer");
		
		String filepath = "/" + fp;
		
		this.filepath = filepath;
		try {
			spriteRaw = Toolkit.getDefaultToolkit().getImage(getClass().getResource(filepath));
			sprite = spriteRaw;
			
			if (spriteRaw == null)
				throw new NullPointerException("Could not render image: '" + filepath + "'!");
		} catch (NullPointerException e) {
			throw new NullPointerException("Could not render image: '" + filepath + "'!");
		}
	}
	
	public void init() {
		sprite = spriteRaw.getScaledInstance((int) transform.size.x, (int) transform.size.y, Image.SCALE_DEFAULT);
	}
	
	/**
	 * Draw the Sprite.
	 */
	public void draw(Graphics2D g) {
		AffineTransform at = new AffineTransform();
		
		at.translate(transform.position().x, transform.position().y);
		at.rotate(transform.rotation());
		g.drawImage(sprite, at, null);
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
