package zadanie2;

import java.util.ArrayList;

public class Container {
	ArrayList <Flower> flowers;
	String wlasciciel;
	String nazwa;
	
	public Container(Customer customer){
		this.flowers = new ArrayList<Flower>(customer.flowers);
		this.wlasciciel = customer.name;
	}
	
	public String toString(){
		if(this.flowers.isEmpty()){
			return  nazwa + " własciciel " + this.wlasciciel + " -- pusto";
		}else{
			nazwa = nazwa + " własciciel " + this.wlasciciel + "\n";
			
			for(int i = 0; i < this.flowers.size(); i++)
				if(i < this.flowers.size() - 1)
					nazwa = nazwa + this.flowers.get(i).toString() + "\n";
				else if (i + 1 == this.flowers.size())
					nazwa = nazwa + this.flowers.get(i).toString();
			return nazwa;
		}
	}
}
