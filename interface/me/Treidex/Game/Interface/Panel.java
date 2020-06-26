package me.Treidex.Game.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import me.Treidex.Game.Interface.Configurations.Config;

public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0x8b2d62b2fbcb7517L;
	
	public JTextArea editor = new JTextArea(20, 20);
	
	public String name;
	
	private Config config;
	private int panelId;

	public Panel(int panelId) {
		this.panelId = panelId;
		config = new Config("panel-" + this.panelId + ".config", new String[] { "Panel #" + this.panelId, "\0" });
		
		config.load();
		
		name = config.getConfig()[0];
		
		editor.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 11));
		editor.setText(config.getConfig()[1]);
		JScrollPane editor_pane = new JScrollPane(editor);
		editor_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN), BorderFactory.createMatteBorder(5, 2, 2, 2, Color.GRAY)));
		
	    add(editor_pane);
	}
	
	public void exit() {
		config.setConfig(new String[] { name, editor.getText().length() > 1? editor.getText().substring(1): "\0" });
		config.save();
	}
}
