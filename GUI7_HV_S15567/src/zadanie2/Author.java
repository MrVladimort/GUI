/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie2;

import java.util.concurrent.LinkedBlockingQueue;

public class Author implements Runnable {
    String[] text;
    LinkedBlockingQueue<String> tmp = new LinkedBlockingQueue<String>(1); 
    
    public Author(String[] text){
        this.text=text;
    }
    
    public LinkedBlockingQueue<String> getMsg(){
		return tmp;
	}
    
    @Override
    public void run() {
        for (int i=0; i<text.length; i++) {
          try {
            Thread.sleep(1000);
            tmp.put(text[i]);
          } catch(InterruptedException exc) { }
        }
       tmp = null;
    }
}