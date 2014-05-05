package analyzer;




import analyzer.results.MyResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyzerCodeLinesCounter implements Analyzer{
    private int linesCounter;
    private int commentCounter;
    private boolean insideCommentBlock;
    private final String[] file;
    private String src;

    public AnalyzerCodeLinesCounter(String key, String file){
        this.src = key;
        this.linesCounter = 0;
        this.commentCounter = 0;
        this.insideCommentBlock = false;
        this.file = file.split("\n");
        count();
    }

    private void count () {
            for(String line : file){
                linesCounter++;
                if (!insideCommentBlock) if (isStartingCommentBlock(line))  commentCounter++;
                if (insideCommentBlock)  if (isFinishingCommentBlock(line)) commentCounter++;
            }
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

    @Override
    public MyResult getResult() {
        String res="-";
        try {
            res = "Comment lines: "+countComments()+"\nCode lines: "+countLines()+"\n";
        } catch (IOException ex) {
            Logger.getLogger(AnalyzerCodeLinesCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new MyResult("CodeLineCounter", this.src, res);
    }

}

