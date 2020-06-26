package me.Treidex.Game.Test.GameObjects.Components;

import org.json.simple.JSONObject;

import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.Util.Vector2;

public class ObsticleThingy extends Component {
	private Physics physics;
	
	private float speed;
	
	public ObsticleThingy(float speed) {
		this.speed = speed;
	}
	
	public void init() {
		physics = parent.<Physics> getComponent(Physics.class);
	}
	
	public void fixedUpdate() {
		physics.addForce(new Vector2(-speed, 0));
	}

	@Override
	public JSONObject getMap() {
		// TODO Auto-generated method stub
		return null;
	}
}
