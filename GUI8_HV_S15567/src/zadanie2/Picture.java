package zadanie2;

import java.awt.*;
import javax.swing.*;

public class Picture extends JPanel {
	
	Image image;
	boolean loaded = false;

	  public void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  if (image != null && loaded)
		      g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		  else{
			  g.setFont(new Font("TimesRoman", Font.PLAIN, SlideShow.textSize));
		      g.drawString("Brak obrazka", getWidth()/2 - SlideShow.textSize*3, getHeight()/2);
		  }
	  }

	  void loadImage(String imgFileName) {
		image = Toolkit.getDefaultToolkit().getImage(imgFileName);
	    MediaTracker mt = new MediaTracker(this);
	    mt.addImage(image, 1);
	    try {
	      mt.waitForID(1);
	    } catch (InterruptedException exc) {
	    }
	    int w = image.getWidth(this);
	    int h = image.getHeight(this);
	    if (w != -1 && w != 0 && h != -1 && h != 0) {
	      loaded = true;
	      setPreferredSize(new Dimension(w, h));
	    } else
	      setPreferredSize(new Dimension(200, 200));
	  }
	}