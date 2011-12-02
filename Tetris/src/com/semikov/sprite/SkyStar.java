package com.semikov.sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SkyStar extends Sprite {

	public int size;
	public double angle, beta;
	public Polygon px = new Polygon();
	public Polygon po = new Polygon();
	public Color[] colors;
	public int color;
	
	public SkyStar(GameObject scene, int x, int y, double angle) {
		super(scene);
		
		colors = new Color[256];
		for(int i = 0; i < 256; i++) {
			colors[i] = new Color(i, i, i);
		}
		this.size = 5;
		this.angle = angle;
		this.color = 255;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void tick() {
		po.reset();
		for(int i = 0; i < px.npoints; i++) {
			po.addPoint(px.xpoints[i], px.ypoints[i]);
		}

		size += 20;
		if (size > 700) {
			scene.sprites.remove(this);
		}
		angle += 0.05;
		
		if (angle > 6.28) {
			angle -= 6.28;
		}

		double step = 6.28 / 5;
		px.reset();
		for(int i = 0; i < 6; i++) {
			int j = i;
			if (i == 5) { 
				j = 0;
			}
			int m = (int) (size * Math.sin(j * step + angle) + x);
			int n = (int) (size * Math.cos(j * step + angle) + y);
			
			px.addPoint(m, n);

			m = (int) (size * Math.sin(j * step + angle + step / 2) / 2 + x);
			n = (int) (size * Math.cos(j * step + angle + step / 2) / 2  + y);
			px.addPoint(m, n);
			
		}
		
		color -= 8;
		if (color < 0) {
			color = 0;
		}
		
	}

	
	@Override
	public void render(Graphics g, double alpha) {
		
		Polygon p = new Polygon();
		for(int i = 0; i < po.npoints; i++) {
			int m = (int)((px.xpoints[i] - po.xpoints[i]) * alpha + po.xpoints[i]);
			int n = (int)((px.ypoints[i] - po.ypoints[i]) * alpha + po.ypoints[i]);
			p.addPoint(m, n);
		}
		
		g.setColor(colors[color]);
		g.drawPolygon(p);
	}

}
