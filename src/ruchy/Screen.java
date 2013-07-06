/*
 *14 de Agosto 2012
 */
package ruchy;

//
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


class Screen extends JPanel implements ActionListener,KeyListener{
    
    Timer tiempo;
    public Image fondo;
    public ImageIcon Fondo;
    boolean life = false;
    duks_camicases Camicases;
    Player jugador;
     ArrayList patosc;
    int horda = 600;
    int puntuacion =0;
    Font font = new Font("SansSerif",Font.BOLD,24);
    int empezar =0;
    boolean vida;
   
     
   public Screen(){
        vida = true;
        Fondo = new ImageIcon("fondo.jpg");
        fondo = Fondo.getImage();
        jugador= new Player(100,100);
        patosc= new ArrayList();
        tiempo = new Timer(4,this); 
        tiempo.start();
        setFocusable(true);
        addKeyListener(this);
        
   }

    public void actionPerformed(ActionEvent evento){
       
        jugador.movimiento();
       // jugador.condicional(vida);
        
        //llama al objeto proyetil
        ArrayList proyectil = jugador.getProyectiles(); 
        for(int w=0;w<proyectil.size();w++){
        Proyectiles Arma = (Proyectiles)proyectil.get(w); //llama al objeto Proyectil
        if(Arma.visible==true)
        Arma.movimiento();
        else
        proyectil.remove(w);
        }
        //    crea los patos
        ArrayList patos = getPatosc();
        for(int p=0;p<patos.size();p++){
        duks_camicases camicases = (duks_camicases)patos.get(p);
        if(camicases.getVisible(life==true))
        camicases.camicases();
        else
        patosc.remove(p);
        }
        repaint();
 }

    public void creadorPatosc(){
    Random random = new Random();
    int horda = 1+ random.nextInt(600);
    duks_camicases ducks = new  duks_camicases(horda);
    patosc.add(ducks);
}
    
    public ArrayList getPatosc(){
    return patosc;
}
      
    public void paint(Graphics g){
        super.paint(g);
        horda -= 5;
        Horda();
       
        colicionesPatos();
        
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(fondo,0,0, this);
        g2.drawImage(jugador.getimage(),jugador.getX(), jugador.getY(),null);
        
        //Dibujas las balas 
        ArrayList balas = jugador.getProyectiles();
        for(int w=0;w<balas.size();w++){
        Proyectiles proyectil = (Proyectiles)balas.get(w);
        g2.drawImage(proyectil.getProyectil(),proyectil.getX(),proyectil.getY()+50, null);
        }
       
        
        //crea los patos Camicases 
        ArrayList Patosc2 = getPatosc();          
        for(int p=0;p<Patosc2.size();p++){        
        duks_camicases  camicases = (duks_camicases)Patosc2.get(p); 
        g2.drawImage(camicases.getimage(), camicases.getX(), camicases.getY(), null); 
        }
        
        //mensaje de perdedor
        if(empezar ==10) {
          g2.setFont(font);
          g2.setColor(Color.PINK);
          g2.drawString("Puntuacion :"+this.puntuacion,160,100);
       }else if(this.empezar==0){
          g2.setFont(font);
          g2.setColor(Color.RED);
          g2.drawString("Precione Space para comenzar  ",160,100);
    }
        if(this.puntuacion>1000){
        g2.setFont(font);
          g2.setColor(Color.RED);
          g2.drawString("Horda Final ",400,100);
        }
    }
        
        
   public void keyPressed(KeyEvent e){
     int tecla = e.getKeyCode();
     if(tecla == KeyEvent.VK_RIGHT){
      jugador.moverDerecha();
      }else if(tecla==KeyEvent.VK_LEFT) {
      jugador.moverIzquierda();
      }else if(tecla==KeyEvent.VK_UP){
      jugador.moverArriba();
      }else if(tecla==KeyEvent.VK_DOWN){
      jugador.moverAbajo();
      }else if(tecla==KeyEvent.VK_SPACE){
        
          jugador.Fire();
          empezar = 10;
      
      }else if(tecla==KeyEvent.VK_S){
      jugador.Stop();
      }
      }


    public void keyTyped(KeyEvent e) {
    }
    
    
  public void keyReleased(KeyEvent e) {
  }
  
    public void Horda(){
        if(horda < 0){
            {
            creadorPatosc();
            horda = 400;
            }
            if(puntuacion>200){
                creadorPatosc();
                horda = 100;
                }
        }
    }
  
   
   public void colicionesPatos(){
   
                
        ArrayList balas = jugador.getProyectiles();
        for(int w=0;w<balas.size();w++){
        Proyectiles proyectil = (Proyectiles)balas.get(w);
        Rectangle x = proyectil.Rectangulo();
       
        ArrayList Patosc2 = getPatosc();          
        for(int p=0;p<Patosc2.size();p++){        
        duks_camicases  camicases = (duks_camicases)Patosc2.get(p); 
        Rectangle y = camicases.Rectangulo();
        
        Rectangle player;
        player = jugador.Rectangulo();

        if(x.intersects(y)){
        Patosc2.remove(p);
        balas.remove(w);
        puntuacion = puntuacion +10;
        }else if(player.intersects(y)){
        vida=false;
        jugador.visible=false;
      }
     }
    }
   }
   
}


   


   
  
  

