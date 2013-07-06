/*
 * 14 de agosto del 2012
 */
package ruchy;

import javax.swing.JFrame;
public class Ruchy {

    
    public static void main(String[] args) {  
       JFrame ventana = new JFrame();
       Screen screen = new Screen();
       ventana.add(screen);
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.setSize(900,700);
       ventana.setVisible(true);
    }
}
