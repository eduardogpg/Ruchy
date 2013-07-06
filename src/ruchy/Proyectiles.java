/*
 * 16 de Agosto del 2012
 */
package ruchy;

import java.awt.*;
import javax.swing.*;


public class Proyectiles  {
Image proyectiles;
ImageIcon proyectil;
int x,y,velDisparo =20;
boolean visible;

public Proyectiles(int posx,int posy){
visible = true;    
x=posx;
y=posy;

proyectil = new ImageIcon("proyectil.png");
proyectiles = proyectil.getImage();

}

    public void movimiento(){
   x=x+velDisparo;
   if(x>1000)
       visible=false;
  }

    public int getY(){
    return y;
}
    public int getX(){
    return x;
    }

public Image getProyectil(){
    return proyectiles;

}
 public Rectangle Rectangulo(){
        int Ancho;
        int Alto;
        
        Alto = proyectiles.getHeight(null);
        Ancho =  proyectiles.getWidth(null);
        
        return new Rectangle(x,y,Alto,Ancho);
    }
}
