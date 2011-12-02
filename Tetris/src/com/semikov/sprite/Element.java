package com.semikov.sprite;

import java.awt.Color;
import java.awt.Graphics;
import com.semikov.tetris.ScenePlay;

public class Element extends Sprite {

	private Color color;

	public Element(GameObject scene, int x, int y) {
		super(scene);
		this.x = x;
		this.y = y;
		setColor(Color.GRAY);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void render(Graphics g, double alpha) {
		g.setColor(color);
		fillRect(g, x, y);
	}

	private void fillRect(Graphics g, int x, int y) {
		g.fillRect(ScenePlay.START_X + ScenePlay.ELEMENT_SIZE * x + 2, 
				   ScenePlay.START_Y + ScenePlay.ELEMENT_SIZE * y + 2,
				   ScenePlay.ELEMENT_SIZE - 3,
				   ScenePlay.ELEMENT_SIZE - 3);
	}

}
