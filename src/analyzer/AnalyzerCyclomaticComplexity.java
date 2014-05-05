package analyzer;
    
import analyzer.results.AnalyzerResult;
import java.util.*;

public class AnalyzerCyclomaticComplexity implements Analyzer{

    private String[] keywords = {"if", "else", "while", "case",
                                 "for", "switch", "do", "foreach",
                                 "&&", "||", "?", "catch", "default",
                                 "continue", "goto"};
    private String key;
    private int complexity;
    private String words;
    private boolean coment;
    private StringTokenizer stTokenizer;

    public AnalyzerCyclomaticComplexity(String key, String source) {
        this.key = key;
        this.complexity = 1;
        this.coment = false;
        this.stTokenizer = new StringTokenizer(source);
    }
    
    
   
    public int getComplexity() {
        
           while (stTokenizer.hasMoreTokens()) {
            words = stTokenizer.nextToken();
            for (String keyword : keywords) {
                    
                if(!coment){
                    
                     if (words.contains("/*")) coment = true;
                     if (words.contains("//")) coment = true;
                    
                     if (words.contains(keyword)) complexity++;
                        
                }
                else{
                     if (words.contains("*/")) coment = false;
                     if (words.contains("\n")) coment = false;
                }
                   
                    
            }
        }
        return complexity;
    }
    
    @Override
    public AnalyzerResult getResult() {
        String res = "Cylomatic Complexity: "+getComplexity();

        return new AnalyzerResult("CyclomaticComplexity", this.key, res);
    }
}