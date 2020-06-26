package me.Treidex.Game.Interface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import me.Treidex.Game.Interface.Configurations.Config;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0x22c9963da5f37f13L;
	
	private Config config;
	private int windowId;
	
	private TabbedPane tabbedPane;

	public Window(int windowId, TabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		this.windowId = windowId;
		config = new Config("window-" + this.windowId + ".config", new String[] { "Game Engine Editor", "1000", "800" });
		
		add(tabbedPane);
	}
	
	public void open() {
		config.load();
		setTitle(config.getConfig()[0]);
		setSize(Integer.valueOf(config.getConfig()[1]), Integer.valueOf(config.getConfig()[2]));
		
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent event) {
		        exit();
		    }
		});
	}
	
	public void exit() {
		config.setConfig(new String[] { config.getConfig()[0], String.valueOf(getWidth()), String.valueOf(getHeight()) });
		config.save();
		
		tabbedPane.exit();
		
		dispose();
	}
}
