package zadanie2;

public class Freesia extends Flower {

	public Freesia(int count) {
		super(count);
		this.color = "żółty";
		this.name = "frezja";
		this.cena = -1;
		
		for(int i = 0; i < PriceList.getInstance().flowers.size(); i++){
			if (PriceList.getInstance().flowers.get(i).name == "frezja")
				this.cena = PriceList.getInstance().flowers.get(i).cena;
		}
	}
}
