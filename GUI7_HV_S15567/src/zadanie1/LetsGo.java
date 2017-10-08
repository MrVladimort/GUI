package zadanie1;

import java.io.*;
import java.util.*;

public class LetsGo implements Runnable {
	String fname;
	Towar towar;
	int suma;
	Counter count;
	
	public LetsGo(String fname){
		this.fname = fname;
		count = new Counter();
		this.suma = 0;
	}

	@Override
	public void  run() {
		new Thread(() -> {
			synchronized (count) {
				try {
					FileReader fr = new FileReader(this.fname);
					Scanner sc = new Scanner(fr);
					while (sc.hasNext()) {
						this.towar = new Towar(sc.nextInt(), sc.nextInt());
						count.inc();
						
						if (count.getCount() % 200 == 0) 
							System.out.println("utworzono " + count.getCount() + " obiektow");
						
						try {
							count.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						count.notify();
					}
					this.towar = null;
					sc.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized (count) {
				while (this.towar != null) {
					this.suma += this.towar.weight;
					
					if (count.getCount() % 100 == 0)
						System.out.println("policzono wage " + count.getCount() + " towarow");
					
						count.notify();
						try {
							count.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				System.out.println(this.suma);
			}
		}).start();
	}
}
