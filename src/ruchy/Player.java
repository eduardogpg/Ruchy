
package ruchy;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

class Player {
    
    int x=8,y=8;
    int velx=8,vely=8;
    Image Nave;
    ImageIcon jugadorD = new ImageIcon("Ovni.png");
    ImageIcon jugadorI = new ImageIcon("pato1.png");
    static ArrayList ArregloProyectiles;
    boolean visible = true;
    
    public Player(int pox, int poy){
    
    x=pox;
    y=poy;
    ArregloProyectiles = new ArrayList();
    }
    
    public void movimiento(){
    x+=velx;
    y+=vely;
    }
    
    public void moverDerecha(){
     Nave = jugadorD.getImage();
    
    velx=5;
    vely=0;
    }
  
   public void moverIzquierda(){
    Nave = jugadorD.getImage();   
    velx=-5;
    vely=0;
 }
     
    public  void moverArriba(){
    
    vely=-5;
    velx=0;
    }
    
    public void moverAbajo(){
    vely=5;
    velx=0;
    }
   

    public void Fire(){
    Proyectiles proyectil = new Proyectiles(this.getX(),this.getY());
    ArregloProyectiles.add(proyectil);
   
    }
    public Image getimage(){
    
    if(visible = true)
    return Nave;
    return null;
    
    }
    
    public static ArrayList getProyectiles(){
    return ArregloProyectiles;
    }
    
   public int getX(){
       if((x<0)||(x>800))
           x=1;
       return x;
   }
    
    public int getY(){
        if((y<0)||(y>600))
            vely=0;
    return y;
    
}
    public void Stop(){
    velx=0;
    vely=0;
    }
    
     
    public Rectangle Rectangulo(){
        int Ancho;
        int Alto;
        
        Alto = Nave.getHeight(null);
        Ancho = Nave.getWidth(null);
        
        return new Rectangle(x,y,Alto,Ancho);
    }
          


}
