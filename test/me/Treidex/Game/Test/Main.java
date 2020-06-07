package me.Treidex.Game.Test;

import me.Treidex.Game.Program;

public class Main {
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		Program program = new Program(gameManager, 1337);
		program.start();
	}
}