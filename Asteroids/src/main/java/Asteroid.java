import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
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
	public boolean keyDown(Event ev, int tecla){
    	if(tecla == 1006){	//flecha izquierda
    		nave.girar(true);
    		repaint();
    	}
    	
    	if(tecla == 1007){	//flecha derecha
    		nave.girar(false);
    		repaint();
    	}
    	if(tecla == 1004){	//flecha arriba
    		nave.avanzar();
    		repaint();
    	}
    	if(tecla == 32){	//espacio
    	}
    	return true;
    }	 
	 public boolean mouseDown(Event ev, int x, int y){
	    	
	    		if(nave.contains(x, y)){
	    			System.out.println("hola");
	    			System.out.println(x);
	    			System.out.println(y);
	    		}
	    		else
	    			System.out.println("adios");
	    		System.out.println(x);
    			System.out.println(y);
	 
	    	return true;
	    } 
	 
	 
	 
}















