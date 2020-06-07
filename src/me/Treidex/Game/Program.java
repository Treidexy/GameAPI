package me.Treidex.Game;

import me.Treidex.Game.Anotations.*;

@Remarks(
	Author= "Treidex",
	ProjectName= "Game API",
	Links= {
		"https://github.com/TeddyTelanoff",
		"https://www.youtube.com/channel/UCQBziAEpzflahxJk-Jkv4iA"
	},
	Description= 
		"API for Java Game Dev",
	Version= "a1.0"
)

public final class Program implements Runnable {
	private final int MAX_TPS;
	private final int WAIT_MILLIS;
	
	private Thread gameThread;
	private Game game;
	private GameManager gameManager;
	private GameWindow gameWindow;
	
	private long time;

	public Program(GameManager gameManager, int maxTPS) {
		this.gameManager = gameManager;
		
		MAX_TPS = maxTPS;
		WAIT_MILLIS = 1000 / MAX_TPS;
	}
	
	public void start() {
		gameThread = new Thread(this, "Game");
		gameThread.start();
	}
	
	public void init() {
		game = new Game(gameManager);
		gameWindow = new GameWindow(game);
		game.init();
	}
	
	public void run() {
		init();
		while (!gameWindow.shouldClose) {
			if (System.currentTimeMillis() > time + WAIT_MILLIS) {
				update();
				
				time = System.currentTimeMillis();
			}
		}
		System.exit(0);
	}
	
	private void update() {
		gameWindow.update();
		game.update();
	}
}
