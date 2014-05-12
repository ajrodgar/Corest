package corest;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import java.util.List;

public class Test {


    public static void main(String[] args) throws Exception {
        Corest repositoryAnalyzer = new Corest("https://github.com/ajrodgar/Corest.git", "develop");
        
        System.out.println("CODE LINES:");
        
       List<Analysis> analyzerCodeLines= repositoryAnalyzer.getAnalyzerCodeLineCounter();
        
        for (Analysis result : analyzerCodeLines) {
            System.out.println("\n"+result.getAnalyzerName()+" ("+result.getAnalyzedObjectName()+")"+"\nResult:\n"+(String)result.getAnalysisResult());
        }
        
        System.out.println("CYCLOMATIC COMPLEXITY:");
        
       List<Analysis> analyzerCyclomaticComplexity= repositoryAnalyzer.getAnalyzerCyclomaticComplexity();
        
        for (Analysis result : analyzerCyclomaticComplexity) {
            System.out.println("\n"+result.getAnalyzerName()+" ("+result.getAnalyzedObjectName()+")"+"\nResult:\n"+(String)result.getAnalysisResult());
        }
        
        /*
        ---------------Enable when AnalyzerLackOfCohesion is fixed----------------------------------------
        
        System.out.println("LACK OF COHESION:");
        
        ArrayList<AnalyzerResult> analyzerLackOfCohesion= repositoryAnalyzer.getAnalyzerLackOfCohesionMethod();
                
        for (Analysis result : analyzerLackOfCohesion) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        */
    }
}
