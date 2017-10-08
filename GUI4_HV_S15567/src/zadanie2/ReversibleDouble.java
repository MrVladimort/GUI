package zadanie2;

public class ReversibleDouble implements Reversible {
	double num, old;
	
	public ReversibleDouble(double num) {
		this.num = num;
	}

	@Override
	public void reverse() {
		
		if(this.old == 0){
			String a = this.num + "";
			double left = Double.parseDouble(a.substring(0, a.indexOf('.')));
			double right = Double.parseDouble(a.substring(a.indexOf('.')+1));
			
			if(left == 0)
				left =+ 1;
			
			if(right == 0)
				right =+ 1;
			
			this.old = this.num;
			
			this.num = right/left;
		}else if(this.old != 0){
			this.num = this.old + 10;
		}
	}
	
	public String toString(){
		return "" + this.num;
	}
}
