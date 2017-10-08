package zadanie2;

import java.io.*;
import javax.swing.*;

public class SlideShow extends JFrame{
	static int time, textSize;
	Picture picture = new Picture();
	
	public SlideShow(String path, int delay, int size){
		super("Slide Show");
		time = delay;
		textSize = size;
		
		File file = new File(path);
	    String FileTipe[] = {
	    		"jpg", "png", "gif"
	    };
	    
	    for(int i = 0; i < FileTipe.length; i++){
		    File [] listFiles = file.listFiles(new Filter(FileTipe[i]));
		    if(listFiles.length == 0)
		    	System.out.println( "W folderze nie ma plikow potrzebnego typu ");
		    else
		    	for(File f : listFiles){
		    		this.picture.loadImage(path + "/" + f.getName());
			    	this.add(this.picture);
			    	this.pack();
			    	this.setVisible(true);
					this.setLocationRelativeTo(null);
			    	try {
			    		Thread.sleep(time*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		    	}
	    }
	}
}