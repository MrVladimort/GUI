/**
 *
 *  @author Chyrka Volodymyr S13596
 *
 */

package Zad2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JFrame;

public class Main {

		public static void main(String[] args)   {
			//***********************************************
		   String LinkToFolder=args[0]; 
		   int TimeCoolDoun=Integer.valueOf(args[1]);
		   BgPanel.fontSize=Integer.valueOf(args[2]);
		    //***********************************************
		    JFrame jf = new JFrame(){
		    	public void paint(Graphics g) {
		    	 super.paint(g);
		         setTitle("Animation");
		   
		         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		         setContentPane(new BgPanel());
		        }
		     };
		     jf.setVisible(true);
		     File file = new File(LinkToFolder);
		     String FileTipe[]={"gif","png","jpg"};
		     for(int i=0;i<FileTipe.length;i++){
		     File[] listFiles = file.listFiles(new MyFileNameFilter(FileTipe[i]));
		       if(listFiles.length == 0){
		         System.out.println( "W Foldere nie ma plików potrzebnego tzpu ");
		       }else{
		         for(File f : listFiles){
		        	 BgPanel.ImageLinght.add(LinkToFolder +File.separator + f.getName());
		         }
		       }
		     }
		    if( BgPanel.ImageLinght.size()<1){
				Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				BgPanel.end=true;
				BgPanel.ifend=false;
				jf.setContentPane(new BgPanel());
				jf.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
				jf.setSize((int)screenSize.getWidth()-3, (int)screenSize.getHeight());//Debug
		    }else{
		     TimerControler Timer = new TimerControler(jf,TimeCoolDoun,BgPanel.ImageLinght.size());
		     Timer.start();
		     }
		}
}
