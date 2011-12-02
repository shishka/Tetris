package com.semikov.shape;

import java.awt.Color;
import com.semikov.sprite.GameObject;
import com.semikov.sprite.Shape;

/*
 *   X
 * X X X
 * 
 */

public class ShapePitonBoth extends Shape {
	
	public ShapePitonBoth(GameObject scene) {
		super(scene);
		shape = new int[][][]
				{{{0,1,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0}},
				 {{0,1,0,0},{0,1,1,0},{0,1,0,0},{0,0,0,0}},
				 {{0,0,0,0},{1,1,1,0},{0,1,0,0},{0,0,0,0}},
				 {{0,1,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0}}};
		setColor(new Color(0, 100, 255));
		create();
	}


}
