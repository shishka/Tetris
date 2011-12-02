package com.semikov.sprite;

import java.awt.Color;
import com.semikov.tetris.Scene;

abstract public class Shape extends Sprite {

	protected int[][][] shape;
	protected Scene scene;
	protected Color color;
	protected int angle;
	
	public Shape(GameObject scene) {
		super(scene);
		setPosition(4, 0);
		this.angle = 0;
	}

	public void create() {
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 4; i++) {
				if (shape[angle][i][j] == 1) {
					Element e = new Element(scene, i + x, j + y);
					e.setColor(color);
					sprites.add(e);
				}
			}
		}
	}

	public void move(int i, int j) {
		x += i;
		y += j;
		super.move(i, j);
	}
	
	
	public void rotate(int a) {
		angle += a;
		if (angle > 3) {
			angle = 0;
		}
		
		if (angle < 0) {
			angle = 3;
		}
		sprites.clear();
		create();
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
