package analyzer;




import analyzer.results.AnalyzerResult;

public class AnalyzerCodeLinesCounter implements Analyzer{
    private int linesCounter;
    private int commentCounter;
    private boolean insideCommentBlock;
    private final String[] file;
    private String key;

    public AnalyzerCodeLinesCounter(String key, String file){
        this.key = key;
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
    
    public int countComments(){
        return commentCounter;
    }
    
    public int countLines(){
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
    public AnalyzerResult getResult() {
        
        String res = "Total code lines: "+countLines()+"\nCommented lines: "+countComments()+"\n";

        return new AnalyzerResult("CodeLineCounter", this.key, res);
    }

}

