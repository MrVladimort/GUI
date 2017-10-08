package zadanie1;

public class Konkursant extends Spiewak {
	int index;
	static int number = 1;
	
	public Konkursant(String nazwisko) {
		super(nazwisko);
		this.index = number++;
	}

	@Override
	public String spiewaj() {
		return null;
	}
	
}
