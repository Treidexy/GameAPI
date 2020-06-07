package me.Treidex.Game.GameObject.Components;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.maths.Vector2;

public class Transform extends Component {
	public static Transform empty = new Transform(Vector2.zero, Vector2.zero,0);
	
	public Vector2 position, size;
	public float rotation;
	
	public Transform(Vector2 position, Vector2 size, float rotation) {
		this.position = position;
		this.size = size;
		this.rotation = rotation;
	}
}
