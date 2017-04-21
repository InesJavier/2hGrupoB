
import java.applet.Applet;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;

public class Ejercicio1 extends Applet{
	Graphics noseve;
	Image imagen1;
	
	
	public void init(){
		imagen1 = getImage(getDocumentBase(), "img/imagen1.png");
	}

	public void paint(Graphics g){
    	g.drawImage(imagen1, 0, 0, this);
    }
}
