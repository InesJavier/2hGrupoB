import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;


public class Disparo extends Rectangle{

	Image imagenes;
	int x=100;
//	int y=50;
	int velX=(int)((Math.random()*20)+5);
	
	public Disparo(Image imgs, int posY) {
		super(100, posY, 100, 30);
		imagenes = imgs;
	}
	
	public void dibujar (Graphics gg, Applet a){
		gg.drawImage(imagenes, x, y, 100, 30, a);
	}
	
	public void actualizar(){
		x+=velX;
	}

}
