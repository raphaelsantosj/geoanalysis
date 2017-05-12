package core.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogService {
	
	FileWriter fw = null;
	BufferedWriter bw = null;
	PrintWriter out = null;
    
    public void getDataLog(String line) throws IOException{
    	try {
    	    fw = new FileWriter("log/logdownloads.txt", true);
    	    bw = new BufferedWriter(fw);
    	    out = new PrintWriter(bw);
    	    out.println(line);
    	    out.close();
    	} catch (IOException e) {
    	}
    	finally {
			if(out != null) out.close();
    	    if(bw != null) bw.close();
    	    if(fw != null) fw.close();
    	}
    }
}
