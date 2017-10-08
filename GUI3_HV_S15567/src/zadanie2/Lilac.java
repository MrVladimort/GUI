package zadanie2;

public class Lilac extends Flower {

	public Lilac(int count) {
		super(count);
		this.color = "biały";
		this.name = "bez";
		this.cena = -1;
		
		for(int i = 0; i < PriceList.getInstance().flowers.size(); i++){
			if (PriceList.getInstance().flowers.get(i).name == "bez")
				this.cena = PriceList.getInstance().flowers.get(i).cena;
		}
	}
}
