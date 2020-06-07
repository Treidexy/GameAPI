package me.Treidex.Game.GameObject.Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import me.Treidex.Game.maths.Vector2;

public class Player extends Component {
	public float speed;
	public float jumpHeight;
	
	private HashMap<String, Boolean> inputs;
	
	private Physics physics;
	private boolean renderDefault;
	
	public Player(float speed, float jumpHeight, boolean renderDefault) {
		this.speed = speed;
		this.jumpHeight = jumpHeight;
		
		this.renderDefault = renderDefault;
	}
	
	public void init() {
		inputs = new HashMap<String, Boolean>();
		inputs.put("up", false);
		inputs.put("left", false);
		inputs.put("right", false);
		inputs.put("down", false);
		inputs.put("space", false);
		
		physics = parent.<Physics> getComponent(Physics.class);
	}
	
	public void draw(Graphics g) {
		if (renderDefault) {
			g.setColor(new Color(14, 69, 14));
			g.fillRect((int) transform.position.x, (int) transform.position.y, (int) transform.size.x, (int) transform.size.y);
		}
	}
	
	public void update() {
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
	
	private void move(Vector2 accel) {
		Vector2 acceleration = Vector2.mult(accel, speed);
		physics.addForce(acceleration);
	}
}
