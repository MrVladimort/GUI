/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie2;


import java.util.*;
import java.io.*;

public class CountWords {
	String fname;
	BufferedReader br;
	
	public CountWords(String fname){
		this.fname = fname;
		try {
			FileReader fr = new FileReader(fname);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
		
	ArrayList<String> getResult(){
		ArrayList <String> list = new ArrayList <String>();
		ArrayList <String> modify = new ArrayList<String>();
		ArrayList <String> finnal = new ArrayList<String>();
		
		String s = "";
		try {
			while(s != null){
				s = br.readLine();
				if(s != null){
					s = s.replaceAll("\\p{Punct}", " ");
					Scanner sc = new Scanner(s);
					while(sc.hasNext())
						list.add(sc.next());
					sc.close();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		for(int i = 0; i < list.size(); i++){
			int count = 0;
			for(int j = 0; j < modify.size(); j++){
				if(list.get(i).equals(modify.get(j))){
					count++;
				}
			}
			if(count == 0)
				modify.add(list.get(i));
		}
		
		
		for(int i = 0; i < modify.size(); i++){
			int count = 0;
			for(int j = 0; j < list.size(); j++){
				if(modify.get(i).equals(list.get(j))){
					count++;
				}
			}
			finnal.add(modify.get(i) + " " + count);
		}
		return finnal;
	}
}  
