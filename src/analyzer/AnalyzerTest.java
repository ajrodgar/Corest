package analyzer;

import analyzer.results.MyResult;


public class AnalyzerTest implements Analyzer{
    String source;
    String resultTXT;
    
    public AnalyzerTest(String src) {
        
        this.source = src;
        calculateResultTXT();
    }
    
    private void calculateResultTXT(){
        
        resultTXT=source;
    }
    
    @Override
    public MyResult getResult() {
        
        return new MyResult("\nAnalyzerTest src a analizar: "+resultTXT);
    }
    
}
