package com.semikov.tetris;

import com.semikov.sprite.Button;
import com.semikov.sprite.MenuItem;

public class SceneMoreGames extends Scene {

	public SceneMoreGames(GameLoop game) {
		super(game);
	}

	@Override
	public void buildUI() {
		Button btn = new MenuItem(scene, "BACK", 30, 410);
		btn.dx = 20;
		btn.width = 90;
		sprites.add(btn);
	}

	@Override
	public void selectItem(Button button) {
		if (button.name.equals("BACK")) {
			game.toTitle();
		}
	}

}
