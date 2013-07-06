/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruchy;

import javax.swing.*;

public class Menu {

JFrame frame = new JFrame("Menu principal");
JButton jugar ;
JLabel label;
JPanel panel;
public Menu(){

frame.setSize(480,600);
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
frame.setVisible(true);
panel = new JPanel();
frame.add(panel);

}
}
