package me.Treidex.Game.Interface;

import javax.swing.JTabbedPane;

import me.Treidex.Game.Interface.Configurations.Config;

public class TabbedPane extends JTabbedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 0xe3dc4fe547dbdceaL;
	
	private Config config;
	private int tabbedPaneId;
	
	private Panel[] panels;

	public TabbedPane(int tabbedPaneId) {
		this.tabbedPaneId = tabbedPaneId;
		config = new Config("tabbed_pane-" + this.tabbedPaneId + ".config", new String[] { "1" });
		
		panels = new Panel[Integer.valueOf(config.getConfig()[0])];
		for (int i = 0; i < Integer.valueOf(config.getConfig()[0]); i++) {
			panels[i] = new Panel(i);
			addTab(panels[i].name, panels[i]);
		}
	}
	
	public void exit() {
		config.setConfig(new String[] { String.valueOf(panels.length) });
		
		for (Panel p: panels)
			p.exit();
	}
}
