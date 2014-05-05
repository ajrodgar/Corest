package main;

import analyzer.results.AnalyzerResult;
import java.util.ArrayList;

public class Test {


    public static void main(String[] args) throws Exception {
        Corest repositoryAnalyzer = new Corest("https://github.com/ajrodgar/Corest.git", "develop");
        
        System.out.println("CODE LINES:");
        
        ArrayList<AnalyzerResult> analyzerCodeLines= repositoryAnalyzer.getAnalyzerCodeLinesCounter();
        
        for (AnalyzerResult result : analyzerCodeLines) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
        System.out.println("CYCLOMATIC COMPLEXITY:");
        
        ArrayList<AnalyzerResult> analyzerCyclomaticComplexity= repositoryAnalyzer.getAnalyzerCyclomaticComplexity();
        
        for (AnalyzerResult result : analyzerCyclomaticComplexity) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
        /*
        ---------------Enable when AnalyzerLackOfCohesion is fixed----------------------------------------
        
        System.out.println("LACK OF COHESION:");
        
        ArrayList<AnalyzerResult> analyzerLackOfCohesion= repositoryAnalyzer.getAnalyzerLackOfCohesion();
                
        for (AnalyzerResult result : analyzerLackOfCohesion) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        */
    }
}
