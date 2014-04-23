package counters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    
    private final String route;
    private int lines;
    
    public LineCounter(String route) {
        this.route = route;
        lines = 0;
    }

    public int count () throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(route));
            while (reader.readLine() != null) lines++;
            reader.close();
        } 
        
        catch (Exception FileNotFoundException){
            return -1;
        } 
        
        finally {
             if (reader != null) reader.close();
        }
        
        return lines;
    }
}
