package com.semikov.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

abstract public class Button extends Sprite {
	public final static int CORNER = 16;
	
	public Color faceColor, backColor, tempColor;
	public String name;
	public boolean onFocus = false;
	public int dx;
	public int width, height;
	
	public Button(GameObject scene, String name, int x, int y) {
		super(scene);
		this.name = name;
		this.backColor = Color.GRAY;
		this.width = 250;
		this.height = 30;
		this.x = x;
		this.y = y;
		this.dx = 50;
		this.faceColor = Color.ORANGE;
		this.tempColor = this.backColor;
	}

	@Override
	public void tick() {
		if (onFocus) {
			if ((tick / 4) % 2 == 0) {
				tempColor = faceColor;
			} else {
				tempColor = backColor;
			}
		}
	}

	@Override
	public void render(Graphics g, double alpha) {
		g.setColor(tempColor);
		g.fillRoundRect(x, y, width, height, CORNER, CORNER);
		g.setColor(Color.WHITE);
		g.drawRoundRect(x, y, width, height, CORNER, CORNER);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", Font.BOLD, 16));
		g.drawString(name, x + dx, y + 21);
	}

	private boolean onBound(Point p) {
		return ( (p.x > x) && (p.y > y) && (p.x < (x + width)) && (p.y < (y + height)) ); 
	}
	
	public void mouseEnter(MouseEvent e) {
		tick = 0;
	}
	
	public void mouseExit(MouseEvent e) {
		tempColor = backColor;
	}

	public void mouseMoved(MouseEvent e) {
		if (onBound(e.getPoint())) {
			if (!onFocus) {
				mouseEnter(e);
				onFocus = true;
			}
		} else {
			if (onFocus) {
				mouseExit(e);
				onFocus = false;
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (onBound(e.getPoint())) {
		}
	}
	
}
