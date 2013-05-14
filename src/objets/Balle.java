package objets;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

public class Balle extends Cercle {

	
	private boolean initialise = false;
	private double a;
	private double b;
	public Balle(Color pColor, int x, int y, Dimension dim, Container pConteneur) {
		super(pColor, x, y, dim, pConteneur);

	}
	
	public void move(double a2, double b2) {
		if(!initialise){
			a=a2;
			b=b2;
			initialise=true;
		}
		
		if (x > 0)
			x -= 1;
		if (a > 0) {
			if (y <= 0) {
				b = a * x;
				a*=-1;
				y = a * x + b;
			}
			else y=a*x+b;
		} else {
			if (y >= getConteneur().getHeight()) {
				a*=-1;
				b = y - a * x;
				
				y = a * x + b;
			}
			else y=a*x+b;
		}

	}
}
