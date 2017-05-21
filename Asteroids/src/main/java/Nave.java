import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Nave extends Rectangle {
	public static final int ANCHO=50;
	public static final int ALTO=80;
	private Image imagen;
	private boolean viva=true;
    double theta=0;
    private int g2x=Fondo.WDIMENSION/2;
    private int g2y=Fondo.HDIMENSION/2;
	
	public Nave(Image img) {
		super(-ANCHO/2,(-ALTO/2)-6,ANCHO,ALTO);
		imagen=img;
	}

	public void dibujar(Graphics g, Applet a){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		    
		g2.translate(g2x, g2y);
		g2.rotate(theta);
		g2.fillRect(-100, -100, 200, 200);
		//g2.setColor(Color.MAGENTA);
		    
		g2.drawImage(imagen, x, y, a);
		//g2.drawLine(0, 0, 200, 0);

		//theta+=10;
	}

	public void avanzar(){
		g2x+=10*Math.cos((theta));
		g2y+=10*Math.sin((theta));
		System.out.println(theta);
		System.out.println(g2x);
		System.out.println(g2y);
		System.out.println();
	}

	public void girar(boolean sentido){
		if(sentido)//sentido true giro izquierda
			theta-=(Math.PI/18);
		else
			theta+=(Math.PI/18);
	}
	
	public boolean isViva() {
		return viva;
	}
	public void setViva(boolean viva) {
		this.viva = viva;
	}
}
