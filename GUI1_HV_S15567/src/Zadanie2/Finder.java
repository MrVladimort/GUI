/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package Zadanie2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
	String fname;
	StringBuffer sb;
	
	public Finder(String fname) {
		this.fname = fname;
		sb = new StringBuffer();
		try{
			FileReader fr = new FileReader(fname);
			int tmp = fr.read();
			while(tmp!=-1){
				sb.append((char)tmp);
				tmp = fr.read();
			}
			fr.close();
		}catch(FileNotFoundException e){
			e.getMessage();
		}catch(IOException ex){
			ex.getMessage();
		}
	}
	
	public int getIfCount(){
		int count = 0;
		String s = "if\\s?[(.*)]";
		Pattern p = Pattern.compile(s);
		s = sb.toString();
		s = s.replaceAll("\"\\s?if.*\"", "");
		s = s.replaceAll("//if.*", "");
		Matcher m = p.matcher(s);
		boolean b = m.find();
		while(b){
			b = m.find();
            count++;
		}
		return count;
	}
	
	public int getStringCount(String s){
		int count = 0;
		String str = "\\s?\\W?"+s+"\\W?\\s?";
		Pattern pat = Pattern.compile(str);
		Matcher mat = pat.matcher(sb);
		boolean bool = mat.find();
		while(bool){
			bool = mat.find();
            count++;
		}
		return count;
	}
}    
