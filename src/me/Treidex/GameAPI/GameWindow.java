package me.Treidex.GameAPI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * In order to actually have a Game,
 * you need to have a window.
 * 
 * @author Treidex
 *
*/
public class GameWindow extends JFrame {
	
	/**
	 * If you know anything about JFrames,
	 * you know what this is.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Determines whether the Application
	 * should close or not.
	 */
	public boolean shouldClose;
	
	/**
	 * The Game that controls the Canvas.
	 */
	private Game game;
	
	/**
	 * Used to calculate Frame Rate.
	 */
	private int frames;
	
	/**
	 * Used to calculate Frame Rate.
	 */
	private long time;
	
	private String windowName;
	
	
	/**
	 * Constructor -
	 * Initializes the Window
	 * 
	 * @param game The Game that controls the Canvas.
	 */
	public GameWindow(Game game, String windowName, int width, int height) {
		this.game = game;
		this.windowName = windowName;
		
		shouldClose = false;
		
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(windowName);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		        exit();
		    }
		});
		
		add(game);
	}
	
	/**
	 * Updates the window.
	 */
	public void update() {
		frames++;
		if (System.currentTimeMillis() > time + 1000) {
			setTitle(windowName + " | FPS: " + frames);
			time = System.currentTimeMillis();
			frames = 0;
		}
		
		if (game.end)
			exit();
	}
	
	
	/**
	 * This method is called
	 * when the user closes the Window.
	 */
	public void exit() {
		shouldClose = true;
		
		dispose();
	}
}
