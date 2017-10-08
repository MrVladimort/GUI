package Zad2;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileNameFilter implements FilenameFilter{
    private String ext;
     
    public MyFileNameFilter(String ext){
        this.ext = ext.toLowerCase();
    }
 
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}

