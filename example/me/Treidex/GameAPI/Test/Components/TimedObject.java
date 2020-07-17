package me.Treidex.GameAPI.Test.Components;

import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.Test.Main;
import me.Treidex.GameAPI.Util.Time;

public class TimedObject extends Component {
	public float dTime;
	
	private float time;
	
	public TimedObject(final float dTime) {
		this.dTime = dTime;
	}
	
	public void update() {
		time += Time.deltaTime;
		
		if (time >= dTime)
			Main.gameManager.scene.destroy(parent);
	}
}
