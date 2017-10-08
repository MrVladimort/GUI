package zadanie2;

public class Flower {
	int count;
	String name;
	String color;
	double cena;
	
	public Flower(){
		
	}
	
	public Flower(int count){
		this.count = count;
	}
	
	public String toString (){
		return this.name + ", kolor: " + this.color + ", ilość " + this.count + ", cena " + this.cena;
	}
}
