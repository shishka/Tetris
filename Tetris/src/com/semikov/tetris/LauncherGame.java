package com.semikov.tetris;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class LauncherGame extends JFrame {
	public static final int SCREEN_WIDTH = 640;
	public static final int SCREEN_HEIGHT = 480;
	
	public static void main(String[] args) {
		new LauncherGame();
	}
	
	public LauncherGame() {
		GameLoop game = new GameLoop(SCREEN_WIDTH, SCREEN_HEIGHT);
		setTitle("Ёлектрикс");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(game);
		pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
		
		setVisible(true);
		game.start();
	}
	
}
