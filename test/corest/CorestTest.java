package corest;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import java.util.List;

public class CorestTest {
      public static void main(String[] args) throws Exception {
        Corest repositoryAnalyzer = new Corest("https://github.com/ajrodgar/Corest.git", "develop");
        
        /*System.out.println("CODE LINES:");
        
       List<Analys> analyzerCodeLines= repositoryAnalyzer.getAnalyzerCodeLineCounter();
        
        for (AnalyzerResult result : analyzerCodeLines) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
        System.out.println("CYCLOMATIC COMPLEXITY:");
        
       List<AnalyzerResult> analyzerCyclomaticComplexity= repositoryAnalyzer.getAnalyzerCyclomaticComplexity();
        
        for (AnalyzerResult result : analyzerCyclomaticComplexity) {
            System.out.println("\n"+result.getAnalyzer()+" ("+result.getReference()+")"+"\nResult:\n"+(String)result.getResult());
        }
        
        */
        
        System.out.println("LACK OF COHESION:");
        
        List<Analysis> analyzerLackOfCohesion= repositoryAnalyzer.getAnalyzerLackOfCohesionMethod();
                
        for (Analysis result : analyzerLackOfCohesion) {
            System.out.println("\n"+result.getAnalyzerName()+" ("+result.getAnalyzedObjectName()+")"+"\nResult:\n"+(String)result.getAnalysisResult());
        }
    }  
}
