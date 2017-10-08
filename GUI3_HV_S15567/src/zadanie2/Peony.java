package zadanie2;

public class Peony extends Flower {

	public Peony(int count) {
		super(count);
		this.color = "czerwony";
		this.name = "piwonia";
		this.cena = -1;
		
		for(int i = 0; i < PriceList.getInstance().flowers.size(); i++){
			if (PriceList.getInstance().flowers.get(i).name == "piwonia")
				this.cena = PriceList.getInstance().flowers.get(i).cena;
		}
	}

}
