package com.semikov.shape;

import java.awt.Color;

import com.semikov.sprite.Shape;
import com.semikov.tetris.Scene;

/*
 * X X
 *   X X
 * 
 */

public class ShapePitonRight extends Shape {

	public ShapePitonRight(Scene scene) {
		super(scene);
		shape = new int[][][]
				{{{1,1,0,0},{0,1,1,0},{0,0,0,0},{0,0,0,0}},
				 {{0,1,0,0},{1,1,0,0},{1,0,0,0},{0,0,0,0}},
				 {{1,1,0,0},{0,1,1,0},{0,0,0,0},{0,0,0,0}},
				 {{0,1,0,0},{1,1,0,0},{1,0,0,0},{0,0,0,0}}};
		setColor(new Color(100, 150, 255));
		create();
	}
}
