package me.Treidex.GameAPI.Test.Components;

import java.awt.event.KeyEvent;

import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.Test.Main;
import me.Treidex.GameAPI.Util.FileManager;

public class SerializationFun extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7978892003342342335L;

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.player = FileManager.<GameObject> ReadFile("Player.jprf");
			FileManager.WriteToFile("Player.jprf", Main.player);
		}
	}
}
