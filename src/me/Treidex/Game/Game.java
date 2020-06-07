package me.Treidex.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public final int FIXED_TPS = 60;
	public final int FIXED_MILLIS;
	
	public GameManager gameManager;
	public boolean end;
	
	private KeyInput keyInput;
	
	private long time;
	
	public final void paint(Graphics g) {
//		g.setColor(new Color(255, 255, 255));
//		g.fillRect(0, 0, getWidth(), getHeight());
		
		gameManager.draw(g);
	}
	
	public Game(GameManager gameManager) {
		this.gameManager = gameManager;
		
		FIXED_MILLIS = 1000 / FIXED_TPS;
		end = false;
		
		keyInput = new KeyInput();
		addKeyListener(keyInput);
		setFocusable(true);
	}
	
	public final void init() {
		gameManager.setRunner(this);
		
		gameManager.init();
	}
	
	public final void update() {
		gameManager.update();
		
		if (System.currentTimeMillis() > time + FIXED_MILLIS) {
			fixedUpdate();
			time = System.currentTimeMillis();
		}
		
		repaint();
		
		lateUpdate();
	}
	
	private final void fixedUpdate() {
		gameManager.fixedUpdate();
	}
	
	private final void lateUpdate() {
		gameManager.lateUpdate();
	}
	
	private class KeyInput implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}
}
