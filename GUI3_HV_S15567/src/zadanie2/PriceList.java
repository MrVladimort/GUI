package zadanie2;

import java.util.ArrayList;

public class PriceList {
	ArrayList <Flower> flowers = new ArrayList <Flower>();
	
	private static PriceList instance;
	
	private PriceList(){
		
	}
	
	public static PriceList getInstance(){
		if(instance == null)
			instance = new PriceList();
		return instance;
	}

	public void put(String nazwa, double cena) {
		Flower fl = new Flower();
		fl.cena = cena;
		fl.name = nazwa;
		flowers.add(fl);
	}
	
}
