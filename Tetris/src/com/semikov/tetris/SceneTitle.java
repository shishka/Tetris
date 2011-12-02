package com.semikov.tetris;

import com.semikov.sprite.Button;
import com.semikov.sprite.MenuItem;

public class SceneTitle extends Scene {
	
	public SceneTitle(GameLoop game) {
		super(game);
	}

	@Override
	public void buildUI() {
		sprites.add(new MenuItem(scene, "NEW GAME", 300, 150));
		sprites.add(new MenuItem(scene, "CONTINUE", 300, 200));
		sprites.add(new MenuItem(scene, "HIGHSCORE", 300, 250));
		sprites.add(new MenuItem(scene, "MORE GAMES", 300, 300));
		sprites.add(new MenuItem(scene, "EXIT", 300, 350));
	}

	@Override
	public void selectItem(Button button) {
		if (button.name.equals("NEW GAME")) {
			game.toPlay();
		}
		if (button.name.equals("CONTINUE")) {
			game.toContinue();
		}
		if (button.name.equals("HIGHSCORE")) {
			game.toHighScore();
		}
		if (button.name.equals("MORE GAMES")) {
			game.toMoreGames();
		}
		if (button.name.equals("EXIT")) {
			System.exit(0);
		}
	}

}
