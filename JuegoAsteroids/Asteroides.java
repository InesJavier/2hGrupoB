package JuegoAsteroids;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Asteroides extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int velX, velY;

	public Asteroides(int posX, int posY, int anchura) {
		posX = x;
		posY = y;
		width = anchura;
		height = anchura;
		velX = (int) ((Math.random() * 5) + 1);
		velY = 0;
	}

	public void dibujar(Graphics g) {
		g.drawImage(Principal.roca, x, y, width, height, Principal.roc);
	}

	public void actualizar() {
		x += velX;
		y += velY;
		// if ((x >= 600) || (x <= 0))
		// velX = -velX;
		// if ((y >= 600) || (y <= 0))
		// velY = -velY;
		if (x > 600)
			x = 0;
		if (y > 600)
			y = 0;
	}

}