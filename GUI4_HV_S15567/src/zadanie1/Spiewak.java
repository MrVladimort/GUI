/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie1;

public abstract class Spiewak {
	String nazwisko;
	
	public Spiewak(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public static String najglosniej(Spiewak[] sp) {
		int index = 0, max = 0;
		
		for(int i = 0; i < 3; i++){
			String s = sp[i].spiewaj().replaceAll("[^A-Z]", "");
			
			
			if(i == 0){
				max = s.length();
				index = i;
			}
			
			if(max < s.length()){
				max = s.length();
				index = i;
			}
		}
		
		return  sp[index].nazwisko + ": "+ sp[index].spiewaj();
	}
	
	public abstract String spiewaj();
	
	public String toString(){
		return this.nazwisko + ": " + this.spiewaj();
	}
}
