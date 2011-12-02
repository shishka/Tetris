package com.semikov.tetris;

import com.semikov.sprite.GameObject;

public abstract class Scene extends GameObject {

	public final static int KEY_LEFT = 0;
	public final static int KEY_RIGHT = 1;
	public final static int KEY_UP = 2;
	public final static int KEY_DOWN = 3;
	public final static int KEY_SPACE = 4;
	
	public GameLoop game;
	public boolean[] keys;
	public int x, y;
	
	public Scene(GameLoop game) {
		super(null);
		this.game = game;
		keys = new boolean[6];
		buildUI();
	}

	public void toggleKey(int keyCode, boolean isPressed) {
		keys[keyCode] = isPressed;
	}
	
	protected void buildUI() {
	}

}
