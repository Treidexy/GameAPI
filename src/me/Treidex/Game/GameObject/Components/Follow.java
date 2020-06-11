package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;

import me.Treidex.Game.Math.Vector2;

public class Follow extends Component {
	private Vector2 pos;
	
	private float lerp;
	
	private int width;
	private int height;
	
	public Follow(float lerp, int width, int height) {
		this.lerp = lerp;
		this.width = width;
		this.height = height;
		
		pos = Vector2.zero;
	}
	
	public void draw(Graphics g) {
		g.translate((int) -((pos.x + transform.size.x) - (width/2)), (int) -((pos.y + transform.size.y) - (height/2)));
	}
	
	public void lateUpdate() {
		pos = Vector2.lerp(pos, transform.position, lerp);
	}
}
