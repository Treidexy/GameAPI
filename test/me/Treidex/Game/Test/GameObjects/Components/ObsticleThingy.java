package me.Treidex.Game.Test.GameObjects.Components;

import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.Math.Vector2;

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
}
