package objets;

import javax.swing.JFrame;

public class JThread extends Thread {

	private Cercle c;
	private JFrame frame;

	public JThread(Cercle c, int height, JFrame frame) {
		this.c = c;
		this.frame = frame;

	}

	public void run() {
		while (true) {
			try {
				c.move();
				frame.repaint();
				sleep(6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
