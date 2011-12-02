package com.semikov.sprite;

public class Sprite extends GameObject {
	
	public int x, y;

	public Sprite(GameObject scene) {
		super(scene);
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int x, int y) {
		for(int i = 0; i < sprites.size(); i++) {
			sprites.get(i).x += x;
			sprites.get(i).y += y;
		}
	}
}
