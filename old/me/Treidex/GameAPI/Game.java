package me.Treidex.GameAPI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import me.Treidex.GameAPI.Anotations.Unused;
import me.Treidex.GameAPI.Util.Time;

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
	private static final long serialVersionUID = -5950206307232302066L;
	
	/**
	 * The Fixed Ticks Per Second.
	 */
	public final int FIXED_TPS;
	
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
	 * Instance of the Mouse Input.
	 */
	private MouseInput mouseInput;
	
	/**
	 * An instance of the Key Input.
	 */
	private KeyInput keyInput;
	
	/**
	 * Screen Dimensions.
	 */
	public Dimension screen;
	
	/**
	 * Paints the canvas;
	 * everything is drawn.
	 */
	public final void paint(Graphics g) {
		gameManager.scene.draw(g);
	}
	
	/**
	 * Creates and Initializes
	 * the Game.
	 * 
	 * @param gameManager The Game Manager.
	 * @param screen The Screen Dimensions.
	 * @param fixedTPS The Fixed Ticks Per Second.
	 */
	public Game(GameManager gameManager, Dimension screen, int fixedTPS) {
		this.gameManager = gameManager;
		this.screen = screen;
		
		FIXED_TPS = fixedTPS;
		FIXED_MILLIS = 1000 / FIXED_TPS;
		end = false;
		
		Time.fixedDeltaTime = (float) FIXED_MILLIS / 1000;
		
		mouseInput = new MouseInput();
		keyInput = new KeyInput();
		
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		addKeyListener(keyInput);
		
		setFocusable(true);
		this.setSize(screen.width, screen.height);
	}
	
	/**
	 * Initializes based
	 * off of Game Manager.
	 */
	public final void init() {
		gameManager.setRunner(this);
		
		gameManager.scene.init();
	}
	
	/**
	 * Updates everything.
	 * The main Game Loop.
	 */
	public final void update() {
		gameManager.scene.update();
		
		if (System.currentTimeMillis() > Time.lastFixedTick + FIXED_MILLIS) {
			fixedUpdate();
			Time.lastFixedTick = System.currentTimeMillis();
		}
		
		lateUpdate();
		
		repaint();
	}
	
	/**
	 * Updates a Fixed time
	 * per second.
	 */
	private final void fixedUpdate() {
		gameManager.scene.fixedUpdate();
	}
	
	/**
	 * Updates at the end
	 * of each frame.
	 */
	private final void lateUpdate() {
		gameManager.scene.lateUpdate();
	}
	
	/**
	 * 
	 * All Mouse Input Related stuff.
	 * 
	 * @author Treidex
	 *
	 */
	private class MouseInput implements MouseListener, MouseMotionListener {

		/**
		 * Called whenever a Mouse Clicks.
		 */
		public void mouseClicked(MouseEvent e) {
			gameManager.scene.mouseClicked(e);
		}

		/**
		 * Called whenever a Mouse Presses.
		 */
		public void mousePressed(MouseEvent e) {
			gameManager.scene.mousePressed(e);
		}

		/**
		 * Called whenever a Mouse Releases.
		 */
		public void mouseReleased(MouseEvent e) {
			gameManager.scene.mouseReleased(e);
		}

		@Deprecated@Unused@Override public void mouseEntered(MouseEvent e) {}
		@Deprecated@Unused@Override public void mouseExited(MouseEvent e) {}

		/**
		 * Called whenever a Mouse Drags.
		 */
		public void mouseDragged(MouseEvent e) {
			gameManager.scene.mouseDragged(e);
		}

		/**
		 * Called Whenever a Mouse Moves.
		 */
		public void mouseMoved(MouseEvent e) {
			gameManager.scene.mouseMoved(e);
		}
		
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
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				end = true;
			
			gameManager.scene.keyPressed(e);
		}

		/**
		 * Called whenever key is Released.
		 */
		public void keyReleased(KeyEvent e) {
			gameManager.scene.keyReleased(e);
		}

		@Deprecated@Unused@Override public void keyTyped(KeyEvent e) {}
	}
}
