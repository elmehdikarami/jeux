package objets;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Arm implements Form {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private double theta;
	private boolean reverse = false;
	private double r;
	private Container conteneur;

	public Arm(Container containter, double r) {
		this.r = r;
		conteneur = containter;

		theta = Math.PI;
	}

	public void paint(Graphics g) {
		x1 = conteneur.getWidth();
		y1 = conteneur.getHeight() / 2;
		x2 = (int) (r * Math.cos(theta) + x1);
		y2 = (int) (r * Math.sin(theta) + y1);
		g.drawLine(x1, y1, x2, y2);
	}

	public void move(double t) {
		if (t < 1.90 && -t < 0)
			t = 1.90;

		if (t > -1.90 && t < 0)
			t = -1.90;
		theta = t;

	}

	public double[] getLine() {
		double[] t = new double[2];

		t[0] = (double) (y1 - y2) / (x1 - x2);
		t[1] = y1 - (t[0] * x1);
		return t;

	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

}
