import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Asteroid extends Applet{
	Image imgNave;
	
	Image imgfondo;
	
	Image noParpadeo;
	Graphics noseve;
	Nave nave;
	Fondo fondo;
	
	public void init(){
		imgNave=getImage(getDocumentBase(),"nave/0.png");
		imgfondo=getImage(getDocumentBase(),"fondo/0.png"); 
		noParpadeo = createImage(Fondo.WDIMENSION, Fondo.HDIMENSION);
		noseve = noParpadeo.getGraphics();
		
		
		fondo=new Fondo(imgfondo);
		nave=new Nave(Fondo.WDIMENSION/2, Fondo.HDIMENSION/2, imgNave);
		
	}
	public void paint(Graphics g){
		noseve.setColor(Color.black);
    	noseve.fillRect(0, 0, Fondo.WDIMENSION, Fondo.HDIMENSION);
    	
    	fondo.dibujar(noseve, this);
    	nave.dibujar(noseve, this);
    	
    	g.drawImage(noParpadeo, 0, 0, this);
	}
	public void update(Graphics g){
		paint(g);
	}
	
	 
	 
	 
	 
	 
	 
}















