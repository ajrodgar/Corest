package main;

import analyzer.results.AnalyzerResult;
import java.util.ArrayList;

public class Corest {
    GitRepository control;

    public Corest(String url) {
        this.control = new GitRepository(url);
    }
    
    public Corest(String url, String branch) {
        this.control = new GitRepository(url, branch);
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerTest() throws Exception{
        ArrayList<AnalyzerResult> resultArray = control.analyzeAll("AnalyzerTest");
  
        return resultArray; 
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerCodeLinesCounter() throws Exception{
        ArrayList<AnalyzerResult> resultArray = control.analyzeAll("AnalyzerCodeLinesCounter");
  
        return resultArray; 
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerCyclomaticComplexity() throws Exception{
        ArrayList<AnalyzerResult> resultArray = control.analyzeAll("AnalyzerCyclomaticComplexity");
  
        return resultArray; 
    }
    
    
    
}
