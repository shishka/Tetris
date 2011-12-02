package com.semikov.sprite;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.MouseEvent;

public abstract class GameObject {
	public ArrayList<Sprite> sprites;
	public int tick = 0;
	public GameObject scene;

	public GameObject(GameObject scene) {
		this.scene = scene;
		sprites = new ArrayList<Sprite>();
	}

	public void tick() {
		tick++;
		for(int i = 0; i < sprites.size(); i++) {
			sprites.get(i).tick();
		}
	}
	
	public void render(Graphics g, double alpha) {
		for(int i = 0; i < sprites.size(); i++) {
			sprites.get(i).render(g, alpha);
		}
	}


	public ArrayList<GameObject> getOjects() {
		ArrayList<GameObject> list = new ArrayList<GameObject>();
		for(int i = 0; i < sprites.size(); i++) {
			list.add(sprites.get(i));
			list.addAll(sprites.get(i).getOjects());
		}
		return list;
	}
	
	
	private boolean collisionOfElement(ArrayList<GameObject> list, Element e) {
		for(int j = 0; j < list.size(); j++) {
			if (Element.class.isInstance(list.get(j))) {
				Element eo = (Element)list.get(j);
				if ( (eo.x == e.x) && (eo.y == e.y) && (eo != e) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean collision(GameObject obj) {
		ArrayList<GameObject> listObj = obj.getOjects();
		ArrayList<GameObject> listThis = this.getOjects();
		
		for(int i = 0; i < listObj.size(); i++) {
			GameObject o = listObj.get(i);
			if (Element.class.isInstance(o)) {
				Element eo = (Element)o;
				if ( (eo.x < 0) || (eo.x > 9) || (eo.y > 19) ) {
					return true;
				}
				if (collisionOfElement(listThis, eo)) {
					return true;
				}
			}
		}
		return false;
	}

	public void mouseMoved(MouseEvent e) {
		for(Sprite sprite : sprites) {
			if (Button.class.isInstance(sprite)) {
				Button button = (Button) sprite;
				button.mouseMoved(e);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		for(Sprite sprite : sprites) {
			if (Button.class.isInstance(sprite)) {
				Button button = (Button) sprite;
				button.mouseClicked(e);
				if (button.onFocus) {
					selectItem(button);
				}
			}
		}
	}

	public void selectItem(Button button) {
	}
	
	
}
