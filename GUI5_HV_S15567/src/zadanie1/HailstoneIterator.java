package zadanie1;

import java.util.*;

public class HailstoneIterator implements Iterator<Integer> {
	
	private int num;
	
	public HailstoneIterator(int kek){
		num = kek;
	}
	
	@Override
	public boolean hasNext() {
		if(num > 1)
			return true;
		else
			return false;
	}

	@Override
	public Integer next() {
		if(hasNext()){
			if(num%2 == 0)
				return num = num/2;
			else
				return num = num*3+1;
		}else{
			return 0;
		}
	}
}
