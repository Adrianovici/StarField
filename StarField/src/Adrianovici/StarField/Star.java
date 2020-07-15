package Adrianovici.StarField;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Star {
	
	private Random r = new Random();
	private int x = -r.nextInt(2049) + r.nextInt(2049);
	private int y = -r.nextInt(1152) + r.nextInt(1152);
	private int z = r.nextInt(1366);
	
	private int speed, starSize;
	
	public Star(int speed, int starSize) {
		this.speed = speed;
		this.starSize = starSize;
	}
	
	public void show(Graphics2D g) {
		float x1 = map((float) x / z, 0, 1, 683, 1366);
		float y1 = map((float) y / z, 0, 1, 384, 768);
		float z1 = map(z, 0, 1366, starSize, 0);
		
		g.setColor(Color.WHITE);
		g.fill(new Ellipse2D.Float(x1, y1, z1, z1));
	}
	
	public void move() {
		z -= speed;
		if (z < 1) {
			z = 1366;
			x = -r.nextInt(2049) + r.nextInt(2049);
			y = -r.nextInt(1152) + r.nextInt(1152);
		} 
		else if (z > 1366) {
			z = 1;
			x = -r.nextInt(2049) + r.nextInt(2049);
			y = -r.nextInt(1152) + r.nextInt(1152);
		}
	}
	
	private float map (float value, float oldMin, float oldMax, float newMin, float newMax) {
		return (float) (((value - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
	}
	
}
