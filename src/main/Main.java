package main;

import analyzer.results.MyResult;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {
        ControlPanel test = new ControlPanel("https://github.com/ajrodgar/Corest.git", "develop");
        
        ArrayList<MyResult> analyzerTest= test.getAnalyzerTest();
        
        for (MyResult result : analyzerTest) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult: "+(String)result.getResult());
        }
        
    }
}
