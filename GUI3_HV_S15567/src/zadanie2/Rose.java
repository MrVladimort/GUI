package zadanie2;

public class Rose extends Flower {

	public Rose(int count) {
		super(count);
		this.color = "czerwony";
		this.name = "róża";
		this.cena = -1;
		
		for(int i = 0; i < PriceList.getInstance().flowers.size(); i++){
			if (PriceList.getInstance().flowers.get(i).name == "róża")
				this.cena = PriceList.getInstance().flowers.get(i).cena;
		}
	}
}
