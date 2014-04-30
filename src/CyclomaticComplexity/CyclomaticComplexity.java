package CyclomaticComplexity;

import java.io.IOException;

import java.io.*;
import java.util.*;

public class CyclomaticComplexity {

    private String[] keywords = {"if", "else", "while", "case",
                                 "for", "switch", "do", "foreach",
                                 "&&", "||", "?", "catch", "default",
                                 "continue", "goto"};      
   
    public int getComplexity(String source) {

        int complexity = 1;
        String words;
        StringTokenizer stTokenizer = new StringTokenizer(source);

        while (stTokenizer.hasMoreTokens()) {
            words = stTokenizer.nextToken();
            for (String keyword : keywords) {
                if (words.contains(keyword)) {
                    complexity++;
                }
            }
        }
        return complexity;
    }
    
    public String getFile(String filePath) {             
                
		String line = null;
		try {
			String fileName = "src/CyclomaticComplexity/"+filePath+".java";
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
                        
			line = br.readLine();
                        String source = "";
                        
			while (line != null){
                            line = br.readLine();
                            source = source + line;
			}
                        
                        return source;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
                return "";
    }
}
