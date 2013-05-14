package objets;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cercle implements Form {

	protected Color couleur;
	private Rectangle rec;
	protected double y;
	protected double x;
	private Dimension dimension;
	private Container conteneur;
	private boolean reverse = false;

	public Cercle(Color pColor, int x, int y, Dimension dim,
			Container pConteneur) {
		couleur = pColor;
		this.x = x;
		this.y = y;
		dimension = dim;
		conteneur = pConteneur;
	}

	public void move() {

		if (!reverse) {
			if (y < conteneur.getHeight())
				y = y + 1;
			else
				reverse = true;
		} else {
			if (y > dimension.height)
				y -= 1;
			else
				reverse = false;
		}
	}

	@Override
	public void paint(Graphics g) {
		if (x <= 0) {
			return;
		}
		Color c = g.getColor();
		g.setColor(couleur);
		g.fillOval((int) x, (int) y, dimension.height, dimension.height);

		g.setColor(c);

	}

	public void setY(int y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Container getConteneur() {
		return conteneur;
	}

}
