/*
 * 22 de agosto 2012
 */
package ruchy;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;

public class duks_camicases {
public ImageIcon Pato;
public Image pato;
public int y=50,x=900;
public boolean visible;
int prueba=1;
public int vel=3;

public duks_camicases(int posy){

    Pato= new ImageIcon("pato_camicase.png");
    pato = Pato.getImage();
    y=posy;
    visible=true;
}

public void camicases(){
    x -= vel;
}

public Image getimage(){
    return pato;
}

public boolean getVisible(boolean vista){
        
  if(x<110){
   visible=false;
      
  }else{
  prueba=0;
  }
 return visible;
}

public int getX(){
    return x;
}
public int getY(){
    return y;
}
 public Rectangle Rectangulo(){
        int Ancho;
        int Alto;
        
        Alto = pato.getHeight(null);
        Ancho =  pato.getWidth(null);
        
        return new Rectangle(x,y,Alto,Ancho);
    }
}
