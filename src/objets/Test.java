package objets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Test extends JFrame {
	Cercle c;
	Arm arm;
	JThread thread;
	BalleThread balleThread;
	Balle balle;

	public Test() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		arm = new Arm(this, 50);
		c = new Cercle(Color.RED, 10, 50, new Dimension(20, 20),
				getContentPane());
		thread = new JThread(c, 1, this);
		thread.start();

		// armThread.start();
		setVisible(true);

		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				Point p = e.getPoint();
				double a = Math.sqrt(Math.pow(p.x - arm.getX1(), 2)
						+ Math.pow(p.y - arm.getY1(), 2));
				double b = getHeight() / 2 - p.y;
				double theta = Math.PI;

				if (b > 0) {

					theta = -Math.PI / 2 - Math.acos(b / a);
				} else if (b < 0) {
					theta = Math.PI / 2 + Math.acos(-b / a);
				}

				arm.move(theta);
				repaint();

			}
		});
		final JFrame me = this;

		getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				double[] tab;
				tab = arm.getLine();
				balle = new Balle(Color.BLUE, arm.getX2(), arm.getY2(),
						new Dimension(10, 10), me.getContentPane());
				balleThread = new BalleThread(balle, tab[0], tab[1], me);

				balleThread.start();
			}
		});

	}

	@Override
	
	 
	public void paint(Graphics g) {
		super.paint(g);
		arm.paint(g);
		if (balle != null) {
			balle.paint(g);
			if (Math.sqrt(Math.pow(balle.getX() - c.getX(), 2)
					+ Math.pow(balle.getY() - c.getY(), 2)) < (balle
					.getDimension().height + c.getDimension().height)) {
				System.out.println("Bien joué");
				balle.setX(-100);
			}
		}
		c.paint(g);

	}

	public static void main(String[] args) {
		new Test();
	}

	public void clear(Form f) {
		f = null;
		repaint();
	}

}
