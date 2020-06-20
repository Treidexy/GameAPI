package me.Treidex.Game.GameObject.Components.UI;

import me.Treidex.Game.GameObject.Components.Component;

public class UI extends Component {
	public boolean isStatic;
	
	public UI(boolean isStatic) {
		this.isStatic = isStatic;
	}
}
