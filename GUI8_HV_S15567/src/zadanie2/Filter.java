package zadanie2;

import java.io.*;

public class Filter implements FilenameFilter{
    String s;
     
    public Filter(String s){
        this.s = s.toLowerCase();
    }
 
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(s);
    }
}