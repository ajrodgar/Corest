package analyzer;

import analyzer.results.AnalyzerResult;


public class AnalyzerFake implements Analyzer{
    String file;
    String source;
    String resultTXT;
    
    public AnalyzerFake(String key, String src) {
        this.file= key;
        this.source = src;
        calculateResultTXT();
    }
    
    private void calculateResultTXT(){
        
        resultTXT=source;
    }
    
    @Override
    public AnalyzerResult getResult() {
        
        return new AnalyzerResult("AnalyzerFake",file,resultTXT);
    }
    
}
