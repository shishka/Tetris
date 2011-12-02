package com.semikov.sprite;

import java.awt.Point;

public class SkyEngener extends Sprite {
	public double angle;
	public int size;
	public Point[] px, po; 


	public SkyEngener(GameObject scene, int x, int y) {
		super(scene);
		this.x = x;
		this.y = y;
		size = 5;
		double pi2 = 6.28;
		
		sprites.add(new SkyStar(this, x, y, 0));
		sprites.add(new SkyStar(this, x - 50, y, 0));
		sprites.add(new SkyStar(this, x, y + 50, pi2 / 4));
		sprites.add(new SkyStar(this, x + 50, y, pi2 / 2));
		sprites.add(new SkyStar(this, x, y + 50, pi2 / 4 + pi2 / 2));
	}

}
