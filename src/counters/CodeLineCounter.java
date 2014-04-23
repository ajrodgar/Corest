package counters;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeLineCounter {
    private int linesCounter;
    private int commentCounter;
    private boolean insideCommentBlock;
    private final String lineCommentMark = "//";
    private final String blockCommentStartMark = "/*";
    private final String blockCommentFinalMark = "*/";
    

    public CodeLineCounter(String route) throws IOException {
        linesCounter = 0;
        commentCounter = 0;
        insideCommentBlock = false;
        count(route);
    }

    private int count (String route) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(route));
            while ((line = reader.readLine()) != null) {
                linesCounter++;
                if (isCommentLine(line))  commentCounter++;
                if (isCommentBlock(line)) commentCounter++;
                
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
    

    private boolean isCommentLine(String line){
        return line.contains(lineCommentMark);
    }
    
    private boolean isCommentBlock(String line){
        return line.contains(blockCommentStartMark);
    }
}

