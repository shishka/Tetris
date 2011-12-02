package com.semikov.tetris;

import java.awt.Color;
import java.awt.Graphics;

import com.semikov.sprite.Button;
import com.semikov.sprite.MenuItem;
import com.semikov.sprite.PlayerShape;

public class ScenePlay extends Scene {

	public static int FIELD_WIDTH = 10;
	public static int FIELD_HEIGHT = 20;
	public static int ELEMENT_SIZE = 20;
	public static int START_X = 250;
	public static int START_Y = 40;
	
	public PlayerShape shape;
	
	public ScenePlay(GameLoop game) {
		super(game);
		x = START_X;
		y = START_Y;
		shape = new PlayerShape(game, this);
		shape.create();
		sprites.add(shape);
	}

	
	@Override
	public void buildUI() {
		Button btn = new MenuItem(scene, "BACK", 30, 410);
		btn.dx = 20;
		btn.width = 90;
		sprites.add(btn);
	}
	
	private void drawLine(Graphics g, int x, int y, int i, int j) {
		x *= ELEMENT_SIZE;
		y *= ELEMENT_SIZE;
		i *= ELEMENT_SIZE;
		j *= ELEMENT_SIZE;
	
		x += START_X;
		y += START_Y;
		i += START_X;
		j += START_Y;
		g.drawLine(x, y, i, j);
		
	}

	private void fillRect(Graphics g, int x, int y, int i, int j) {
		x *= ELEMENT_SIZE;
		y *= ELEMENT_SIZE;
		i *= ELEMENT_SIZE;
		j *= ELEMENT_SIZE;
		
		x += START_X;
		y += START_Y;
		g.fillRect(x, y, i, j);
	}
	
	@Override
	public void render(Graphics g, double alpha) {
		g.setColor(Color.DARK_GRAY);
		fillRect(g, 0, 0, FIELD_WIDTH, FIELD_HEIGHT);
		
		g.setColor(Color.GRAY);
		for(int i = 0; i < FIELD_WIDTH + 1; i++) {
			drawLine(g, i, 0, i, FIELD_HEIGHT);
		}
		
		for(int i = 0; i < FIELD_HEIGHT + 1; i++) {
			drawLine(g, 0, i, FIELD_WIDTH, i);
		}

		g.setColor(Color.DARK_GRAY);
		fillRect(g, 12, 0, 4, 4);
		
		g.setColor(Color.GRAY);
		for(int i = 0; i < 5; i++) {
			drawLine(g, 12 + i, 0, 12 + i, 4);
		}
		
		for(int i = 0; i < 5; i++) {
			drawLine(g, 12, i, 12 + 4, i);
		}
		
		super.render(g, alpha);
	}

	@Override
	public void selectItem(Button button) {
		if (button.name.equals("BACK")) {
			game.toTitle();
		}
	}
	
}
