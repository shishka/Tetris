package com.semikov.tetris;

import com.semikov.sprite.Button;
import com.semikov.sprite.MenuItem;

public class SceneLose extends Scene {

	public SceneLose(GameLoop game) {
		super(game);
	}

	@Override
	public void buildUI() {
		Button btn = new MenuItem(scene, "LOSE", 300, 240);
		btn.dx = 20;
		btn.width = 90;
		sprites.add(btn);
	}


	@Override
	public void selectItem(Button button) {
		if (button.name.equals("LOSE")) {
			game.toTitle();
		}
	}

}
