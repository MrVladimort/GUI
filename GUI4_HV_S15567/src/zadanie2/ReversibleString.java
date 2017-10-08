package zadanie2;

public class ReversibleString implements Reversible {
	String str;
	
	public ReversibleString(String str) {
		this.str = str;
	}

	@Override
	public void reverse() {
		String s = "";
		
		for(int i = this.str.length() - 1; i >= 0; i--){
	        s = s + this.str.charAt(i);
	    }
		this.str = s;
	}
	
	public String toString(){
		return ""+this.str;
	}
}
