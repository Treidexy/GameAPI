package me.Treidex.Game.GameObject.Components.UI;

import java.awt.Graphics;

import me.Treidex.Game.GameObject.Components.Component;

public class UI extends Component {
	public boolean isStatic;
	
	public UI(boolean isStatic) {
		this.isStatic = isStatic;
	}
	
	protected void staticTransStart(Graphics g) {
		if (isStatic)
			g.translate((int) -parent.scene.translate.x, (int) -parent.scene.translate.y);
	}
	
	protected void staticTransEnd(Graphics g) {
		if (isStatic)
			g.translate((int) parent.scene.translate.x, (int) parent.scene.translate.y);
	}
}
