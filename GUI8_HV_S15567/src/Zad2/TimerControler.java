package Zad2;

import java.awt.Dimension;
import javax.swing.JFrame;


public class TimerControler extends Thread{
	int TimeCoolDown,Time;
    int uMax;
	JFrame jf;
	static int ImageIndex=0;
	TimerControler(JFrame jf,int TimeCoolDown,int uMax){
		this.TimeCoolDown=TimeCoolDown;
		this.jf=jf;
        this.uMax=uMax;
	}
	public void run(){
	     for(int u=0, j=0;u< uMax+2;u++){
			Time=0;
			if(u<uMax){
			 while(Time!=TimeCoolDown){
				if(Time==1){
					BgPanel.gGetSizeJF();
					 jf.setSize(BgPanel.Width, BgPanel.Height);
					 jf.setSize(BgPanel.Width+1, BgPanel.Height);//debug
				}else if(Time==TimeCoolDown-1){
					 ImageIndex++;
					 if(ImageIndex>=BgPanel.ImageLinght.size()){ //MaxSize Debuge
						 ImageIndex=BgPanel.ImageLinght.size()-1;
					 }
				}else{
					BgPanel.gSetSizeJF(jf.getWidth()-16, jf.getHeight()-32);
				   jf.setContentPane(new BgPanel( ));
				}
				Time++;
			     try {
					sleep(1);
				 } catch (InterruptedException e) {e.printStackTrace();}
			}
			}else{
				j++;
				Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				if(j<=1){
				BgPanel.end=true;
				BgPanel.ifend=true;
				jf.setContentPane(new BgPanel());
				jf.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
				}else{
				 jf.setSize((int)screenSize.getWidth()-3, (int)screenSize.getHeight());//Debug
			    }
			}
	     }
		}	
}

