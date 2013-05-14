package objets;

import javax.swing.JFrame;

public class BalleThread extends Thread {
	private Balle balle;
	private JFrame frame;
	double a;
	double b;

	public BalleThread(Balle balle, double a, double b, JFrame frame) {
		this.balle = balle;
		this.frame = frame;
		this.a = a;
		this.b = b;
	}

	public void run() {
		while (true) {
			try {
				if (balle.getX() <= 0) {
					balle.setX(-100);
					frame.repaint();
					
					stop();
				} else {

					balle.move(a, b);
					
					frame.repaint();
					sleep(6);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
