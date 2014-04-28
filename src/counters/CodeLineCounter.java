package counters;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeLineCounter {
    private int linesCounter;
    private int commentCounter;
    private boolean insideCommentBlock;    

    public CodeLineCounter(File route) throws IOException {
        this.linesCounter = 0;
        this.commentCounter = 0;
        this.insideCommentBlock = false;
        count(route);
    }

    private int count (File route) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(route));
            while ((line = reader.readLine()) != null) {
                linesCounter++;
                if (!insideCommentBlock) if (isStartingCommentBlock(line))  commentCounter++;
                if (insideCommentBlock)  if (isFinishingCommentBlock(line)) commentCounter++;
            }
            reader.close();
        } 
        
        catch (IOException FileNotFoundException){
            return -1;
        } 
        
        finally {
             if (reader != null) reader.close();
        }
        
        return 1;
    }
    
    public int countComments() throws IOException{
        return commentCounter;
    }
    
    public int countLines() throws IOException{
        return linesCounter;
    }
    
    private boolean isStartingCommentBlock(String line){
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt (i) == '/' && (i+1 < line.length())){
                switch (line.charAt(i+1)){
                    case ('/'):
                        return true;
                    case ('*'):
                        insideCommentBlock = true;
                        return false;
                }   
            }
        }
        return false;
    }

    private boolean isFinishingCommentBlock(String line) {
        if (line.contains("*/")) {
             insideCommentBlock = false;
             return true;
        }
        return false;
    }
    
    
}


