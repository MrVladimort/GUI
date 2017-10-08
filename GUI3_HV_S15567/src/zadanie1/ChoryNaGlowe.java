package zadanie1;

public class ChoryNaGlowe extends Pacjent {
	
	public ChoryNaGlowe(String name) {
		super(name);
	}

	public String leczenie(){
		return "aspiryna";
	}
	
	public String choroba(){
		return "glowa";
	}
	
	public String nazwisko(){
		return this.name;
	}
}
