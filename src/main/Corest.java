package main;

import analyzer.results.MyResult;
import java.util.ArrayList;

public class Corest {
    GitManager control;

    public Corest(String url) {
        this.control = new GitManager(url);
    }
    
    public Corest(String url, String branch) {
        this.control = new GitManager(url, branch);
    }
    
    public ArrayList<MyResult> getAnalyzerTest() throws Exception{
        ArrayList<MyResult> resultArray = control.analyzeAll("AnalyzerTest");
  
        return resultArray; 
    }
    
    public ArrayList<MyResult> getAnalyzerCodeLinesCounter() throws Exception{
        ArrayList<MyResult> resultArray = control.analyzeAll("AnalyzerCodeLinesCounter");
  
        return resultArray; 
    }
    
    
    
}
