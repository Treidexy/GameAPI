package me.Treidex.Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * The universal game;
 * basically the motherboard
 * of the entire Game.
 * Connects Game Window to
 * Game Manager.
 * 
 * @author Treidex
 * 
 */
public class Game extends JPanel {
	
	/**
	 * If you know anything about JPanels,
	 * you know what this is.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Fixed Ticks Per Second.
	 */
	public final int FIXED_TPS = 60;
	
	/**
	 * Used to Calculate when to
	 * Call a Fixed Update.
	 */
	public final int FIXED_MILLIS;
	
	/**
	 * The Game Manager.
	 */
	public GameManager gameManager;
	
	/**
	 * Determines whether to end the program.
	 */
	public boolean end;
	
	/**
	 * An instance of the Key Input.
	 */
	private KeyInput keyInput;
	
	/**
	 * Used to Calculate Fixed Updates.
	 */
	private long time;
	
	/**
	 * Paints the canvas;
	 * everything is drawn.
	 */
	public final void paint(Graphics g) {
		gameManager.draw(g);
	}
	
	/**
	 * Creates and Initializes
	 * the Game.
	 * 
	 * @param gameManager The Game Manager.
	 */
	public Game(GameManager gameManager) {
		this.gameManager = gameManager;
		
		FIXED_MILLIS = 1000 / FIXED_TPS;
		end = false;
		
		keyInput = new KeyInput();
		addKeyListener(keyInput);
		setFocusable(true);
	}
	
	/**
	 * Initializes based
	 * off of Game Manager.
	 */
	public final void init() {
		gameManager.setRunner(this);
		
		gameManager.init();
	}
	
	/**
	 * Updates everything.
	 * The main Game Loop.
	 */
	public final void update() {
		gameManager.update();
		
		if (System.currentTimeMillis() > time + FIXED_MILLIS) {
			fixedUpdate();
			time = System.currentTimeMillis();
		}
		
		lateUpdate();
		
		repaint();
	}
	
	/**
	 * Updates a Fixed time
	 * per second.
	 */
	private final void fixedUpdate() {
		gameManager.fixedUpdate();
	}
	
	/**
	 * Updates at the end
	 * of each frame.
	 */
	private final void lateUpdate() {
		gameManager.lateUpdate();
	}
	
	/**
	 * 
	 * @author Treidex
	 * 
	 * Reads Key Input.
	 */
	private class KeyInput implements KeyListener {
		
		/**
		 * Called whenever key is Pressed.
		 */
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 27)
				end = true;
			
			gameManager.keyPressed(e);
		}

		/**
		 * Called whenever key is Released.
		 */
		public void keyReleased(KeyEvent e) {
			gameManager.keyReleased(e);
		}

		/**
		 * Ignore;
		 * only used in forms.
		 */
		public void keyTyped(KeyEvent e) {}
		
	}
}
