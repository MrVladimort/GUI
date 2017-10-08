/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie2;

import java.math.BigDecimal;

public class Calc{
	
	public String doCalc(String cmd) {
		
		try{
			try {
				return multiply(cmd);
			}catch (StringIndexOutOfBoundsException sob){} // multiply try
				
			try { 
				return divide(cmd);
			}catch (StringIndexOutOfBoundsException ob) {} //divide try
		          
		    try { 
			    return plus(cmd);
		    }catch (StringIndexOutOfBoundsException ex){} //plus try
		    	
		    try {   
		    	return minus(cmd);
			}catch (StringIndexOutOfBoundsException e){} //minus try
		    
		}catch (NumberFormatException e) {}
		
		return "Invalid command to calc";
	}

	public String multiply(String s){
		
	    int index = s.indexOf("*");
		
		String l = s.substring(0, index).replaceAll(" ", "");
	    String r = s.substring(index + 1).replaceAll(" ", "");
	    BigDecimal left = new BigDecimal(l);
	    BigDecimal right = new BigDecimal(r);
	    String result = left.multiply(right).toString();
	    
	    try {   
	    	result.substring(0, result.indexOf('.'));
	    	return result.substring(0, result.indexOf('.')+8);
		}catch (StringIndexOutOfBoundsException  e) {
			return result;
		}
	}
	
	public String divide(String s){

	    int index = s.indexOf("/");
		
		String l = s.substring(0, index).replaceAll(" ", "");
	    String r = s.substring(index + 1).replaceAll(" ", "");
	    BigDecimal left = new BigDecimal(l);
	    BigDecimal right = new BigDecimal(r);
	    String result = left.divide(right, 7, BigDecimal.ROUND_HALF_EVEN).toString();
	    
	    try {   
	    	return result.substring(0, result.indexOf("000000"));
		}catch (StringIndexOutOfBoundsException  e) {
			return result;
		}
	}
	
	public String minus(String s){
		
		int index = s.indexOf("-");
		
		String l = s.substring(0, index).replaceAll(" ", "");
	    String r = s.substring(index + 1).replaceAll(" ", "");
	    BigDecimal left = new BigDecimal(l);
	    BigDecimal right = new BigDecimal(r);
	    String result = left.add(right.negate()).toString();
		
	    try {   
	    	result.substring(0, result.indexOf('.'));
	    	return result.substring(0, result.indexOf('.')+8);
		}catch (StringIndexOutOfBoundsException  e) {
			return result;
		}
	}
	
	public String plus(String s){
		
		int index = s.indexOf("+");
		
		String l = s.substring(0, index).replaceAll(" ", "");
	    String r = s.substring(index + 1).replaceAll(" ", "");
	    BigDecimal left = new BigDecimal(l);
	    BigDecimal right = new BigDecimal(r);
	    String result = left.add(right).toString();
		
	    try {   
	    	result.substring(0, result.indexOf('.'));
	    	return result.substring(0, result.indexOf('.')+8);
		}catch (StringIndexOutOfBoundsException  e){
			return result;
		}
	}
}
