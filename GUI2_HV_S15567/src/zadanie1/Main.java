/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie1;

import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) {
	  String fname = System.getProperty("user.home") + "/tab.txt";
	  int max = 0;
	  int count = 0;
	  String s = "";
	  ArrayList<Integer> numbers = new ArrayList<Integer>();
	  
	  
	  try {
		  	FileReader fr = new FileReader(fname);
			BufferedReader bf = new BufferedReader(fr);
		
			while(s != null){
				s = bf.readLine();
				if(s != null){
					Scanner sc = new Scanner(s);
					while(sc.hasNext())
						numbers.add(Integer.parseInt(sc.next()));
					sc.close();
				}
			}
			
			bf.close();
			fr.close();
			
			for(int i = 0; i < numbers.size(); i++){
				System.out.print(numbers.get(i) + " ");
				
				if(i == 0)
					max = numbers.get(i);
				
				if(numbers.get(i) > max){
					max = numbers.get(i);
					count = 0;
				}
				
				if(numbers.get(i) == max){
					count++;
				}
			}
				
			
			if(numbers.isEmpty()){
				System.out.println("***");
			}else{
				System.out.println("\n" + max);
				
				int tab [] = new int [count];
				
				count = 0;
				
				for(int i = 0; i < numbers.size(); i++){
					if(max == numbers.get(i)){
						tab[count] = i;
						System.out.print(tab[count++] + " ");
					}
				}
				
				
			}
			
	  } catch (NumberFormatException ex){
		  System.out.println("***");
	  } catch (FileNotFoundException ex) {
		  System.out.println("***");		
	  } catch (IOException e) {
		  System.out.println("***");
	  }
  }
}

