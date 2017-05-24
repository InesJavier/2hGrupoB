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
	Fondo fondo;
	List<Disparo>disparos;
	List<Nave>nave;
	
	Image noParpadeo;
	Graphics noseve;
	Thread animacion;
	
	public void init(){
		imgNave=getImage(getDocumentBase(),"nave/0.png");
		imgFondo=getImage(getDocumentBase(),"fondo/0.png"); 
		imgDisparo=getImage(getDocumentBase(),"disparos/bala.png");

		noParpadeo = createImage(Fondo.WDIMENSION, Fondo.HDIMENSION);
		noseve = noParpadeo.getGraphics();
		
		disparos = new ArrayList<Disparo>();
		for(int i=0; i<0; i++)
    		disparos.add(new Disparo(imgDisparo,(int)nave.get(0).getX()-nave.get(0).ANCHO/2,(int)nave.get(0).getY()-nave.get(0).ALTO/2,nave.get(0).theta));
		
		nave = new ArrayList<Nave>();
		for(int i=0; i<1; i++)
    		nave.add(new Nave(imgNave));
		fondo=new Fondo(imgFondo);
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
		
	for(int i=0; i<nave.size(); i++)
		nave.get(i).dibujar(g,this);  		
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void run(){
		while(true){
			for(int i=0; i<disparos.size(); i++){
				disparos.get(i).actualizar();
				if(disparos.get(i).x>=Fondo.WDIMENSION || disparos.get(i).x<=0 || disparos.get(i).y>=Fondo.HDIMENSION || disparos.get(i).y<=0){
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
    		nave.get(0).girar(true);
    		repaint();
    	}
    	
    	if(tecla == 1007){	//flecha derecha
    		nave.get(0).girar(false);
    		repaint();
    	}
    	if(tecla == 1004){	//flecha arriba
    		nave.get(0).avanzar();
    		repaint();
    	}
    	if(tecla == 32){	//espacio
    		disparos.add(new Disparo(imgDisparo,(int)nave.get(0).getX()+nave.get(0).ANCHO/2,(int)nave.get(0).getY()+nave.get(0).ALTO/2,nave.get(0).theta));
    		repaint();
    	}
    	return true;
    }	 
	 public boolean mouseDown(Event ev, int x, int y){
	    	
	    		if(nave.get(0).contains(x, y)){
	    			nave.remove(0);
	    		}
	    		else
	    			System.out.println("adios");
	    		System.out.println(x);
    			System.out.println(y);
	 
	    	return true;
	    } 
	 
	 
	 
}















