/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie2;

public class Writer implements Runnable {
	Author author;
	
    public Writer(Author author){
        this.author = author;
    }
    
    @Override
    public void run() {
        while(author.tmp != null) {
        	try {
				System.out.println(author.getMsg().take());
			} catch (InterruptedException e) { e.printStackTrace();}
        }
    }
}