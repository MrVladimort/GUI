package zadanie1;

public class ChoryNaNoge extends Pacjent {

	public ChoryNaNoge(String name) {
		super(name);
	}

	public String leczenie(){
		return "gips";
	}
	
	public String choroba(){
		return "noga";
	}
	
	public String nazwisko(){
		return this.name;
	}
}
