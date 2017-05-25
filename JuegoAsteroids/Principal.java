package JuegoAsteroids;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public class Principal extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int NUMPELOTAS = 5;
	Thread animacion;
	Image imagen;
	Graphics ver;
	Image[][] fotogramas;
	Asteroides aster;
	String elementos[] = { "JuegoAsteroids/Imagenes/a" };
	List<Asteroides> asteroids;
	static Image roca;
	static ImageObserver roc;

	public void init() {
		imagen = this.createImage(700, 700);

		roca = getImage(getDocumentBase(), "JuegoAsteroids/Imagenes/a1.png");

		asteroids = new ArrayList<Asteroides>();
		for (int i = 0; i < NUMPELOTAS; i++)
			asteroids.add(new Asteroides((int) (Math.random()), (int) (Math.random()), 100));

		ver = imagen.getGraphics();

	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		ver.setColor(Color.black);
		ver.fillRect(0, 0, 700, 700);

		for (int i = 0; i < asteroids.size(); i++)
			asteroids.get(i).dibujar(ver);

		g.drawImage(imagen, 0, 0, this);

	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		while (true) {
			for (int i = 0; i < asteroids.size(); i++) {
				asteroids.get(i).actualizar();
			}
			repaint();

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
