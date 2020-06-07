package me.Treidex.Game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	public boolean shouldClose;
	
	private Game game;
	private double scale = 100;
	private int frames;
	private long time;
	
	public GameWindow(Game game) {
		this.game = game;
		shouldClose = false;
		
		setSize((int) (16*scale), (int) (9*scale));
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Physics - by Treidex");
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
	
	public void update() {
		frames++;
		if (System.currentTimeMillis() > time + 1000) {
			setTitle("Physics - by Treidex" + " | FPS: " + frames);
			time = System.currentTimeMillis();
			frames = 0;
		}
		
		if (game.end)
			exit();
	}
	
	public void exit() {
		shouldClose = true;
		
		dispose();
	}
}
