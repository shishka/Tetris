package com.semikov.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class GameLoop extends JComponent {

	public final static int TICK_PER_SECOND = 24;
	public Scene scene;
	public Scene game = null;
	public int width, height;
	private boolean running;

	public GameLoop(int width, int height) {
        this.setEnabled(true);
        this.setFocusable(true);
        this.width = width;
        this.height = height;

        Dimension size = new Dimension(width, height);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setFocusable(true);
	}

	public void start() {
		running = true;
		run();
	}

	public void stop() {
		running = false;
	}
	
	public void run() {
		int fps = 0;
		int renderFrames = 0;
		int lastTick = -1;

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scene.mouseClicked(e);
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				scene.mouseMoved(e);
			}
		});
		
		
		toTitle();

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics og = image.getGraphics();
		Graphics g = getGraphics();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				toggleKey(arg0.getKeyCode(), true);
			}
			public void keyReleased(KeyEvent arg0) {
				toggleKey(arg0.getKeyCode(), false);
			}
		});
		
		while (running) {
			double time = System.nanoTime() / 1E9;
			int tick = (int) (time * TICK_PER_SECOND);
			double alpha = (time * TICK_PER_SECOND) - tick;
			
			if (lastTick == -1) {
				lastTick = tick;
			}
			
			while (lastTick < tick) {
				scene.tick();
				lastTick++;
				if (lastTick % TICK_PER_SECOND == 0) {
					fps = renderFrames;
					renderFrames = 0;
				}
			}

			og.setColor(Color.BLACK);
			og.fillRect(0, 0, width, height);
			scene.render(og, alpha);
			og.setColor(Color.GREEN);
			og.setFont(new Font("Arial", Font.PLAIN, 14));
			og.drawString("FPS: ".concat(String.valueOf(fps)), 10, 20);
			og.drawString("FPT: ".concat(String.valueOf(fps / TICK_PER_SECOND)), 10, 35);
			og.drawString("SPR: ".concat(String.valueOf(scene.sprites.size())), 10, 50);
			g.drawImage(image, 0, 0, width, height, null);
			
			renderFrames++;

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void toggleKey(int keyCode, boolean isPressed) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			scene.toggleKey(Scene.KEY_LEFT, isPressed);
			break;
		case KeyEvent.VK_RIGHT:
			scene.toggleKey(Scene.KEY_RIGHT, isPressed);
			break;
		case KeyEvent.VK_UP:
			scene.toggleKey(Scene.KEY_UP, isPressed);
			break;
		case KeyEvent.VK_DOWN:
			scene.toggleKey(Scene.KEY_DOWN, isPressed);
			break;
		case KeyEvent.VK_SPACE:
			scene.toggleKey(Scene.KEY_SPACE, isPressed);
			break;
		}
	}

	public void toPlay() {
		scene = new ScenePlay(this);
		game = scene;
	}

	public void toContinue() {
		if (game == null) {
			toPlay();
		}
		scene = game;
	}
	
	public void toTitle() {
		scene = new SceneTitle(this);
	}

	public void toLose() {
		scene = new SceneLose(this);
		game = null;
	}

	public void toHighScore() {
		scene = new SceneHighScore(this);
		game = null;
	}

	public void toMoreGames() {
		scene = new SceneMoreGames(this);
		game = null;
	}


}
