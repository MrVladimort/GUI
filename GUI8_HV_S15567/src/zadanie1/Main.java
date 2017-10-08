/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie1;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
	
  public static void main(String[] args) {
	  new Main();
  }
  
  public Main(){
	  super("BEST OF THE BEST WINDOW EVER");
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  Canvas cs = new Canvas();
	  cs.setPreferredSize(new Dimension(640,480));
	  this.add(cs);
	  this.pack();
	  this.setLocationRelativeTo(null);
	  this.setVisible(true);
  }
  
  class Canvas extends JPanel{
	  public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.setColor(Color.BLACK);
		  g.drawLine(0, 0, getWidth()-1, getHeight()-1);
	  }
  }
 
}
