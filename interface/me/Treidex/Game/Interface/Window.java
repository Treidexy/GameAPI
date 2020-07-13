package me.Treidex.Game.Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Window {

	private JFrame frmJavaEngine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmJavaEngine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		frmJavaEngine = new JFrame();
		frmJavaEngine.setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/all/icon.png")));
		frmJavaEngine.setTitle("Java Engine");
		frmJavaEngine.setSize(1000, 800);
		frmJavaEngine.setLocationRelativeTo(null);
		frmJavaEngine.setOpacity(0.96f);
		frmJavaEngine.setForeground(Color.LIGHT_GRAY);
		frmJavaEngine.getContentPane().setBackground(Color.DARK_GRAY);
		frmJavaEngine.setBackground(Color.GRAY);
		frmJavaEngine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Game = new JPanel();
		Game.setBackground(Color.DARK_GRAY);
		Game.setBounds(0, 0, frmJavaEngine.getWidth(), 500);
		frmJavaEngine.getContentPane().add(Game);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frmJavaEngine.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmFile_New = new JMenuItem("New");
		mntmFile_New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnFile.add(mntmFile_New);
		
		JMenuItem mntmFile_Open = new JMenuItem("Open...");
		mntmFile_Open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnFile.add(mntmFile_Open);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEdit_Copy = new JMenuItem("Copy");
		mntmEdit_Copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnEdit.add(mntmEdit_Copy);
		
		JMenuItem mntmEdit_Cut = new JMenuItem("Cut");
		mntmEdit_Cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnEdit.add(mntmEdit_Cut);
		
		JMenuItem mntmEdit_Paste = new JMenuItem("Paste...");
		mntmEdit_Paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnEdit.add(mntmEdit_Paste);
		
		mnEdit.add(new JSeparator());
		
		JMenuItem mntmEdit_SelectAll = new JMenuItem("Select All...");
		mntmEdit_SelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnEdit.add(mntmEdit_SelectAll);
	}

}
