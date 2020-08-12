package me.Treidex.GameAPI.Test.Components;

import java.awt.event.KeyEvent;

import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.GameObject.Components.Component;
import me.Treidex.GameAPI.Test.Main;
import me.Treidex.GameAPI.Util.Math.Vector2;

public class JumpPadSpawner extends Component {
	private boolean spawn;
	
	public void keyPressed(KeyEvent e) {
		if (!spawn && e.getKeyCode() == KeyEvent.VK_SPACE) {
			spawn = true;
			
			GameObject temp_jumpPad = Main.gameManager.scene.instansiate(Main.prefab_JumpPad);
			temp_jumpPad.transform.position(Vector2.add(transform.position(), new Vector2(0, transform.size.y)));
		}
	}
	
	public void keyReleased(KeyEvent e) {
		spawn = false;
	}
}
