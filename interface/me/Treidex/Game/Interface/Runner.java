package me.Treidex.Game.Interface;

public final class Runner {
	public static final String[] configDefaults = new String[] { "1000", "800" };
	
	public static Window window;
	public static TabbedPane tabbedPane;
	
//	private static Config config = new Config("config", configDefaults);
	
	public static void main(String[] args) {
		tabbedPane = new TabbedPane(0);
		window = new Window(0, tabbedPane);
		
		window.open();
	}
}