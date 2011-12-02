package com.semikov.sprite;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.semikov.shape.*;
import com.semikov.tetris.GameLoop;
import com.semikov.tetris.Scene;
import com.semikov.tetris.ScenePlay;

public class PlayerShape extends Sprite {
	private static int WAIT_KEY = 4;
	private static int SPEED_DOUBLE = 1;
	private static int SPEED_NORMAL = 12;
	
	private Shape shape;
	private Shape nextShape;
	public boolean[] keys;
	private int waitKey;
	private int speed;
	private Random rand;
	private GameLoop game;

	public PlayerShape(GameLoop game, Scene scene) {
		super(scene);
		this.game = game;
		keys = scene.keys;
		waitKey = 0;
		rand = new Random();
		nextShape = getRandomShape();
	}
	
	public void create() {
		speed = SPEED_NORMAL;
		
		if (shape != null) {
			if (shape.y < 2) {
				game.toLose();
			}
		}
		
		shape = nextShape;
		do {
			nextShape = getRandomShape(); 
		} while (nextShape.getClass() == shape.getClass());
		sprites.clear();
		sprites.add(shape);
		deleteLines();
	}

	private Shape getRandomShape() {
		Shape s = null;
		switch (rand.nextInt(7)) {
			case 0: s = new ShapeAngleLeft(scene); break;
			case 1: s = new ShapeAngleRight(scene); break;
			case 2: s = new ShapeBox(scene); break;
			case 3: s = new ShapeLine(scene); break;
			case 4: s = new ShapePitonBoth(scene); break;
			case 5: s = new ShapePitonLeft(scene); break;
			case 6: s = new ShapePitonLeft(scene); break;
		}
		return s;
	}

	private void deleteLines() {
		ArrayList<Sprite> list = scene.sprites;
		Element[][] field = new Element[ScenePlay.FIELD_WIDTH][ScenePlay.FIELD_HEIGHT];
		for(int i = 0; i < list.size(); i++) {
			if (Element.class.isInstance(list.get(i))) {
				Element e = (Element)list.get(i);
				field[e.x][e.y] = e;
			}
		}
		
		for(int j = 0; j < ScenePlay.FIELD_HEIGHT; j++) {
			int n = 0;
			for(int i = 0; i < ScenePlay.FIELD_WIDTH; i++) {
				if (Element.class.isInstance(field[i][j])) {
					n++;
				}
			}
			if (n == ScenePlay.FIELD_WIDTH) {
				for(int i = 0; i < ScenePlay.FIELD_WIDTH; i++) {
					for(int y = j; y > 0; y--) {
						if (field[i][y] != null) {
							field[i][y].y++;
						}
					}
					scene.sprites.remove(field[i][j]);
				}
				
			}
		}
		
	}
	
	public void move(int x, int y) {
		shape.move(x, y);
		if (scene.collision(this)) {
			shape.move(-x, -y);
			if (y == 1) {
				for(int i = 0; i < shape.sprites.size(); i++) {
					scene.sprites.add(shape.sprites.get(i));
				}
				scene.sprites.add(new SkyEngener(scene, 340, 400));
				create();
			}
		}
		
	}
	
	private void rotate() {
		shape.rotate(1);
		if (scene.collision(this)) {
			shape.rotate(-1);
		}
	}
	
	@Override
	public void tick() {
		shape.tick();
		if ((tick % speed) == 0) {
			move(0, 1);
		}

		if (waitKey > 0) {
			waitKey--;
		}
		
		tick++;
	}
	
	@Override
	public void render(Graphics g, double alpha) {
		shape.render(g, alpha);
		nextShape.move(9, 0);
		nextShape.render(g, alpha);
		nextShape.move(-9, 0);
		keyPressed();

	}

	private void keyPressed() {
		if ( waitKey == 0) {
			if (keys[Scene.KEY_RIGHT]) {
				move(1, 0);
				waitKey = WAIT_KEY;
			}
			
			if (keys[Scene.KEY_LEFT]) {
				move(-1, 0);
				waitKey = WAIT_KEY;
			}
			
			if (keys[Scene.KEY_SPACE]) {
				speed = SPEED_DOUBLE;
				waitKey = WAIT_KEY;
			}

			if (keys[Scene.KEY_UP]) {
				rotate();
				waitKey = WAIT_KEY;
			}

		}
	}
	
	
}
