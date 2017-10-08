package zadanie1;

import java.util.*;

public class Letters extends Thread {
	ArrayList<Thread> tr = new ArrayList<Thread>();
	
	public Letters(String s){
		for(int i = 0; i < s.length(); i++){
			char bukwa = s.charAt(i);
			Runnable runthread = () ->{
				while(true){
					try{
                        System.out.print(bukwa);
                        Thread.sleep(1500);
                    }catch(InterruptedException ex){
                        break;
                    }
				}
			};
			this.tr.add(new Thread(runthread,"Thread " + bukwa));
		}
	}

	public ArrayList<Thread> getThreads() {
		return this.tr;
	}
}