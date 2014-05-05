package main;

import analyzer.results.AnalyzerResult;
import java.util.ArrayList;

public class Corest {
    GitRepository repository;

    public Corest(String url) {
        this.repository = GitRepositoryLoader.loadRepository(url, "master");
    }
    
    public Corest(String url, String branch) {
        this.repository = GitRepositoryLoader.loadRepository(url, branch);
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerTest() throws Exception{
        ArrayList<AnalyzerResult> resultArray = repository.analyzeAll("AnalyzerTest");
  
        return resultArray; 
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerCodeLinesCounter() throws Exception{
        ArrayList<AnalyzerResult> resultArray = repository.analyzeAll("AnalyzerCodeLinesCounter");
  
        return resultArray; 
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerCyclomaticComplexity() throws Exception{
        ArrayList<AnalyzerResult> resultArray = repository.analyzeAll("AnalyzerCyclomaticComplexity");
  
        return resultArray; 
    }
    
    public ArrayList<AnalyzerResult> getAnalyzerLackOfCohesion() throws Exception{
        ArrayList<AnalyzerResult> resultArray = repository.analyzeAll("AnalyzerLackOfCohesion");
  
        return resultArray; 
    }
    
    
    
}
