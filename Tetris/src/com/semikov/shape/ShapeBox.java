package com.semikov.shape;

import java.awt.Color;
import com.semikov.sprite.GameObject;
import com.semikov.sprite.Shape;

/*
 * X X
 * X X
 * 
 */

public class ShapeBox extends Shape {

	public ShapeBox(GameObject scene) {
		super(scene);
		shape = new int[][][]
				{{{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}},
				 {{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}},
				 {{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}},
				 {{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}}};
		setColor(new Color(255, 100, 255));
		create();
	}

}
