package main;

import analyzer.results.AnalyzerResult;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {
        Corest test = new Corest("https://github.com/ajrodgar/Corest.git", "develop");
        
       /* ArrayList<MyResult> analyzerTest= test.getAnalyzerTest();
        
        for (MyResult result : analyzerTest) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult: "+(String)result.getResult());
        }*/
        
        ArrayList<AnalyzerResult> analyzerCodeLines= test.getAnalyzerCodeLinesCounter();
        
        for (AnalyzerResult result : analyzerCodeLines) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
        ArrayList<AnalyzerResult> analyzerCyclomaticComplexity= test.getAnalyzerCyclomaticComplexity();
        
        for (AnalyzerResult result : analyzerCyclomaticComplexity) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
    }
}
