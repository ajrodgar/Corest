package CyclomaticComplexity;

import java.io.IOException;

import java.io.*;
import java.util.*;

public class CyclomaticComplexity {
    
        private  String[] keywords = {"if","else","while","case",
                                     "for","switch","do","continue",
                                     "break","&&","||","?",":","catch",
                                     "finally","throw","throws","default","return"};

	public int calculate() {             
                
		String line = null;
		try {
			String fileName = "src/CyclomaticComplexity/nuevo.java";
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
                        
			line = br.readLine();
                        String source = "";
                        
			while (line != null){
                            line = br.readLine();
                            source = source + line;
			}
                        
                        return getComplexity(source);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
                return -1;
	}

    private int getComplexity(String source) {
        
        int complexity = 1;      
        
        String words = "";
        
        StringTokenizer stTokenizer = new StringTokenizer(source);
        
        while (stTokenizer.hasMoreTokens()){            
            words = stTokenizer.nextToken();
            for(int i = 0; i < keywords.length; i++)
                if (keywords[i].equals(words))
                    complexity++;  
        }
        return complexity;
    }
}

