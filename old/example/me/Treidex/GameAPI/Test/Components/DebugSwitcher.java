package me.Treidex.GameAPI.Test.Components;

import java.awt.event.KeyEvent;

import me.Treidex.GameAPI.Debug;
import me.Treidex.GameAPI.GameObject.Components.Component;

public class DebugSwitcher extends Component {
	private boolean ctrl;
	private boolean t;
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_CONTROL)
			ctrl = true;
		
		if (e.getKeyCode() == KeyEvent.VK_D && ctrl && !t) {
			if (Debug.statements.contains("debug"))
				Debug.statements.remove("debug");
			else
				Debug.statements.add("debug");
			
			t = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D)
			t = false;
		
		if (e.getKeyCode() == KeyEvent.VK_CONTROL)
			ctrl = false;
	}
}
