import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Nave extends Rectangle {
	public static final int WDIMENSION=50;
	public static final int HDIMENSION=80;
	private Image imagen;
	private int posx;
	private int posy;
	private boolean viva=true;
	
	public Nave(int posx, int posy, Image img) {
		super(posx,posy,WDIMENSION,HDIMENSION);
		imagen=img;
		this.posx=posx;
		this.posy=posy;
	}
	public void dibujar(Graphics g, Applet a){
		if(viva)
			g.drawImage(imagen, posx, posy, width,height,a);
		else
			g.drawImage(imagen, posx, posy, width,height,a);
	}

	public void avanzar(){
		posx+=10;
	}
	public boolean isViva() {
		return viva;
	}
	public void setViva(boolean viva) {
		this.viva = viva;
	}
}
