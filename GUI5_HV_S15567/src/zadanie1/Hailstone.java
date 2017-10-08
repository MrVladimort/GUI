package zadanie1;

import java.util.*;

public class Hailstone implements Iterable<Integer> {
	
	private int num;
	
	public Hailstone(int kek){
		this.num = kek;
	}
	
	public Iterator<Integer> iterator() {
	     return new HailstoneIterator(this.num);
	}
	
	private static class HailstoneIterator implements Iterator<Integer> {
	
		private int kek;
		
		public HailstoneIterator(int kek){
			this.kek = kek;
		}
		
		@Override
		public boolean hasNext() {
			if(this.kek > 1)
				return true;
			else if(this.kek == 1){
				this.kek = 0;
				return true;
			}else
				return false;
		}

		@Override
		public Integer next() {
			if(hasNext()){
				if(this.kek%2 == 0)
					return this.kek = this.kek/2;
				else
					return this.kek = this.kek*3+1;
			}else{
				return 1;
			}
		}

		@Override
		public void remove() {}
	}
}