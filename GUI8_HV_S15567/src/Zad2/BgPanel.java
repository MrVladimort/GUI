package Zad2;


import java.awt.Font;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BgPanel extends JPanel{
	static int Width=0,Height=0,fontSize;
	static boolean end=false,ifend=false;
	 static BufferedImage img=null;
	 static ArrayList<String> ImageLinght = new ArrayList<String>();
 
     BgPanel() {
        this.Width=Width;
        this.Height=Height;
        try {
        
        	img = ImageIO.read(new File(ImageLinght.get(TimerControler.ImageIndex)));
        } catch (IOException e) {}
    }
     public void paintComponent(Graphics g) {
    	 String Text=null;
         if (end==true){
         	g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
         	if(ifend==true){
         		Text="Koniec prezentacji";
         	}else{
         		Text="Brak obrazka";
         	}
            g.drawString("Koniec prezentacji" ,getWidth()/2-70, getHeight()/2);
         }else{
            g.drawImage(img, 0, 0, Width, Height, null);
         }
     }
     
   static void gGetSizeJF(){
	   Width=img.getWidth();
	   Height=img.getHeight();
   }
 
   static void gSetSizeJF(int W,int H){
	   Width=W;
	   Height=H;
   }
    
 
}