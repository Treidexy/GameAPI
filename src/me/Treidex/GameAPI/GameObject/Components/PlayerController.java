package me.Treidex.GameAPI.GameObject.Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.json.simple.JSONObject;

import me.Treidex.GameAPI.Util.Time;
import me.Treidex.GameAPI.Util.Math.Vector2;

/**
 * Component for a Simple Player Controller.
 * 
 * @author Treidex
 *
 */
public class PlayerController extends Component {
	
	/**
	 * The Speed of the Player Controller.
	 */
	public float speed;
	
	/**
	 * The Jump Height of the Player Controller.
	 */
	public float jumpHeight;
	
	/**
	 * Whether to Render the Default Player Texture.
	 */
	protected boolean renderDefault;
	
	protected JSONObject pcMap;
	
	/**
	 * Store the User Inputs.
	 */
	protected HashMap<String, Boolean> inputs;
	
	/**
	 * The Physics Component of the Player Controller.
	 */
	protected Physics physics;
	
	/**
	 * Initialize the Player Controller.
	 * 
	 * @param speed The Speed of the Player Controller.
	 * @param jumpHeight The Jump Height of the Player Controller
	 * @param renderDefault Whether to Render the Default Player Texture.
	 */
	public PlayerController(float speed, float jumpHeight, boolean renderDefault) {
		initID("Player Controller");
		
		this.speed = speed;
		this.jumpHeight = jumpHeight;
		
		this.renderDefault = renderDefault;
	}
	
	/**
	 * Initialize Player Controller on Initiation Phase.
	 */
	public void init() {
		inputs = new HashMap<String, Boolean>();
		inputs.put("up", false);
		inputs.put("left", false);
		inputs.put("right", false);
		inputs.put("down", false);
		inputs.put("space", false);
		
		physics = parent.<Physics> getComponent(Physics.class);
	}
	
	/**
	 * Draw the Default Player Texture if {@link PlayerController#renderDefault Render Default} is True.
	 */
	public void draw(Graphics g) {
		if (renderDefault) {
			g.setColor(new Color(14, 69, 14));
			g.fillRect((int) transform.position().x, (int) transform.position().y, (int) transform.size.x, (int) transform.size.y);
		}
	}
	
	/**
	 * Update the Player Controller.
	 */
	public void fixedUpdate() {
		if (inputs.get("up")) {
			if (physics.onGround)
				physics.addForce(new Vector2(0, -jumpHeight));
		}
		if (inputs.get("left")) {
			move(new Vector2(-1, 0));
		}
		if (inputs.get("right")) {
			move(new Vector2(1, 0));
		}
		if (inputs.get("down")) {
			move(new Vector2(0, 1));
		}
	}
	
	/**
	 * Get Input.
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			inputs.replace("up", true);
			break;
		case 37:
			inputs.replace("left", true);
			break;
		case 39:
			inputs.replace("right", true);
			break;
		case 40:
			inputs.replace("down", true);
			break;
		case 32:
			inputs.replace("space", true);
			break;
		}
	}
	
	/**
	 * Get Input.
	 */
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 38:
			inputs.replace("up", false);
			break;
		case 37:
			inputs.replace("left", false);
			break;
		case 39:
			inputs.replace("right", false);
			break;
		case 40:
			inputs.replace("down", false);
			break;
		case 32:
			inputs.replace("space", false);
			break;
		}
	}
	
	/**
	 * Method to Move the Player.
	 * 
	 * @param accel The Map in which to Move the Player.
	 */
	public void move(Vector2 accel) {
		Vector2 acceleration = Vector2.mult(accel, speed);
		acceleration.mult(Time.fixedDeltaTime);
		
		physics.addForce(acceleration);
	}

	@SuppressWarnings("unchecked")
	public JSONObject getMap() {
		pcMap = new JSONObject();
		pcMap.put("speed", speed);
		pcMap.put("jump-height", jumpHeight);
		pcMap.put("render-default", renderDefault);
		
		return pcMap;
	}
	
	public static Component loadMap(final JSONObject map) {
		return new PlayerController((Float) map.get("speed"), (Float) map.get("jump-height"), (Boolean) map.get("render-default"));
	}
}
