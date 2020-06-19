package me.Treidex.Game;

import me.Treidex.Game.Anotations.*;
import me.Treidex.Game.Math.Time;

/**
 * This the Main Program as of itself,
 * it is used whenever
 * you want to make a new Game.
 * 
 * @author Treidex
 * 
 */
@ProjectInfo(
	Name= "Game API",
	Authors= { "Treidex" },
	Version= "a1.1",
	Description= "Amazing Unity-Based API for Java Game Deveplopment",
	Page= "https://github.com/TeddyTelanoff/GameAPI"
)

@Credit(
	Author= "Treidex",
	ProjectName= "Game API",
	Links= {
		"https://github.com/TeddyTelanoff",
		"https://www.youtube.com/channel/UCQBziAEpzflahxJk-Jkv4iA"
	},
	Description= {
		"Amazing Game Dev. (Somewhat) Knows many languages, including: JavaScript, p5, processing, Java, C#, and python.",
		"Worked using: Unity, Visual Studio, VS Code, Unreal, Processing IDE, Eclipse, and Subline Text.",
		"This is my first FULL-ON API. Any Help would be apreciated."
	},
	Versions= { "a1.0", "a1.1" }
)
public final class Program implements Runnable {
	
	/**
	 * The Max Ticks Per Seconds allowed.
	 */
	private final int MAX_TPS;
	
	/**
	 * Tells the Program how long to wait for each Tick.
	 */
	private final int WAIT_MILLIS;
	
	/**
	 * The Thread that the game
	 * runs on.
	 */
	private Thread gameThread;
	
	/**
	 * The Game.
	 */
	private Game game;
	
	/**
	 * The Game Manager.
	
	 */
	private GameManager gameManager;
	
	/**
	 * The Game Window.
	 */
	private GameWindow gameWindow;
	
	private String windowName;
	
	private int fixedTPS;
	
	private int width;
	private int height;

	/**
	 * In order to create and instance of Program,
	 * you must first identify a sub-class of GameManager.
	 * 
	 * @param gameManager The Game Manager
	 * @param maxTPS The Max Tick Per Second allowed.
	 */
	public Program(GameManager gameManager, String windowName, int maxTPS, int fixedTPS, int width, int height) {
		this.gameManager = gameManager;
		this.windowName = windowName;
		this.width = width;
		this.height = height;
		this.fixedTPS = fixedTPS;
		
		MAX_TPS = maxTPS;
		WAIT_MILLIS = 1000 / MAX_TPS;
	}
	
	
	/**
	 * Starts the Game Thread.
	 */
	public void start() {
		gameThread = new Thread(this, "Game");
		gameThread.start();
	}
	
	/**
	 * Initializes the core elements
	 * of the program.
	 */
	public void init() {
		game = new Game(gameManager, fixedTPS);
		gameWindow = new GameWindow(game, windowName, width, height);
		game.init();
	}
	
	/**
	 * Runs the Thread,
	 * also starts the loop.
	 */
	public void run() {
		init();
		while (!gameWindow.shouldClose) {
			if (System.currentTimeMillis() > Time.lastTick + WAIT_MILLIS) {
				Time.deltaTime = (float) (System.currentTimeMillis() - Time.lastTick) / 1000;
				
				update();
				
				Time.lastTick = System.currentTimeMillis();
			}
		}
		System.exit(0);
	}
	
	/**
	 * Updates core elements.
	 */
	private void update() {
		gameWindow.update();
		game.update();
	}
}