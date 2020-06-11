package me.Treidex.Game;

import me.Treidex.Game.SuperClasses.Scene;

/**
 * Imagine the world
 * if everyone just did
 * whatever, with no organization.
 * Crazy, right?
 * That is why Managers exist.
 * This is the Manager for your game.
 * 
 * @author Treidex
 *
 */
public final class GameManager {
	
	/**
	 * The Active Scene.
	 */
	public Scene scene;
	
	/**
	 * All Scenes loaded.
	 */
	public Scene[] scenes;
	
	/**
	 * The Canvas the Game is ran on.
	 */
	protected Game runner;

	/**
	 * Initialize the Game Manage
	 * 
	 * @param scenes All the Scenes to be loaded.
	 */
	public GameManager(Scene... scenes) {
		this.scenes = scenes;
	}
	
	/**
	 * Set the Runner of the Game Manager.
	 * 
	 * @param runner The Canvas the Game is ran on.
	 */
	public void setRunner(Game runner) {
		this.runner = runner;
	}
}