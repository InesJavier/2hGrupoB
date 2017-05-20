import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Asteroid extends Applet implements Runnable{
	Image imgNave;
	Image imgfondo;
	Nave nave;
	Fondo fondo;
	
	Image noParpadeo;
	Graphics noseve;
	Thread animacion;


	
	
	public void init(){
		imgNave=getImage(getDocumentBase(),"nave/0.png");
		imgfondo=getImage(getDocumentBase(),"fondo/0.png"); 
		noParpadeo = createImage(Fondo.WDIMENSION, Fondo.HDIMENSION);
		noseve = noParpadeo.getGraphics();
		
		fondo=new Fondo(imgfondo);
		nave=new Nave(imgNave);
		
	}
	public void start(){
    	animacion = new Thread(this);
    	animacion.start(); 
    }
	public void paint(Graphics g){
		noseve.setColor(Color.white);
    	noseve.fillRect(0, 0, Fondo.WDIMENSION, Fondo.HDIMENSION);
    	
    	fondo.dibujar(noseve, this);
    	g.drawImage(noParpadeo, 0, 0, this);
    	nave.dibujar(g, this);
	}
	public void update(Graphics g){
		paint(g);
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
	        }catch (InterruptedException ex) {
	        	System.out.println(ex.getMessage());
	        }
			repaint();
		}
	}
	
	 
	 
	 
	 
}















