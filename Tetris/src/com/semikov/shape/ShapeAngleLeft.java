package com.semikov.shape;

import java.awt.Color;

import com.semikov.sprite.GameObject;
import com.semikov.sprite.Shape;

/*
 *   X
 *   X
 * X X
 * 
 */

public class ShapeAngleLeft extends Shape {

	public ShapeAngleLeft(GameObject scene) {
		super(scene);
		shape = new int[][][] 
				{{{1,1,0,0},{1,0,0,0},{1,0,0,0},{0,0,0,0}},
				{{1,1,1,0},{0,0,1,0},{0,0,0,0},{0,0,0,0}},
				{{0,1,0,0},{0,1,0,0},{1,1,0,0},{0,0,0,0}},
				{{1,0,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0}}};
		setColor(new Color(100, 100, 255));
		create();
	}


}
