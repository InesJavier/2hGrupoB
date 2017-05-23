import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Asteroid extends Applet implements Runnable{
	Image imgNave;
	Image imgFondo;
	Image imgDisparo;
	Nave nave;
	Fondo fondo;
	List<Disparo>disparos;

	
	Image noParpadeo;
	Graphics noseve;
	Thread animacion;
	List<Disparo> disparos;
	
	public void init(){
		imgNave=getImage(getDocumentBase(),"nave/0.png");
		imgFondo=getImage(getDocumentBase(),"fondo/0.png"); 
		imgDisparo=getImage(getDocumentBase(),"disparos/bala.png");

		noParpadeo = createImage(Fondo.WDIMENSION, Fondo.HDIMENSION);
		noseve = noParpadeo.getGraphics();
		
		disparos = new ArrayList<Disparo>();
		for(int i=0; i<0; i++)
    		disparos.add(new Disparo(imgDisparo,(int)nave.getX()-nave.ANCHO/2,(int)nave.getY()-nave.ALTO/2,nave.theta));
		
		fondo=new Fondo(imgFondo);
		nave=new Nave(imgNave);
	}
	public void start(){
    	animacion = new Thread(this);
    	animacion.start(); 
    }
	public void paint(Graphics g){
		noseve.setColor(Color.black);
    noseve.fillRect(0, 0, Fondo.WDIMENSION, Fondo.HDIMENSION);
    	
    fondo.dibujar(noseve, this);
    for(int i=0; i<disparos.size(); i++)
      disparos.get(i).dibujar(noseve,this);  	
		g.drawImage(noParpadeo, 0, 0, this);
		nave.dibujar(g, this);
	}
	public void update(Graphics g){
		paint(g);
	}
	public void run(){
		while(true){
			for(int i=0; i<disparos.size(); i++){
				disparos.get(i).actualizar();
				if(disparos.get(i).x>=Fondo.WDIMENSION || disparos.get(i).x<=0 || disparos.get(i).y>=Fondo.HDIMENSION || disparos.get(i).x<=0){
					disparos.remove(i);
				}
			}
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
    		disparos.add(new Disparo(imgDisparo,(int)nave.getX()+nave.ANCHO/2,(int)nave.getY()+nave.ALTO/2,nave.theta));
    		repaint();
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















