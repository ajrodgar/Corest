package main;

import analyzer.results.MyResult;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {
        Corest test = new Corest("https://github.com/ajrodgar/Corest.git", "develop");
        
       /* ArrayList<MyResult> analyzerTest= test.getAnalyzerTest();
        
        for (MyResult result : analyzerTest) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult: "+(String)result.getResult());
        }*/
        
        ArrayList<MyResult> analyzerCodeLines= test.getAnalyzerCodeLinesCounter();
        
        for (MyResult result : analyzerCodeLines) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
    }
}
