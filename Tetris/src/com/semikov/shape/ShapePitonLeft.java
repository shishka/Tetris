package com.semikov.shape;

import java.awt.Color;
import com.semikov.sprite.GameObject;
import com.semikov.sprite.Shape;

/*
 *   X X
 * X X 
 * 
 */

public class ShapePitonLeft extends Shape {

	public ShapePitonLeft(GameObject scene) {
		super(scene);
		shape = new int[][][]
				{{{0,1,1,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}},
				 {{1,0,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0}},
				 {{0,1,1,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}},
				 {{1,0,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0}}};
		setColor(new Color(255, 150, 0));
		create();
	}



}
