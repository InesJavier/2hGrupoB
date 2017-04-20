import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Jugando extends Applet implements Runnable {

	Thread animacion;
	Image imagen;
	Graphics ver;
	public static final int FILAS = 5;
	public static final int COLUMNAS = 10;
	public static final int IZQ = 1;
	public static final int DER = 0;
	List<Block> panel;
	Pelota pelota;
	Raqueta raqueta;
	Color colores[] = {Color.red, Color.red, Color.yellow, Color.blue, Color.blue};

	public void init() {
		imagen = this.createImage(300, 300);
		ver = imagen.getGraphics();
		panel = new ArrayList<Block>();

		for (int i = 0; i < FILAS; i++)
			for (int j = 0; j < COLUMNAS; j++) {
				panel.add(new Block((30 * j) + 1, (15 * i) + 10, 28, 10, colores[i]));
			}

		pelota = new Pelota();
		raqueta = new Raqueta();
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		ver.setColor(Color.black);
		ver.fillRect(0, 0, 300, 300);

		for (int i = 0; i < panel.size(); i++)
			panel.get(i).paint(ver);

		pelota.paint(ver);
		raqueta.paint(ver);

		if (pelota.win) {
			ver.setColor(Color.white);
			ver.drawString("YOU WIN, PLAY AGAIN.", 75, 140);
		}

		if (pelota.lose) {
			ver.setColor(Color.white);
			ver.drawString("GAME OVER, YOU LOST, TRY AGAIN.", 50, 140);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		while (true) {
			for (int i = 0; i < panel.size(); i++) {
				if (panel.get(i).intersects(pelota))
					panel.remove(i);
			}
			pelota.actualizar(panel, raqueta);
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			} ;
		}
	}

	public boolean keyDown(Event e, int tecla) {
		if (tecla == 1006)
			raqueta.actualizar(IZQ, panel);
		if (tecla == 1007)
			raqueta.actualizar(DER, panel);
		return true;
	}
}