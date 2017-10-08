package zadanie1;

public class ChoryNaDyspepsje extends Pacjent {	
	
	public ChoryNaDyspepsje(String name) {
		super(name);
	}

	public String leczenie(){
		return "wegiel";
	}
	
	public String choroba(){
		return "dyspepsja";
	}
	
	public String nazwisko(){
		return this.name;
	}
}
