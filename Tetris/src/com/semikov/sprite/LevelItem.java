package com.semikov.sprite;

import java.awt.Color;

public class LevelItem extends Button {
	
	public LevelItem(GameObject scene, String name, int x, int y) {
		super(scene, name, x, y);
		this.width = 40;
		if (name.length() > 1) {
			this.dx = 10;
		} else {
			this.dx = 15;
		}
		faceColor = Color.GREEN;
		
	}

}
