package main;

import analyzer.results.MyResult;
import java.util.ArrayList;

public class ControlPanel {
    MainController control;

    public ControlPanel(String url) {
        this.control = new MainController(url);
    }
    
    public ArrayList<MyResult> getAnalyzerTest() throws Exception{
        ArrayList<MyResult> resultArray = control.analyzeAll("AnalyzerTest");
  
        return resultArray; 
    }
    
    
    
    
}
