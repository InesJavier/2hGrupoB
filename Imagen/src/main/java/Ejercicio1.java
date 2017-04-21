package Ejercicio1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;

public class Ejercicio1 extends Applet{
	//Image imagen;
	Graphics noseve;
	Image imagen1;
	
	/*getImage(getDocumentBase(), " "); espera dos parametros, primero el Path (la ruta que en caso de Eclipse señala a 
	el archivo .java, si pusieramos getCodeBase() señalaría al archivo .class) y luego . Devolvera un objeto de la 
	clase Image.*/
	
	public void init(){
		imagen1 = getImage(getDocumentBase(), "Ejercicio1/img/imagen1.png");
		//imagen = createImage(600, 600);
		//noseve = imagen.getGraphics();
		//noseve = imagen1.getGraphics();
	}

	public void paint(Graphics g){
		//noseve = g;
    	//noseve.setColor(Color.black);
    	//noseve.fillRect(0, 0, 600, 600);
    	//g.drawImage(imagen, 0, 0, this);
    	g.drawImage(imagen1, 0, 0, this);
    }
}
