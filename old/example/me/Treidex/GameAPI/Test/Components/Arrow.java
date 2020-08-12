package me.Treidex.GameAPI.Test.Components;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Toolkit;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.GameObject.Components.Physics;
import me.Treidex.GameAPI.Util.Math.Vector2;

public class Arrow extends Component {
	private Physics physics;
	
	private float width;
	private float height;
	
	public Arrow() {
		this.width = (float) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.height = (float) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	
	public void init() {
		physics = getComponent(Physics.class);
	}
	
	public void fixedUpdate() {
		PointerInfo e = MouseInfo.getPointerInfo();
		
		Vector2 mouse = new Vector2((float) e.getLocation().getX(), (float) e.getLocation().getY());
		Vector2 newGrav = Vector2.sub(mouse, new Vector2(width/2, height/2));
		newGrav.limitMag(1.69f);
		
		physics.gravity = newGrav;
	}
}
