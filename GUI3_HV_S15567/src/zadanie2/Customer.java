package zadanie2;

import java.util.ArrayList;

public class Customer {
	String name;
	double money;
	ArrayList <Flower> flowers = new ArrayList <Flower>();
	
	public Customer(String name, int money){
		this.name = name;
		this.money = money;
	}

	public void pay() {
		double paragon = 0;
		
		for(int i = 0; i < this.flowers.size(); i++){
			if(this.flowers.get(i).cena > 0){
				paragon += this.flowers.get(i).count * this.flowers.get(i).cena;
				if((this.money - paragon) < 0){
					paragon -= this.flowers.get(i).count * this.flowers.get(i).cena;
					this.flowers.remove(i--);
				}		
			}else if(this.flowers.get(i).cena <= 0)
				this.flowers.remove(i--);
		}	
		this.money -= paragon;
	}

	public String getCash() {
		return this.money + "";
	}

	public ShoppingCart getShoppingCart() {
		
		ShoppingCart sc = new ShoppingCart(this);
		
		return sc;
	}

	public void pack(Box box) {		
		this.flowers.clear();
	}

	public void get(Flower flower) {
		flowers.add(flower);
	}
}